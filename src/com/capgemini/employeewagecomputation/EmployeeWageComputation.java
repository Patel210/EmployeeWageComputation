package com.capgemini.employeewagecomputation;

import java.util.ArrayList;

public class EmployeeWageComputation implements WageCalculator {
	private static final int IS_FULL_TIME = 2;
	private static final int IS_PART_TIME = 1;
	private static final int HOURS_FULL_TIME = 8;
	private static final int HOURS_PART_TIME = 4;

	private ArrayList<Company> company;
	
	//Constructor
	public EmployeeWageComputation(ArrayList<Company> companies) {
		super();
		this.company = companies;
	}

	/**
	 * To compute wage
	 */
	@Override
	public void computeWage() {

		for (Company company : company) {

			int totalWage = 0, totalHours = 0, noOfDays = 0;
			for (int days = 0; days < company.getNoOfWorkingDays()
					&& totalHours < company.getTotalFixedWorkingHours(); days++) {
				int dailyWage =getDailyWage(company.getWagePerHour());
				totalWage += dailyWage;
				totalHours += getDailyHours(company.getWagePerHour());
				if (totalHours > company.getTotalFixedWorkingHours()) {
					totalWage -= (totalHours - company.getTotalFixedWorkingHours())
							* company.getWagePerHour();
				}
				noOfDays++;
				System.out.println("Day "+ noOfDays + " Emp Wage for company "+ company.getCompanyName() + ": " + dailyWage);
			}
			System.out.println("Total Wage of " + company.getCompanyName() + " is: " + totalWage);
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

		ArrayList<Company> companies = new ArrayList<Company>();
		
		companies.add(new Company("Codesity", 100, 22, 100));
		companies.add(new Company("ePW", 90, 20, 120));
		companies.add(new Company("dMart", 110, 20, 150));

		EmployeeWageComputation employeeWageComputation = new EmployeeWageComputation(companies);
		employeeWageComputation.computeWage();

	}

}
