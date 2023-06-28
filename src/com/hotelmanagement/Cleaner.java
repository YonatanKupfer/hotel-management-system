package com.hotelmanagement;

public class Cleaner extends Worker {
	private int dayShift;//1-7
	
	public Cleaner(String name, int age, int dayShift) {
		super(name, age);
		this.dayShift = dayShift;
	}
}
