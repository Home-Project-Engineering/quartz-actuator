package org.sathyabodh.actuator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobModel {
	private String name;
	private boolean isConcurrentDisallowed;
	private boolean isDurable;
	private String jobClass;
}
