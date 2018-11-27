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

	private float totalIncome, totalRent;
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
	
	float sumOfall = 0;
	
	/**
	 * Logic for calculating percentage each member is to pay
	 * @param household
	 */
	public void calculatePercentage(ArrayList<HouseholdMember> household) {
		for(HouseholdMember hm : household) {
//			float percent = (hm.getIncome() * 100) / totalIncome;
//			System.out.print(hm.getName() + ": "+ percentFormat.format(percent) + "%");
			float percent = hm.getIncome() / totalIncome;
			System.out.println(hm.getIncome() + " - " +hm.getName() + ": " + Math.round(percent*100) + "%");
			
			calculateMonetaryAmount(percent, hm.getIncome());
		}
		
		System.out.println();
		System.out.println("TOTAL: " + sumOfall);
	}
	
	/**
	 * Calculates how much money to be paid in accordance to percentage
	 * @param p percent
	 * @param income
	 */
	public void calculateMonetaryAmount(float p, float income) {
		
		double total = Math.round((p * totalRent));
		
		sumOfall += total;
		//System.out.println(" - SEK " + moneyFormat.format(total));
		System.out.println("- SEK " + total);

	}
	
	public void setRent(int rent) {
		this.totalRent = rent;
	}
}
