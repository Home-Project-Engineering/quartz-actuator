package org.sathyabodh.actuator.autoconfigure.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.sathyabodh.actuator.quartz.api.QuartzTriggerEndPoint;
import org.sathyabodh.actuator.quartz.api.impl.QuartzTriggerEndPointImpl;
import org.sathyabodh.actuator.quartz.service.QuartzTriggerService;
import org.sathyabodh.actuator.quartz.service.impl.QuartzTriggerServiceImpl;
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
		return new QuartzTriggerServiceImpl(scheduler);
	}

	@Bean
	@ConditionalOnMissingBean
	public TriggerModelBuilder quartzTriggerModelBuilder(Scheduler scheduler){
		return new TriggerModelBuilder(scheduler);
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnAvailableEndpoint
	public QuartzTriggerEndPoint quartzTriggerEndPoint(QuartzTriggerServiceImpl service, TriggerModelBuilder builder){
		return new QuartzTriggerEndPointImpl(service,builder);
	}
}
