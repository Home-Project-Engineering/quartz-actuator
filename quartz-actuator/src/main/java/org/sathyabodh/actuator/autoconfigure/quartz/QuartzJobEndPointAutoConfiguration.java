package org.sathyabodh.actuator.autoconfigure.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.sathyabodh.actuator.quartz.api.QuartzJobEndPoint;
import org.sathyabodh.actuator.quartz.api.impl.QuartzJobEndPointImpl;
import org.sathyabodh.actuator.quartz.service.QuartzJobService;
import org.sathyabodh.actuator.quartz.service.impl.QuartzJobServiceImpl;
import org.sathyabodh.actuator.quartz.service.TriggerModelBuilder;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConditionalOnClass({ Scheduler.class, SchedulerFactory.class,TriggerModelBuilder.class })
@AutoConfigureAfter(QuartzAutoConfiguration.class)
public class QuartzJobEndPointAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public QuartzJobService quartzJobService(Scheduler scheduler, ApplicationContext context) {
		return new QuartzJobServiceImpl(scheduler);
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnAvailableEndpoint
	public QuartzJobEndPoint quartzJobEndPoint(QuartzJobServiceImpl service) {
		return new QuartzJobEndPointImpl(service);
	}

}
