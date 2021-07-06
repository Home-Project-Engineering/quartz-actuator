package org.sathyabodh.actuator.quartz.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class JobDetailModel extends JobModel{
	private String group;
	private List<TriggerDetailModel> triggers;
}
