package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.HouseholdMember;

public class UserInterface {
	private Scanner userInput = new Scanner(System.in);
	private ArrayList<HouseholdMember> household = new ArrayList<HouseholdMember>();
	private String input;

	/**
	 * input amount and each household member
	 */
	public void initHousehold() {	
		do {
			System.out.println("Add household member (leave blank to end): ");
			input = userInput.nextLine();
			household.add(new HouseholdMember(input));
			
		} while(!(input.isEmpty()));
		household.remove(household.size() - 1);
		System.out.println("END OF LIST");


	}
	
	/**
	 * requests input for each household member
	 */
	public void requestIncomeInput() {
		for(HouseholdMember hm : household) {
			System.out.println("Input income for " + hm.getName());
			hm.setIncome(userInput.nextInt());
		}
	}

	
	public int requestTotalRent() {
		System.out.println("Input total rent: ");
		return userInput.nextInt();
	}

	public ArrayList<HouseholdMember> getHousehold() {
		return household;
	}
}
