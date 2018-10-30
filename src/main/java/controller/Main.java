package controller;

import view.UserInterface;

public class Main {

	public static void main(String[] args) {

		UserInterface ui = new UserInterface();
		Logic logic = Logic.getInstance();
		
		ui.initHousehold();
		logic.setRent(ui.requestTotalRent());
		System.out.println("------o-------");
		ui.requestIncomeInput();
		System.out.println("------o-------");
		logic.setTotalIncome(ui.getHousehold());
		System.out.println("------o-------");
		logic.calculatePercentage(ui.getHousehold());
	
	}

}
