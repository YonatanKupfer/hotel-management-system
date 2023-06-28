package com.hotelmanagement;

public class Security extends Worker{
	private int yearsOfExperience;
	
	public Security(String name, int age, int yearsOfExperience) {
		super(name, age);
		this.yearsOfExperience = yearsOfExperience;
	}
}
