package org.sathyabodh.actuator.quartz.service.impl;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.sathyabodh.actuator.quartz.api.QuartzState;
import org.sathyabodh.actuator.quartz.exception.UnsupportCronChangeExpression;
import org.sathyabodh.actuator.quartz.exception.UnsupportStateChangeException;
import org.sathyabodh.actuator.quartz.service.QuartzTriggerService;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

public class QuartzTriggerServiceImpl implements QuartzTriggerService {
    Scheduler scheduler;

    public QuartzTriggerServiceImpl(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        return scheduler.getTriggerKeys(matcher);
    }

    @Override
    public Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException {
        return scheduler.getTrigger(triggerKey);
    }

    @Override
    public void pauseTrigger(TriggerKey triggerKey) throws SchedulerException {
         scheduler.pauseTrigger(triggerKey);
    }

    @Override
    public void resumeTrigger(TriggerKey triggerKey) throws SchedulerException {
        scheduler.resumeTrigger(triggerKey);
    }

    @Override
    public void pauseTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        scheduler.pauseTriggers(matcher);
    }

    @Override
    public void resumeTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        scheduler.resumeTriggers(matcher);
    }

    @Override
    public void rescheduleJob(TriggerKey triggerKey, Trigger trigger) throws SchedulerException {
        scheduler.rescheduleJob(triggerKey,trigger);
    }

    @Override
    public boolean modifyTriggerStatus(String group, String name, String state)
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

    @Override
    public boolean modifyTriggersStatus(String group, String state) throws SchedulerException {
        GroupMatcher<TriggerKey> triggerGroupMatcher = GroupMatcher.triggerGroupEquals(group);
        Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(triggerGroupMatcher);
        if (triggerKeys == null || triggerKeys.isEmpty()) {
            return false;
        } else if (QuartzState.PAUSE.equals(state)) {
            scheduler.pauseTriggers(triggerGroupMatcher);
        } else if (QuartzState.RESUME.equals(state)) {
            scheduler.resumeTriggers(triggerGroupMatcher);
        } else {
            throw new UnsupportStateChangeException(String.format("unsupported state change. state:[%s]", state));
        }
        return true;
    }

    @Override
    public boolean modifyTriggerCron(String group, String name, String cron) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(name,group);
        CronTriggerImpl trigger = (CronTriggerImpl) scheduler.getTrigger(triggerKey);
        if(trigger==null){
            return false;
        }else{
            try {
                trigger.setCronExpression(cron);
                trigger.setStartTime(new Date());
            } catch (ParseException e) {
                throw new UnsupportCronChangeExpression(String.format("unsupported cron change. cron:[%s]", cron));
            }
            scheduler.rescheduleJob(triggerKey,trigger);
            return true;
        }
    }

    @Override
    public boolean modifyTriggersCron(String group, String cron) throws SchedulerException {
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
