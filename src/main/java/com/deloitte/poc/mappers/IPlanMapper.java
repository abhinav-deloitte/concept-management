package com.deloitte.poc.mappers;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.deloitte.poc.model.Plan;

public interface IPlanMapper {
	
	final String getAllPlans = "SELECT * FROM poc.plan";
	final String addPlan = "INSERT INTO poc.plan(id, planName, deductible, monthlyCost, hsaCompatible) values (#{id},#{planName},#{deductible},#{monthlyCost},#{hsaCompatible}) ";
	
	@Select(getAllPlans)
	   @Results(value = {
	      @Result(property = "id", column = "id"),
	      @Result(property = "planName", column = "planName"),
	      @Result(property = "deductible", column = "deductible"),
	      @Result(property = "monthlyCost", column = "monthlyCost"),       
	      @Result(property = "hsaCompatible", column = "hsaCompatible")
	      })
	List<Plan> getAllPlans();
	
	@Insert(addPlan)
	   @Options(useGeneratedKeys = true, keyProperty = "id")
	   void addPlan(Plan plan);

}
