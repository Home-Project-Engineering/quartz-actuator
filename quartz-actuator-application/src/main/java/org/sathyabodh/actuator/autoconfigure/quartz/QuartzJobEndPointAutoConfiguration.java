package main.java.org.sathyabodh.actuator.autoconfigure.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.sathyabodh.actuator.quartz.QuartzJobEndPoint;
import org.sathyabodh.actuator.quartz.service.QuartzJobService;
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
		Map<String, QuartzJobEndPoint> beansOfType = context.getBeansOfType(QuartzJobEndPoint.class);
		Map<String, TriggerModelBuilder> beansOfType2 = context.getBeansOfType(TriggerModelBuilder.class);
		return new QuartzJobService(scheduler);
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnAvailableEndpoint
	public QuartzJobEndPoint quartzJobEndPoint(QuartzJobService service) {
		return new QuartzJobEndPoint(service);
	}

}
