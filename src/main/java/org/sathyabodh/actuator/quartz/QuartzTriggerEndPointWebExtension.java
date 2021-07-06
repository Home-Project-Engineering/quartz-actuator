package org.sathyabodh.actuator.quartz;

import org.quartz.SchedulerException;
import org.sathyabodh.actuator.quartz.exception.UnsupportCronChangeExpression;
import org.sathyabodh.actuator.quartz.exception.UnsupportStateChangeException;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.web.bind.annotation.RequestBody;

@EndpointWebExtension(endpoint=QuartzTriggerEndPoint.class)
public class QuartzTriggerEndPointWebExtension {

	private final QuartzTriggerEndPoint quartzTriggerEndPoint;

	public QuartzTriggerEndPointWebExtension(QuartzTriggerEndPoint quartzTriggerEndPoint){
		this.quartzTriggerEndPoint = quartzTriggerEndPoint;
	}

	@WriteOperation
	public WebEndpointResponse<?> modifyTriggerStatus(@Selector String group, @Selector String name, @Selector String state) throws SchedulerException {
		try{
			boolean isSucess = quartzTriggerEndPoint.modifyTriggerStatus(group, name, state);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}
	@WriteOperation
	public WebEndpointResponse<?> modifyTriggersStatus(@Selector String group,@Selector String state) throws SchedulerException {
		try{
			boolean isSucess = quartzTriggerEndPoint.modifyTriggersStatus(group, state);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}

	@WriteOperation
	public WebEndpointResponse<?> modifyTriggerCron(@Selector String group, @Selector String name,  @RequestBody String cron) throws SchedulerException {
		try{
			boolean isSucess = quartzTriggerEndPoint.modifyTriggerCron(group, name, cron);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportCronChangeExpression e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}
	@WriteOperation
	public WebEndpointResponse<?> modifyTriggersCron(@Selector String group, @RequestBody String cron) throws SchedulerException {
		try{
			boolean isSucess = quartzTriggerEndPoint.modifyTriggersCron(group, cron);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportCronChangeExpression e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}


}
