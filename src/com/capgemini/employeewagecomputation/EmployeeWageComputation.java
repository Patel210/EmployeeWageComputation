package com.capgemini.employeewagecomputation;

import java.util.ArrayList;

public class EmployeeWageComputation implements WageCalculator {
	private static final int IS_FULL_TIME = 2;
	private static final int IS_PART_TIME = 1;
	private static final int HOURS_FULL_TIME = 8;
	private static final int HOURS_PART_TIME = 4;

	private ArrayList<Company> companies;

	// Constructor
	public EmployeeWageComputation(ArrayList<Company> companies) {
		super();
		this.companies = companies;
	}

	/**
	 * To compute wage for all companies in the list
	 */
	@Override
	public void computeWage() {
		for (Company company : companies) {
			computeWage(company);
		}

	}

	/**
	 * @param To compute wage using company Name
	 */
	public void computeWageOfParticularCompany(String companyName) {
		boolean flag = false;
		while (!flag)
			for (Company companyObject : companies) {
				if (companyObject.getCompanyName().equalsIgnoreCase(companyName)) {
					computeWage(companyObject);
					flag = true;
				}
			}
	}
	
	/**
	 * @param To compute wage for particular company
	 */
	public void computeWage(Company company) {
			int totalWage = 0, totalHours = 0, noOfDays = 0;
			for (int days = 0; days < company.getNoOfWorkingDays()
					&& totalHours < company.getTotalFixedWorkingHours(); days++) {
				int dailyWage = getDailyWage(company.getWagePerHour());
				totalWage += dailyWage;
				totalHours += getDailyHours(company.getWagePerHour());
				if (totalHours > company.getTotalFixedWorkingHours()) {
					totalWage -= (totalHours - company.getTotalFixedWorkingHours()) * company.getWagePerHour();
				}
				noOfDays++;
				System.out.println(
						"Day " + noOfDays + " Emp Wage for company " + company.getCompanyName() + ": " + dailyWage);
			}
			System.out.println("Total Wage of " + company.getCompanyName() + " is: " + totalWage);
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
		employeeWageComputation.computeWageOfParticularCompany("dMart");

	}

}
