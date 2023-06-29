package com.hotelmanagement;

public class Worker implements Cloneable, Comparable<Worker> {
	private String name;
    private int age;
    private int workerID;
    
 // Constructor
    public Worker(String name, int age, int workerID) {
        this.name = name;
        this.age = age;
        this.workerID = workerID;
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
