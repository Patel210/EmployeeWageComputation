package com.capgemini.employeewagecomputation;

public class EmployeeWageComputation {
	private static final int IS_FULL_TIME = 2;
	private static final int WAGE_PER_HOUR = 20;
	private static final int IS_PART_TIME = 1;

	
	
	public static void main(String[] args) {
		
		int workHour = 0;
		double empCheck = Math.floor(Math.random()*10) % 3;
		int empWage = 0;
		
		if (IS_FULL_TIME == empCheck) {
			workHour = 8;
		}
		else if (IS_PART_TIME == empCheck) {
			workHour = 4;
		}
		
		empWage = workHour * WAGE_PER_HOUR;
		System.out.println("Daily Employee Wage: " + empWage);
	}
}
