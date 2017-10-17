package com.deloitte.poc.service;

import java.util.List;

import com.deloitte.poc.model.Plan;

public interface IPlanService {

	void addPlan(Plan plan);
	List<Plan> getAllPlans();
}
