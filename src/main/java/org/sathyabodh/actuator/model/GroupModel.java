package org.sathyabodh.actuator.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class GroupModel{
	private final Map<String, List<Object>> groups = new HashMap<>();
}
