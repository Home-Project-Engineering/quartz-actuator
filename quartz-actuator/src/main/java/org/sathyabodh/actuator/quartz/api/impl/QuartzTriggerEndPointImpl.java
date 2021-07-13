package org.sathyabodh.actuator.quartz.api.impl;

import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.sathyabodh.actuator.model.GroupModel;
import org.sathyabodh.actuator.model.TriggerDetailModel;
import org.sathyabodh.actuator.quartz.api.QuartzTriggerEndPoint;
import org.sathyabodh.actuator.quartz.exception.UnsupportCronChangeExpression;
import org.sathyabodh.actuator.quartz.service.impl.QuartzTriggerServiceImpl;
import org.sathyabodh.actuator.quartz.service.TriggerModelBuilder;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QuartzTriggerEndPointImpl implements QuartzTriggerEndPoint {

	private final QuartzTriggerServiceImpl quartzTriggerService;
	private final TriggerModelBuilder triggerModelBuilder;

	public QuartzTriggerEndPointImpl(QuartzTriggerServiceImpl quartzTriggerService, TriggerModelBuilder builder){
		this.quartzTriggerService = quartzTriggerService;
		this.triggerModelBuilder = builder;
	}

	@Override
	@ReadOperation
	public WebEndpointResponse<?> getTriggerByGroupAndName(@Selector String group, @Selector String name) {
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

	@Override
	@ReadOperation
	public WebEndpointResponse<?> getTriggersByGroup(@Selector String group) {
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

	@Override
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

	@Override
	@WriteOperation
	public WebEndpointResponse<?> setTriggerCron(@Selector String group, @Selector String name, @RequestBody String cron) throws SchedulerException {
		try{
			boolean isSuccess  = quartzTriggerService.modifyTriggerCron(group, name, cron);
			int status = isSuccess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportCronChangeExpression e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}

	@Override
	@WriteOperation
	public WebEndpointResponse<?> setTriggersCron(@Selector String group, @RequestBody String cron) throws SchedulerException {
		try{
			boolean isSuccess  = quartzTriggerService.modifyTriggersCron(group, cron);
			int status = isSuccess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportCronChangeExpression e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}

}
