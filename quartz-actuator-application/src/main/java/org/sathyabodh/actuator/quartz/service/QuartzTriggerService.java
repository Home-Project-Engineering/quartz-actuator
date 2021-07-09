package org.sathyabodh.actuator.quartz.service;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.sathyabodh.actuator.quartz.QuartzState;
import org.sathyabodh.actuator.quartz.exception.UnsupportCronChangeExpression;
import org.sathyabodh.actuator.quartz.exception.UnsupportStateChangeException;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

public class QuartzTriggerService {
    Scheduler scheduler;

    public QuartzTriggerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        return scheduler.getTriggerKeys(matcher);
    }

    public Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException {
        return scheduler.getTrigger(triggerKey);
    }

    public void pauseTrigger(TriggerKey triggerKey) throws SchedulerException {
         scheduler.pauseTrigger(triggerKey);
    }

    public void resumeTrigger(TriggerKey triggerKey) throws SchedulerException {
        scheduler.resumeTrigger(triggerKey);
    }

    public void pauseTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        scheduler.pauseTriggers(matcher);
    }

    public void resumeTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        scheduler.resumeTriggers(matcher);
    }

    public void rescheduleJob(TriggerKey triggerKey,Trigger trigger) throws SchedulerException {
        scheduler.rescheduleJob(triggerKey,trigger);
    }

    public boolean modifyTriggerStatus(String group,String name,String state)
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

    public boolean modifyTriggersStatus(String group,String state) throws SchedulerException {
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

    public boolean modifyTriggerCron(String group,String name,String cron) throws SchedulerException {
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
