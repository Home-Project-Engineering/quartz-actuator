package org.sathyabodh.actuator.quartz;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.listeners.JobChainingJobListener;
import org.sathyabodh.actuator.quartz.exception.UnsupportCronChangeExpression;
import org.sathyabodh.actuator.quartz.exception.UnsupportStateChangeException;
import org.sathyabodh.actuator.quartz.model.GroupModel;
import org.sathyabodh.actuator.quartz.model.TriggerDetailModel;
import org.sathyabodh.actuator.quartz.service.TriggerModelBuilder;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;

@Endpoint(id = "quartz-triggers")
public class QuartzTriggerEndPoint {

	private final Scheduler scheduler;
	private final TriggerModelBuilder triggerModelBuilder = new TriggerModelBuilder();

	public QuartzTriggerEndPoint(Scheduler scheduler){
		this.scheduler = scheduler;
	}

	@ReadOperation
	public GroupModel<TriggerDetailModel> listTriggers(@Nullable String group, @Nullable String name) throws SchedulerException {
		try {
			if (name != null && group != null) {
				TriggerDetailModel model = triggerModelBuilder.buildTriggerDetailModel(scheduler, new TriggerKey(name, group));
				if (model == null) {
					return null;
				}
				GroupModel<TriggerDetailModel> groupModel = new GroupModel<>();
				groupModel.add(group, model);
				return groupModel;
			}
			GroupMatcher<TriggerKey> triggerGroupMatcher = group == null ?
					GroupMatcher.anyTriggerGroup():GroupMatcher.triggerGroupEquals(group);
			Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(triggerGroupMatcher);
			if(name != null){
				triggerKeys = triggerKeys.stream().filter(key->name.equals(key.getName())).collect(Collectors.toSet());
			}
			if (triggerKeys == null || triggerKeys.isEmpty()) {
				return null;
			}
			GroupModel<TriggerDetailModel> groupModel = new GroupModel<>();
			triggerKeys.forEach(key->addTriggerDetailModel(groupModel, key));
			return groupModel;
		} catch (SchedulerException e) {
			throw e;
		}
	}

	private void addTriggerDetailModel(GroupModel<TriggerDetailModel> groupModel, TriggerKey key){
		TriggerDetailModel model;
		try {
			model = triggerModelBuilder.buildTriggerDetailModel(scheduler, key);
			groupModel.add(key.getGroup(), model);
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}

	@WriteOperation
	public boolean modifyTriggerStatus(@Selector String group, @Selector String name, @Selector String state)
			throws SchedulerException {
		TriggerKey triggerKey = new TriggerKey(name, group);
		Trigger trigger = scheduler.getTrigger(triggerKey);
		if (trigger == null)
			return false;
		else if (QuartzState.PAUSE.equals(state)) {
			scheduler.pauseTrigger(triggerKey);
		} else if (QuartzState.RESUME.equals(state)) {
			scheduler.resumeTrigger(triggerKey);
		} else {
			throw new UnsupportStateChangeException(String.format("unsupported state change. state:[%s]", state));
		}
		return true;
	}

	@WriteOperation
	public boolean modifyTriggersStatus(@Selector String group, @Selector String state) throws SchedulerException {
		GroupMatcher<TriggerKey> triggerGroupMatcher = GroupMatcher.triggerGroupEquals(group);
		Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(triggerGroupMatcher);
		if (triggerKeys == null || triggerKeys.isEmpty()) {
			return false;
		} else if (QuartzState.PAUSE.equals(state)) {
			scheduler.pauseTriggers(triggerGroupMatcher);
		} else if (QuartzState.RESUME.equals(state)) {
			scheduler.resumeTriggers((triggerGroupMatcher));
		} else {
			throw new UnsupportStateChangeException(String.format("unsupported state change. state:[%s]", state));
		}
		return true;
	}
	@WriteOperation
	public boolean modifyTriggerCron(@Selector String group, @Selector String name, @RequestBody String cron) throws SchedulerException {
		TriggerKey triggerKey = new TriggerKey(name,group);
		CronTriggerImpl trigger = (CronTriggerImpl) scheduler.getTrigger(triggerKey);
		if(trigger==null){
			return false;
		}else{
			try {
				trigger.setCronExpression(cron);
			} catch (ParseException e) {
				 throw new UnsupportCronChangeExpression(String.format("unsupported cron change. cron:[%s]", cron));
			}
			scheduler.rescheduleJob(triggerKey,trigger);
			return true;
		}
	}

	@WriteOperation
	public boolean modifyTriggersCron(@Selector String group, @RequestBody String cron) throws SchedulerException {
		Set<TriggerKey>  triggerKeys = scheduler.getTriggerKeys(GroupMatcher.groupEquals(group));

		if(triggerKeys == null || triggerKeys.isEmpty()){
			return false;
		}

		for (TriggerKey triggerKey : triggerKeys) {
			CronTriggerImpl trigger = (CronTriggerImpl)scheduler.getTrigger(triggerKey);
			try {
				trigger.setCronExpression(cron);
			} catch (ParseException e) {
				throw new UnsupportCronChangeExpression(String.format("unsupported cron change. cron:[%s]", cron));
			}
			scheduler.rescheduleJob(triggerKey,trigger);
		}
		return true;
	}

}
