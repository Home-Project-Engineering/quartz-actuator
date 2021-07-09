package org.sathyabodh.actuator.autoconfigure.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.sathyabodh.actuator.quartz.QuartzTriggerEndPoint;
import org.sathyabodh.actuator.quartz.service.QuartzTriggerService;
import org.sathyabodh.actuator.quartz.service.TriggerModelBuilder;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({Scheduler.class, SchedulerFactory.class})
@AutoConfigureAfter(QuartzAutoConfiguration.class)
public class QuartzTriggerEndPointAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public QuartzTriggerService quartzTriggerService(Scheduler scheduler){
		return new QuartzTriggerService(scheduler);
	}

	@Bean
	@ConditionalOnMissingBean
	public TriggerModelBuilder quartzTriggerModelBuilder(Scheduler scheduler){
		return new TriggerModelBuilder(scheduler);
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnAvailableEndpoint
	public QuartzTriggerEndPoint quartzTriggerEndPoint(QuartzTriggerService service, TriggerModelBuilder builder){
		return new QuartzTriggerEndPoint(service,builder);
	}
}
