package org.sathyabodh.actuator.quartz.api;

import org.quartz.SchedulerException;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.web.bind.annotation.RequestBody;

@Endpoint(id = "quartz-jobs")
public interface QuartzJobEndPoint {
    @ReadOperation
    WebEndpointResponse<?> getJobByGroupAndName(@Selector String group, @Selector String name);

    @ReadOperation
    WebEndpointResponse<?> getJobsByGroup(@Selector String group);

    @ReadOperation
    WebEndpointResponse<?> getAllJobs();

    @WriteOperation
    WebEndpointResponse<?> setJobState(@Selector String group, @Selector String name, @RequestBody String state) throws SchedulerException;

    @WriteOperation
    WebEndpointResponse<?> setJobsState(@Selector String group, @RequestBody String state) throws SchedulerException;
}
