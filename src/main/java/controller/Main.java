package controller;

import view.UserInterface;

public class Main {

	private static UserInterface ui = new UserInterface();
	private static Logic logic = Logic.getInstance();
	
	public static void main(String[] args) {
			application();			
	}
	
	private static void application() {
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
