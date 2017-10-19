package com.deloitte.poc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.poc.model.Plan;
import com.deloitte.poc.service.PlanServiceImpl;

//Acts as a rest controller and endpoint for user interation
@RestController
public class PlanController {

	@Autowired
	private PlanServiceImpl planServiceImpl;

	// This method fetches all the records details from database
	@GetMapping("/plans")
	public List getPlans() {
		List<Plan> plansList = new ArrayList<Plan>();
		plansList = planServiceImpl.getAllPlans();
		return plansList;
	}

	// This method insert records to the database
	@PostMapping(value = "/plans")
	public void addPlan(@RequestBody Plan plan) {
		planServiceImpl.addPlan(plan);
	}

	// This method fetches the record based on id provided through url
	// from database
	@RequestMapping(method = RequestMethod.GET, value = "plans/{id}")
	public Plan getPlanById(@PathVariable String id) {
		Plan planById = planServiceImpl.getPlanById(Integer.parseInt(id));
		return planById;

	}

}
