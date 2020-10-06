package com.capgemini.employeewagecomputation;

public class EmployeeWageComputation implements WageCalculator {
	private static final int IS_FULL_TIME = 2;
	private static final int IS_PART_TIME = 1;
	private static final int HOURS_FULL_TIME = 8;
	private static final int HOURS_PART_TIME = 4;

	private Company[] companies;

	public EmployeeWageComputation(Company[] companies) {
		super();
		this.companies = companies;
	}

	/**
	 * To compute wage
	 */
	@Override
	public void computeWage() {
		int noOfCompany = companies.length;

		for (int i = 0; i < noOfCompany; i++) {

			int totalWage = 0, totalHours = 0;
			for (int days = 0; days < companies[i].getNoOfWorkingDays()
					&& totalHours < companies[i].getTotalFixedWorkingHours(); days++) {

				totalWage += getDailyWage(companies[i].getWagePerHour());
				totalHours += getDailyHours(companies[i].getWagePerHour());
				if (totalHours > companies[i].getTotalFixedWorkingHours()) {
					totalWage -= (totalHours - companies[i].getTotalFixedWorkingHours())
							* companies[i].getWagePerHour();
				}
			}
			System.out.println("Total Wage of " + companies[i].getCompanyName() + " is: " + totalWage);
		}

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

		Company[] companies = new Company[3];

		companies[0] = new Company("Codesity", 100, 22, 100);
		companies[1] = new Company("ePW", 90, 20, 120);
		companies[2] = new Company("ePW", 90, 20, 120);

		EmployeeWageComputation employeeWageComputation = new EmployeeWageComputation(companies);
		employeeWageComputation.computeWage();

	}

}
