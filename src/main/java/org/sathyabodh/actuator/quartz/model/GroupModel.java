package org.sathyabodh.actuator.quartz.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class GroupModel<T> {

	private final Map<String, List<T>> groups = new HashMap<>();

	public void add(String group, T model){
		List<T> models = getGroups().computeIfAbsent(group, k -> new ArrayList<>());
		models.add(model);
	}
}
