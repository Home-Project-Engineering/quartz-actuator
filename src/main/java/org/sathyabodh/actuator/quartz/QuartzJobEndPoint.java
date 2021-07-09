package org.sathyabodh.actuator.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.impl.matchers.GroupMatcher;
import org.sathyabodh.actuator.model.GroupModel;
import org.sathyabodh.actuator.model.JobDetailModel;
import org.sathyabodh.actuator.model.JobModel;
import org.sathyabodh.actuator.quartz.exception.UnsupportStateChangeException;
import org.sathyabodh.actuator.quartz.service.QuartzJobService;
import org.sathyabodh.actuator.quartz.service.TriggerModelBuilder;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;


@Endpoint(id = "quartz-jobs")
public class QuartzJobEndPoint {

	private final QuartzJobService quartzJobService;


	public QuartzJobEndPoint(QuartzJobService quartzJobService) {
		this.quartzJobService = quartzJobService;
	}

	@ReadOperation
	public WebEndpointResponse<?> listJobsByGroupAndName(@Selector String group, @Selector String name)  {
		JobModel model = quartzJobService.createJobModel(new JobKey(name, group));
		if (model == null) {
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_NOT_FOUND);
		}
		GroupModel jobGroupModel = new GroupModel();
		List<Object> jobsList = jobGroupModel.getGroups().computeIfAbsent(group, k -> new ArrayList<>());
		jobsList.add(model);
		return new WebEndpointResponse<>(jobGroupModel);
	}

	@ReadOperation
	public WebEndpointResponse<?> listJobsByGroup(@Selector String group) {
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


	@ReadOperation
	public WebEndpointResponse<?> listJobs() {
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


	@WriteOperation
	public WebEndpointResponse<?> modifyJobStatus(@Selector String group, @Selector String name, @RequestBody String state) throws SchedulerException {
		try{
			boolean isSucess = quartzJobService.modifyJobStatus(group, name, state);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}
	@WriteOperation
	public WebEndpointResponse<?> modifyJobsStatus(@Selector String group,@RequestBody String state) throws SchedulerException {
		try{
			boolean isSucess = quartzJobService.modifyJobsStatus(group, state);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;

			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}
}
