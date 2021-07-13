package org.sathyabodh.actuator.quartz.api;

import org.quartz.SchedulerException;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.web.bind.annotation.RequestBody;

@WebEndpoint(id = "quartz-triggers")
public interface QuartzTriggerEndPoint {
    @ReadOperation
    WebEndpointResponse<?> getTriggerByGroupAndName(@Selector String group, @Selector String name);

    @ReadOperation
    WebEndpointResponse<?> getTriggersByGroup(@Selector String group);

    @ReadOperation
    WebEndpointResponse<?> getAllTriggers();

    @WriteOperation
    WebEndpointResponse<?> setTriggerCron(@Selector String group, @Selector String name, @RequestBody String cron) throws SchedulerException;

    @WriteOperation
    WebEndpointResponse<?> setTriggersCron(@Selector String group, @RequestBody String cron) throws SchedulerException;
}
