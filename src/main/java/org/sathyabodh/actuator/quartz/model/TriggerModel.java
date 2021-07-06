package org.sathyabodh.actuator.quartz.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TriggerModel {
	private String group;
	private String name;
	private String state;
	private Date nextFireTime;
	private Date previousFireTime;
	private Date startTime;
	private Date endTime;
}
