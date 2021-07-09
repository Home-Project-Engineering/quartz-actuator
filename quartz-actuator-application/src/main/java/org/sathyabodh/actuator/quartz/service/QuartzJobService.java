package org.sathyabodh.actuator.quartz.service;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.matchers.GroupMatcher;
import org.sathyabodh.actuator.model.JobModel;
import org.sathyabodh.actuator.quartz.QuartzState;
import org.sathyabodh.actuator.quartz.exception.UnsupportStateChangeException;

import java.util.Set;

public class QuartzJobService {

    Scheduler scheduler;

    public QuartzJobService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }


    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> jobGroupMatcher) throws SchedulerException {
        return scheduler.getJobKeys(jobGroupMatcher);
    }

    public JobDetail getJobDetail(JobKey jobKey) throws SchedulerException {
        return scheduler.getJobDetail(jobKey);
    }

    public void pauseJob(JobKey jobKey) throws SchedulerException {
        scheduler.pauseJob(jobKey);
    }

    public void resumeJob(JobKey jobKey) throws SchedulerException {
        scheduler.resumeJob(jobKey);
    }

    public void pauseJobs(GroupMatcher<JobKey> jobGroupMatcher) throws SchedulerException {
        scheduler.pauseJobs(jobGroupMatcher);
    }

    public void resumeJobs(GroupMatcher<JobKey> jobGroupMatcher) throws SchedulerException {
        scheduler.resumeJobs(jobGroupMatcher);
    }


    public boolean modifyJobStatus(String group,String name, String state)
            throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail detail = scheduler.getJobDetail(jobKey);
        if (detail == null)
            return false;
        else if (QuartzState.PAUSE.equals(state)) {
            scheduler.pauseJob(jobKey);
        } else if (QuartzState.RESUME.equals(state)) {
            scheduler.resumeJob(jobKey);
        } else {
            throw new UnsupportStateChangeException(String.format("unsupported state change. state:[%s]", state));
        }
        return true;
    }

    public boolean modifyJobsStatus(String group, String state) throws SchedulerException{
        GroupMatcher<JobKey> jobGroupMatcher = GroupMatcher.jobGroupEquals(group);
        Set<JobKey> jobKeys = scheduler.getJobKeys(jobGroupMatcher);
        if (jobKeys == null || jobKeys.isEmpty()) {
            return false;
        }
        else if (QuartzState.PAUSE.equals(state)) {
            scheduler.pauseJobs(jobGroupMatcher);
        } else if (QuartzState.RESUME.equals(state)) {
            scheduler.resumeJobs(jobGroupMatcher);
        } else {
            throw new UnsupportStateChangeException(String.format("unsupported state change. state:[%s]", state));
        }
        return true;
    }

    public JobModel createJobModel(JobKey key){
        try {
            JobDetail jobDetail = scheduler.getJobDetail(key);
            if (jobDetail == null) {
                return null;
            }
            JobModel model = new JobModel();
            copyJobDetailModel(jobDetail, model);
            return model;

        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public void copyJobDetailModel(JobDetail jobDetail,JobModel model) {
        model.setName(jobDetail.getKey().getName());
        model.setDurable(jobDetail.isDurable());
        model.setConcurrentDisallowed(jobDetail.isConcurrentExectionDisallowed());
        model.setJobClass(jobDetail.getJobClass().getName());
    }


}
