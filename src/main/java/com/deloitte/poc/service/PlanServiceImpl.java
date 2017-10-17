package com.deloitte.poc.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.poc.mappers.IPlanMapper;
import com.deloitte.poc.model.Plan;

@Service("planService")
public class PlanServiceImpl implements IPlanService {
	
	/*@Autowired
	private SqlSession sqlSession; //This is to demonstrate injecting SqlSession object
*/	 
	@Autowired
	private IPlanMapper planMapper;// This is to demonstrate how to inject Mappers directly

	public void addPlan(Plan plan) {
		planMapper.addPlan(plan);
		
	}

	public List<Plan> getAllPlans() {
		List<Plan> planList = planMapper.getAllPlans();
		return planList;
	}

}
