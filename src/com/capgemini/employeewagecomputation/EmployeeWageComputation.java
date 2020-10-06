package com.capgemini.employeewagecomputation;

public class EmployeeWageComputation {
	private static final int IS_FULL_TIME = 2;
	private static final int WAGE_PER_HOUR = 20;
	private static final int IS_PART_TIME = 1;
	private static final int NO_OF_WORKING_DAYS = 20;
	private static final int TOTAL_FIXED_WORKING_HOURS = 100;

	public static void main(String[] args) {

		int workHour = 0;
		int empWage = 0;
		int totalWage = 0;
		int totalHours = 0;

		for (int days = 0; days < NO_OF_WORKING_DAYS && totalHours < TOTAL_FIXED_WORKING_HOURS; days++) {
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;

			switch (empCheck) {
			case IS_PART_TIME:
				workHour = 4;
				totalHours += workHour;
				break;

			case IS_FULL_TIME:
				workHour = 8;
				totalHours += workHour;

				if (totalHours > 100) {
					totalHours = 100; // To Check whether total hours has exceeded 100 hours limit
				}
				break;

			default:
				workHour = 0;
			}
			empWage = workHour * WAGE_PER_HOUR;
			totalWage += empWage;
		}

		System.out.println("Monthly Employee Wage: " + totalWage);
	}

}
