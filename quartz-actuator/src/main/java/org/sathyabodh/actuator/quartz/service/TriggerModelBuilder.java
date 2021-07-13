package org.sathyabodh.actuator.quartz.service;

import org.quartz.*;
import org.quartz.Trigger.TriggerState;
import org.sathyabodh.actuator.model.TriggerDetailModel;

import java.util.List;
import java.util.stream.Collectors;

public class TriggerModelBuilder {
	Scheduler scheduler;

	public TriggerModelBuilder(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public List<TriggerDetailModel> buildTriggerDetailModel(JobKey jobKey) throws SchedulerException{
		List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
		return triggers.stream().map(t->buildTriggerDetailModel(scheduler, t)).collect(Collectors.toList());
	}

	public TriggerDetailModel buildTriggerDetailModel(TriggerKey triggerKey) throws SchedulerException{
		Trigger trigger = scheduler.getTrigger(triggerKey);
		return buildTriggerDetailModel(scheduler, trigger);
	}

	private TriggerDetailModel buildTriggerDetailModel(Scheduler scheduler, Trigger trigger){
		TriggerDetailModel model = new TriggerDetailModel();
		model.setName(trigger.getKey().getName());
		model.setNextFireTime(trigger.getNextFireTime());
		model.setPreviousFireTime(trigger.getPreviousFireTime());
		model.setStartTime(trigger.getStartTime());
		model.setEndTime(trigger.getEndTime());
		model.setGroup(trigger.getKey().getGroup());
		model.setJobKey(trigger.getJobKey().toString());
		TriggerState triggerState;
		try {
			triggerState = scheduler.getTriggerState(trigger.getKey());
			model.setState(triggerState.toString());
		} catch (SchedulerException e) {
			model.setState("Could not set due to error");
		}
		return model;
	}
}
