package com.hotelmanagement;

public class Worker implements Cloneable, Comparable<Worker> {
	private String name;
    private int age;
    private int workerID;
    private boolean isAvailable;
    
 // Constructor
    public Worker(String name, int age, int workerID, boolean isAvailable) throws CloneNotSupportedException {
        this.name = name;
        this.age = age;
        this.workerID = workerID;
        this.isAvailable = isAvailable;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
    	return age;
    }
    public void setAge(int age){
    	this.age = age;
    }
    public int getWorkerID(){
    	return workerID;
    }
    public void setWorkerID(int workerID){
    	this.workerID = workerID;
    }
    public boolean getIsAvailable(){
    	return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable){
    	this.isAvailable = isAvailable;
    }

    // toString method
    @Override
    public String toString() {
        return "Worker [name=" + name + ", age=" + age + ", workerID=" + workerID + "]";
    }

    // Clone method
    @Override
    public Worker clone() throws CloneNotSupportedException {
        return (Worker) super.clone();
    }

    // CompareTo method
    @Override
    public int compareTo(Worker o) {
        return this.workerID - o.workerID;
    }


}
