package controller;

import java.util.ArrayList;

import model.HouseholdMember;

public class Logic {

	private int totalIncome, totalRent;
	 
	//SINGLETON
	private static final Logic logic = new Logic();
	
	public static Logic getInstance() {
		return logic;
	}
	//SINGLETON
	
	
	private Logic() {}
	
	/**
	 * adds the income of each member into a total sum
	 * @param household
	 */
	public void setTotalIncome(ArrayList<HouseholdMember> household) {
		for(HouseholdMember hm : household) {
			totalIncome += hm.getIncome();
		}
		System.out.println("Total income: " + totalIncome + "\n");
	}
	
	/**
	 * Logic for calculating percentage each member is to pay
	 * @param household
	 */
	public void calculatePercentage(ArrayList<HouseholdMember> household) {
		for(HouseholdMember hm : household) {
			double percent = (hm.getIncome() * 100) / totalIncome;
			System.out.println(hm.getName() + ": "+ percent + "%");
			
			calculateMonetaryAmount(percent, hm.getIncome());
		}
		
		System.out.println();
	}
	
	/**
	 * Calculates how much money to be paid in accordance to percentage
	 * @param p percent
	 * @param income
	 */
	public void calculateMonetaryAmount(double p, double income) {
		p /= 100;
		double total = income * p;
		System.out.println(total);
	}
	
	public void setRent(int rent) {
		this.totalRent = rent;
	}
}
