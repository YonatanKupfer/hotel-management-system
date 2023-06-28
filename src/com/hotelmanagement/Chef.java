package com.hotelmanagement;

public class Chef extends Worker {
	private String specialMeal;
	
	public Chef(String name, int age, String specialMeal) {
		super(name, age);
		this.specialMeal = specialMeal;
	}
}
