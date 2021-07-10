package org.sathyabodh.actuator.quartz.api.impl;

import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.impl.matchers.GroupMatcher;
import org.sathyabodh.actuator.model.GroupModel;
import org.sathyabodh.actuator.model.JobModel;
import org.sathyabodh.actuator.quartz.api.QuartzJobEndPoint;
import org.sathyabodh.actuator.quartz.exception.UnsupportStateChangeException;
import org.sathyabodh.actuator.quartz.service.impl.QuartzJobServiceImpl;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QuartzJobEndPointImpl implements QuartzJobEndPoint {

	private final QuartzJobServiceImpl quartzJobService;


	public QuartzJobEndPointImpl(QuartzJobServiceImpl quartzJobService) {
		this.quartzJobService = quartzJobService;
	}

	@Override
	@ReadOperation
	public WebEndpointResponse<?> getJobByGroupAndName(@Selector String group, @Selector String name)  {
		JobModel model = quartzJobService.createJobModel(new JobKey(name, group));
		if (model == null) {
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_NOT_FOUND);
		}
		GroupModel jobGroupModel = new GroupModel();
		List<Object> jobsList = jobGroupModel.getGroups().computeIfAbsent(group, k -> new ArrayList<>());
		jobsList.add(model);
		return new WebEndpointResponse<>(jobGroupModel);
	}

	@Override
	@ReadOperation
	public WebEndpointResponse<?> getJobsByGroup(@Selector String group) {
		try {
			Set<JobKey> jobKeys = quartzJobService.getJobKeys(GroupMatcher.jobGroupEquals(group));
			if (jobKeys == null || jobKeys.isEmpty()) {
				return new WebEndpointResponse<>(WebEndpointResponse.STATUS_NOT_FOUND);
			}
			GroupModel jobGroupModel = new GroupModel();
			jobKeys.forEach(key->{JobModel model = quartzJobService.createJobModel(key);
				List<Object> jobsList = jobGroupModel.getGroups().computeIfAbsent(key.getGroup(), k -> new ArrayList<>());
				jobsList.add(model);
			});
			return new WebEndpointResponse<>(jobGroupModel);
		} catch (SchedulerException e) {
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}


	@Override
	@ReadOperation
	public WebEndpointResponse<?> getAllJobs() {
		try {
			Set<JobKey> jobKeys = quartzJobService.getJobKeys(GroupMatcher.anyJobGroup());
			if (jobKeys == null || jobKeys.isEmpty()) {
				return null;
			}
			GroupModel jobGroupModel = new GroupModel();
			jobKeys.forEach(key->{JobModel model = quartzJobService.createJobModel(key);
				List<Object> jobsList = jobGroupModel.getGroups().computeIfAbsent(key.getGroup(), k -> new ArrayList<>());
				jobsList.add(model);
			});
			return new WebEndpointResponse<>(jobGroupModel);
		} catch (SchedulerException e) {
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}


	@Override
	@WriteOperation
	public WebEndpointResponse<?> setJobState(@Selector String group, @Selector String name, @RequestBody String state) throws SchedulerException {
		try{
			boolean isSucess = quartzJobService.modifyJobStatus(group, name, state);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}
	@Override
	@WriteOperation
	public WebEndpointResponse<?> setJobsState(@Selector String group, @RequestBody String state) throws SchedulerException {
		try{
			boolean isSucess = quartzJobService.modifyJobsStatus(group, state);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;

			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}
}
