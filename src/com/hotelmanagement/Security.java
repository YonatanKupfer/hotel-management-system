package com.hotelmanagement;

public class Security extends Worker{
	private int yearsOfExperience;
	
	public Security(String name, int age, int workerID, int yearsOfExperience) {
		super(name, age, workerID);
		this.yearsOfExperience = yearsOfExperience;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
}
