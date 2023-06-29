package com.hotelmanagement;

public class Cleaner extends Worker {
	private int dayShift;//1-7
	
	public Cleaner(String name, int age, int workerID, int dayShift) {
		super(name, age, workerID);
		this.dayShift = dayShift;
	}

	public int getDayShift() {
		return dayShift;
	}
	public void setDayShift(int dayShift) {
		this.dayShift = dayShift;
	}

}
