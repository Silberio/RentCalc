package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.HouseholdMember;

/**
 * Class containing all menu interactions and scanner for user input
 * @author silberio_stalone
 *
 */
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


	/**
	 * requests for the total amount of rent
	 * @return
	 */
	public int requestTotalRent() {
		System.out.println("Input total rent: ");
		return userInput.nextInt();
	}
	
	public boolean runAgain() {
		System.out.println("Run again? Y/N");
		
		String option = userInput.nextLine();
		
		if(option.equals("N") || option.equals("n") || option.equals("no") || option.equals("NO")) {
			return false;
		} else
			return true;
		
		
	}

	public ArrayList<HouseholdMember> getHousehold() {
		return household;
	}
}
