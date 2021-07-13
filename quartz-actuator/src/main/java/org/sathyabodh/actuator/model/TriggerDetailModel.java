package org.sathyabodh.actuator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TriggerDetailModel{
	private String name;
	private Date nextFireTime;
	private Date previousFireTime;
	private Date startTime;
	private Date endTime;
	private String group;
	private String state;
	private String jobKey;
}
