package org.sathyabodh.actuator.quartz.service;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.impl.matchers.GroupMatcher;
import org.sathyabodh.actuator.model.JobModel;

import java.util.Set;

public interface QuartzJobService {
    Set<JobKey> getJobKeys(GroupMatcher<JobKey> jobGroupMatcher) throws SchedulerException;

    JobDetail getJobDetail(JobKey jobKey) throws SchedulerException;

    void pauseJob(JobKey jobKey) throws SchedulerException;

    void resumeJob(JobKey jobKey) throws SchedulerException;

    void pauseJobs(GroupMatcher<JobKey> jobGroupMatcher) throws SchedulerException;

    void resumeJobs(GroupMatcher<JobKey> jobGroupMatcher) throws SchedulerException;

    boolean modifyJobStatus(String group, String name, String state)
            throws SchedulerException;

    boolean modifyJobsStatus(String group, String state) throws SchedulerException;

    JobModel createJobModel(JobKey key);

    void copyJobDetailModel(JobDetail jobDetail, JobModel model);
}
