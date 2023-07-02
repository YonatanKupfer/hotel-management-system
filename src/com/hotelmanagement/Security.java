package com.hotelmanagement;

public class Security extends Worker{
	private int yearsOfExperience;
	
	public Security(String name, int age, int workerID, int yearsOfExperience, boolean isAvailable) throws CloneNotSupportedException {
		super(name, age, workerID, isAvailable);
		this.yearsOfExperience = yearsOfExperience;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
}
