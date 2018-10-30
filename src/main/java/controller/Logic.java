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
	
	public void setTotalIncome(ArrayList<HouseholdMember> household) {
		for(HouseholdMember hm : household) {
			totalIncome += hm.getIncome();
		}
		System.out.println("Total income: " + totalIncome + "\n");
	}
	
	public void calculatePercentage(ArrayList<HouseholdMember> household) {
		for(HouseholdMember hm : household) {
			double percent = (hm.getIncome() * 100) / totalIncome;
			System.out.println(hm.getName() + ": "+ percent + "%");
			
			calculateMonetaryAmount(percent, hm.getIncome());
		}
		
		System.out.println();
	}
	
	public void calculateMonetaryAmount(double p, double income) {
		p /= 100;
		double total = income * p;
		System.out.println(total);
	}
	
	public void setRent(int rent) {
		this.totalRent = rent;
	}
}
