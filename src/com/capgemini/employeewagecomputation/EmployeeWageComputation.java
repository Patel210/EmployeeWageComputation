package com.capgemini.employeewagecomputation;

public class EmployeeWageComputation {
	private static final int IS_FULL_TIME = 2;
	private static final int WAGE_PER_HOUR = 20;
	private static final int IS_PART_TIME = 1;
	private static final int NO_OF_WORKING_DAYS = 20;
	private static final int TOTAL_FIXED_WORKING_HOURS = 100;
	private static final int HOURS_FULL_TIME = 8;
	private static final int HOURS_PART_TIME = 4;

	/**
	 * To compute wage
	 */
	public int computeWage() {

		int totalWage = 0, totalHours = 0;
		for (int days = 0; days < NO_OF_WORKING_DAYS && totalHours < TOTAL_FIXED_WORKING_HOURS; days++) {
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;

			switch (empCheck) {
			case IS_PART_TIME:
				totalHours += HOURS_PART_TIME;
				totalWage += HOURS_PART_TIME * WAGE_PER_HOUR;

				if (totalHours > TOTAL_FIXED_WORKING_HOURS) { // To Check whether total hours has exceeded 100 hours
																// limit
					totalWage += (totalHours - TOTAL_FIXED_WORKING_HOURS) * WAGE_PER_HOUR;
				}
				break;

			case IS_FULL_TIME:
				totalHours += HOURS_FULL_TIME;
				totalWage += HOURS_FULL_TIME * WAGE_PER_HOUR;

				if (totalHours > TOTAL_FIXED_WORKING_HOURS) { // To Check whether total hours has exceeded 100 hours
																// limit
					totalWage += (totalHours - TOTAL_FIXED_WORKING_HOURS) * WAGE_PER_HOUR;
				}
				break;
			}
		}
		return totalWage;
	}

	public static void main(String[] args) {
		EmployeeWageComputation employeeWageComputation = new EmployeeWageComputation();
		System.out.println(employeeWageComputation.computeWage());
	}

}
