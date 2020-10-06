package com.capgemini.employeewagecomputation;

public class EmployeeWageComputation {
	private static final int IS_FULL_TIME = 2;
	private static final int WAGE_PER_HOUR = 20;
	private static final int IS_PART_TIME = 1;
	
	
	public static void main(String[] args) {
		
		int workHour = 0;
		int empCheck = (int) Math.floor(Math.random()*10) % 3;
		int empWage = 0;
		
		switch (empCheck) {
		case IS_PART_TIME:
			workHour = 4; 
			break;
		
		case IS_FULL_TIME:
			workHour = 8;
			break;
		
		default:
			workHour = 0;
	}
		
		empWage = workHour * WAGE_PER_HOUR;
		System.out.println("Daily Employee Wage: " + empWage);
	}
}
