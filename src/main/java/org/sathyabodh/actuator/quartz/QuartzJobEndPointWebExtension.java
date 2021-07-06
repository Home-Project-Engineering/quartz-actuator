package org.sathyabodh.actuator.quartz;

import org.quartz.SchedulerException;
import org.sathyabodh.actuator.quartz.exception.UnsupportStateChangeException;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.web.bind.annotation.RequestBody;

@EndpointWebExtension(endpoint=QuartzJobEndPoint.class)
public class QuartzJobEndPointWebExtension {

	private final QuartzJobEndPoint quartzJobEndPoint;

	public QuartzJobEndPointWebExtension(QuartzJobEndPoint quartzJobEndPoint){
		this.quartzJobEndPoint = quartzJobEndPoint;
	}

	@WriteOperation
	public WebEndpointResponse<?> modifyJobStatus(@Selector String group, @Selector String name, @RequestBody String state) throws SchedulerException {
		try{
			boolean isSucess = quartzJobEndPoint.modifyJobStatus(group, name, state);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}
	@WriteOperation
	public WebEndpointResponse<?> modifyJobsStatus(@Selector String group,@RequestBody String state) throws SchedulerException {
		try{
			boolean isSucess = quartzJobEndPoint.modifyJobsStatus(group, state);
			int status = isSucess ? WebEndpointResponse.STATUS_OK : WebEndpointResponse.STATUS_NOT_FOUND;
			return new WebEndpointResponse<>(status);
		}catch(UnsupportStateChangeException e){
			return new WebEndpointResponse<>(WebEndpointResponse.STATUS_BAD_REQUEST);
		}
	}
}
