package com.deloitte.poc.model;

//Model class for the entire project which has all the variable and respective setter and getter methods.
public class Plan {

	private int id;
	private String planName;
	private double deductible;
	private double monthlyCost;
	private String hsaCompatible;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public double getDeductible() {
		return deductible;
	}
	public void setDeductible(double deductible) {
		this.deductible = deductible;
	}
	public double getMonthlyCost() {
		return monthlyCost;
	}
	public void setMonthlyCost(double monthlyCost) {
		this.monthlyCost = monthlyCost;
	}
	public String getHsaCompatible() {
		return hsaCompatible;
	}
	public void setHsaCompatible(String hsaCompatible) {
		this.hsaCompatible = hsaCompatible;
	}
	
	
}
