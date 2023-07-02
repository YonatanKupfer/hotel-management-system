package com.hotelmanagement;

public class Waiter extends Worker{
	private int dayShift;//1-7
	
	public Waiter(String name, int age, int workerID, int dayShift, boolean isAvailable) throws CloneNotSupportedException {
		super(name, age, workerID, isAvailable);
		this.dayShift = dayShift;
	}

	public int getDayShift() {
		return dayShift;
	}
	public void setDayShift(int dayShift) {
		this.dayShift = dayShift;
	}

}
