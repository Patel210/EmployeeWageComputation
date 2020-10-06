package com.capgemini.employeewagecomputation;

public class EmployeeWageComputation {
	private static final int IS_FULL_TIME = 2;
	private static final int IS_PART_TIME = 1;
	private static final int HOURS_FULL_TIME = 8;
	private static final int HOURS_PART_TIME = 4;

	/**
	 * To compute wage
	 */
	public static int computeWage(String companyName, int wagePerHour, int noOfWorkingDays,
			int totalFixedWorkingHours) {

		int totalWage = 0, totalHours = 0;
		for (int days = 0; days < noOfWorkingDays && totalHours < totalFixedWorkingHours; days++) {
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;
			totalWage += getDailyWage(wagePerHour);
			totalHours += getDailyHours(wagePerHour);
			if (totalHours > totalFixedWorkingHours) {
				totalWage -= (totalHours - totalFixedWorkingHours) * wagePerHour;
			}
		}
		return totalWage;
	}

	/**
	 * @param To get Daily Wage Expense
	 * @return
	 */
	public static int getDailyWage(int wagePerHour) {
		int dailyWage;
		switch ((int) Math.floor(Math.random() * 10) % 3) {
		case IS_PART_TIME:
			dailyWage = HOURS_PART_TIME * wagePerHour;
			return dailyWage;

		case IS_FULL_TIME:
			dailyWage = HOURS_FULL_TIME * wagePerHour;
			return dailyWage;

		default:
			return 0;
		}
	}

	/**
	 * @param To get Daily working hour
	 * @return
	 */
	public static int getDailyHours(int wagePerHour) {
		switch ((int) Math.floor(Math.random() * 10) % 3) {
		case IS_PART_TIME:
			return HOURS_PART_TIME;
		case IS_FULL_TIME:
			return HOURS_FULL_TIME;

		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(computeWage("Codesity", 100, 20, 100));
		System.out.println(computeWage("ePW", 50, 22, 120));
	}

}
