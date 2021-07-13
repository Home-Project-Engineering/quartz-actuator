package org.sathyabodh.actuator.quartz.service;

import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.Set;

public interface QuartzTriggerService {
    Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws SchedulerException;

    Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException;

    void pauseTrigger(TriggerKey triggerKey) throws SchedulerException;

    void resumeTrigger(TriggerKey triggerKey) throws SchedulerException;

    void pauseTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException;

    void resumeTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException;

    void rescheduleJob(TriggerKey triggerKey, Trigger trigger) throws SchedulerException;

    boolean modifyTriggerStatus(String group, String name, String state)
            throws SchedulerException;

    boolean modifyTriggersStatus(String group, String state) throws SchedulerException;

    boolean modifyTriggerCron(String group, String name, String cron) throws SchedulerException;

    boolean modifyTriggersCron(String group, String cron) throws SchedulerException;
}
