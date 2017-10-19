package com.deloitte.poc.service;

import java.util.List;

import com.deloitte.poc.model.Plan;

//A service interface which has all the unimplemented methods to communicate with the database
public interface IPlanService {

	// This method fetches all the records from database.
	List<Plan> getAllPlans();
	
	//// This method adds new record to the database.
	void addPlan(Plan plan);
	
	//This method fetches record based on id provided as parameter from the database.
	Plan getPlanById(int id);
}
