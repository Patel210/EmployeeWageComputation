package com.capgemini.employeewagecomputation;

public class Company {

	private String companyName;
	private int wagePerHour;
	private int noOfWorkingDays;
	private int totalFixedWorkingHours;

	public Company(String companyName, int wagePerHour, int noOfWorkingDays, int totalFixedWorkingHours) {
		super();
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.noOfWorkingDays = noOfWorkingDays;
		this.totalFixedWorkingHours = totalFixedWorkingHours;
	}

	public int getNoOfWorkingDays() {
		return noOfWorkingDays;
	}

	public void setNoOfWorkingDays(int noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}

	public int getTotalFixedWorkingHours() {
		return totalFixedWorkingHours;
	}

	public void setTotalFixedWorkingHours(int totalFixedWorkingHours) {
		this.totalFixedWorkingHours = totalFixedWorkingHours;
	}

	public int getWagePerHour() {
		return wagePerHour;
	}

	public void setWagePerHour(int wagePerHour) {
		this.wagePerHour = wagePerHour;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
