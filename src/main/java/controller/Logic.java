package controller;

import java.text.DecimalFormat;
import java.util.ArrayList;

import model.HouseholdMember;

/**
 * Class containing all the logic for the program
 * @author silberio_stalone
 *
 */
public class Logic {

	private double totalIncome, totalRent;
	 private DecimalFormat percentFormat = new DecimalFormat("#.#");
	 private DecimalFormat moneyFormat = new DecimalFormat("#.##");
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
		System.out.println("Total household income: " + totalIncome);
	}
	
	/**
	 * Logic for calculating percentage each member is to pay
	 * @param household
	 */
	public void calculatePercentage(ArrayList<HouseholdMember> household) {
		for(HouseholdMember hm : household) {
			double percent = (hm.getIncome() * 100) / totalIncome;
			System.out.print(hm.getName() + ": "+ percentFormat.format(percent) + "%");
			
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

		System.out.println(" - SEK " + moneyFormat.format(total));
	}
	
	public void setRent(int rent) {
		this.totalRent = rent;
	}
}
