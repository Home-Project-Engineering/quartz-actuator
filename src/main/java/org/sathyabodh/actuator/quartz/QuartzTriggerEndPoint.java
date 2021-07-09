package org.sathyabodh.actuator.quartz;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.sathyabodh.actuator.model.GroupModel;
import org.sathyabodh.actuator.model.TriggerDetailModel;
import org.sathyabodh.actuator.quartz.exception.UnsupportCronChangeExpression;
import org.sathyabodh.actuator.quartz.exception.UnsupportStateChangeException;
import org.sathyabodh.actuator.quartz.service.QuartzTriggerService;
import org.sathyabodh.actuator.quartz.service.TriggerModelBuilder;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.web.bind.annotation.RequestBody;

@WebEndpoint(id = "quartz-triggers")
public class QuartzTriggerEndPoint  {

	private final QuartzTriggerService quartzTriggerService;
	private final TriggerModelBuilder triggerModelBuilder;

	public QuartzTriggerEndPoint(QuartzTriggerService quartzTriggerService,TriggerModelBuilder builder){
		this.quartzTriggerService = quartzTriggerService;
		this.triggerModelBuilder = builder;
	}

	@ReadOperation
	public WebEndpointResponse<?> listTriggersByGroupAndName(@Selector String group, @Selector String name) {
		try {
			TriggerDetailModel model = triggerModelBuilder.buildTriggerDetailModel(new TriggerKey(name, group));
			if (model == null) {
				return new WebEndpointResponse<>(WebEndpointResponse.STATUS_NOT_FOUND);
			}
			GroupModel groupModel = new GroupModel();
			List<Object> triggerList = groupModel.getGroups().computeIfAbsent(group, k -> new ArrayList<>());
			triggerList.add(model);
			return new WebEndpointResponse<>(groupModel);

		} catch (SchedulerException e) {
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}

	@ReadOperation
	public WebEndpointResponse<?> listTriggersByGroup(@Selector String group) {
		try {
			Set<TriggerKey> triggerKeys = quartzTriggerService.getTriggerKeys(GroupMatcher.triggerGroupEquals(group));
			if (triggerKeys == null || triggerKeys.isEmpty()) {
				return new WebEndpointResponse<>(WebEndpointResponse.STATUS_NOT_FOUND);
			}
			GroupModel groupModel = new GroupModel();
			triggerKeys.forEach(key->addTriggerDetailModel(groupModel, key));
			return new WebEndpointResponse<>(groupModel);
		} catch (SchedulerException e) {
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}

	@ReadOperation
	public WebEndpointResponse<?> getAllTriggers() {
		try {
			Set<TriggerKey> triggerKeys = quartzTriggerService.getTriggerKeys(GroupMatcher.anyTriggerGroup());
			GroupModel groupModel = new GroupModel();
			triggerKeys.forEach(key->addTriggerDetailModel(groupModel, key));
			return new WebEndpointResponse<>(groupModel);
		} catch (SchedulerException e) {
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}

	private void addTriggerDetailModel(GroupModel groupModel, TriggerKey key){
		TriggerDetailModel model;
		try {
			model = triggerModelBuilder.buildTriggerDetailModel(key);
			List<Object> triggerList = groupModel.getGroups().computeIfAbsent(key.getGroup(), k -> new ArrayList<>());
			triggerList.add(model);
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}

	@WriteOperation
	public WebEndpointResponse<?> modifyTriggerCron(@Selector String group, @Selector String name, @RequestBody String cron) throws SchedulerException {
		try{
			boolean isSuccess  = quartzTriggerService.modifyTriggerCron(group, name, cron);
			int status = isSuccess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException | UnsupportCronChangeExpression e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}

	@WriteOperation
	public WebEndpointResponse<?> modifyTriggersCron(@Selector String group,@RequestBody String cron) throws SchedulerException {
		try{
			boolean isSuccess  = quartzTriggerService.modifyTriggersCron(group, cron);
			int status = isSuccess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException | UnsupportCronChangeExpression e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}

}
