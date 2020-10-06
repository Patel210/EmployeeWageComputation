package com.capgemini.employeewagecomputation;


public class EmployeeWageComputation {
	private static final int IS_FULL_TIME = 2;
	private static final int IS_PART_TIME = 1;
	private static final int HOURS_FULL_TIME = 8;
	private static final int HOURS_PART_TIME = 4;
	private final String companyName;
	private final int wagePerHour;
	private final int noOfWorkingDays;
	private final int totalFixedWorkingHours;

	public EmployeeWageComputation(String companyName, int wagePerHour, int noOfWorkingDays,
			int totalFixedWorkingHours) {

		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.noOfWorkingDays = noOfWorkingDays;
		this.totalFixedWorkingHours = totalFixedWorkingHours;

	}

	/**
	 * To compute wage
	 */
	public int computeWage() {

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
	public int getDailyWage(int wagePerHour) {
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
	public int getDailyHours(int wagePerHour) {
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
		EmployeeWageComputation empWageBuilderCodesity = new EmployeeWageComputation("Codesity", 100, 20, 100);
		EmployeeWageComputation empWageBuilderePW = new EmployeeWageComputation("ePW", 50, 20, 100);
		
		int wageOfCompanyCodesity = empWageBuilderCodesity.computeWage();
		int wageOfCompanyePW = empWageBuilderePW.computeWage();
		System.out.println(wageOfCompanyePW );
		System.out.println(wageOfCompanyCodesity);
		
	}

}
