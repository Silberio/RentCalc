package model;

/**
 * Household member object
 * @author silberio_stalone
 *
 */
public class HouseholdMember {
	
	private String name;
	private float income;
	
	public HouseholdMember() {}
	
	/**
	 * init only with name
	 * @param name
	 */
	public HouseholdMember(String name) {
		this.name = name;
	}
	
	/**
	 * init with name and income
	 * @param name
	 * @param income
	 */
	public HouseholdMember(String name, float income) {
		this.name = name;
		this.income = income;
	}
	
	/*
	 * GETTERS N SETTERS
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}
	
	
}
