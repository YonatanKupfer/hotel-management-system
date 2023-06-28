package com.hotelmanagement;

public class Waiter extends Worker{
	private int dayShift;//1-7
	
	public Waiter(String name, int age, int dayShift) {
		super(name, age);
		this.dayShift = dayShift;
	}
}
