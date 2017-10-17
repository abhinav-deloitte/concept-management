package com.deloitte.poc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.poc.model.Plan;
import com.deloitte.poc.service.PlanServiceImpl;

@RestController
public class PlanController {
	
	@Autowired
	private PlanServiceImpl planServiceImpl;
	
	@GetMapping("/plans")
	public List getPlans(){
		List<Plan> plansList = new ArrayList<Plan>();
		plansList=planServiceImpl.getAllPlans();
		return plansList;
	}
	
	@PostMapping(value = "/plans")
	public void addPlan(@RequestBody Plan plan){
		planServiceImpl.addPlan(plan);
	}

}
