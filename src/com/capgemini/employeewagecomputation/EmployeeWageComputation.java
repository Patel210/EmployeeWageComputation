package com.capgemini.employeewagecomputation;

public class EmployeeWageComputation {
	private static final int IS_FULL_TIME = 1;
	private static final int WAGE_PER_HOUR = 20;
	
	
	public static void main(String[] args) {
		
		int workHour = 0;
		double IS_EMP_PRESENT = Math.floor(Math.random()*10) % 2;
		int empWage = 0;
		
		if (IS_FULL_TIME == IS_EMP_PRESENT) {
			System.out.println("Employee is Present");
			workHour = 8;
		}
		else {
			System.out.println("Employee is Absent");
		}
		
		empWage = workHour * WAGE_PER_HOUR;
		System.out.println("Daily Employee Wage: " + empWage);
	}
}
