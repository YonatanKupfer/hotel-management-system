package com.hotelmanagement;

public class Chef extends Worker {
	private String specialMeal;
	
	public Chef(String name, int age, int workerID, String specialMeal, boolean isAvailable) throws CloneNotSupportedException {
		super(name, age, workerID, isAvailable);
		this.specialMeal = specialMeal;
	}

	public String getSpecialMeal() {
		return specialMeal;
	}
	public void setSpecialMeal(String specialMeal) {
		this.specialMeal = specialMeal;
	}

}
