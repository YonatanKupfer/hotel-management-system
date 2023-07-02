package com.hotelmanagement;

import java.util.Scanner;

public class HotelSystem {
    
    
    public HotelSystem(){
    }
    
    public void hotelManager(){
        Hotel hotel = new Hotel();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String input = "";
    

        while(!exit){
            hotel.printSystemMenu();
            input = scanner.nextLine();
            switch(input){
                case "1":
                    System.out.println("Please enter the room number:");
                    int roomNumber = Integer.parseInt(scanner.nextLine());
                    //check if room number already exists
                    if(hotel.searchRoomBoolean(roomNumber)){
                        System.out.println("Room number already exists");
                        break;
                    }
                    System.out.println("Please enter the room type:");
                    String roomType = scanner.nextLine();
                    boolean flag = true;
                    while(flag){
                        System.out.println("Enter 1 for guest room, 2 for function hall:");
                        int roomChoice = Integer.parseInt(scanner.nextLine());
                        if(roomChoice == 1){
                            System.out.println("Please enter the number of beds:");
                            int numberOfBeds = Integer.parseInt(scanner.nextLine());
                            try {
                                hotel.addRoom(new GuestRoom(roomNumber, roomType, true, null, numberOfBeds));
                            } catch (CloneNotSupportedException e) {
                                e.printStackTrace();
                            }
                        }else if(roomChoice == 2){
                            System.out.println("Please enter the purpose:");
                            String purpose = scanner.nextLine();
                            System.out.println("Please enter the capacity:");
                            int capacity = Integer.parseInt(scanner.nextLine());
                            try {
                                hotel.addRoom(new FunctionHall(roomNumber, roomType, true, null, purpose, capacity));
                            } catch (CloneNotSupportedException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            System.out.println("Invalid input");
                        }
                    }
                    break;
                case "2":
                    System.out.println("Please enter the room number:");
                    int roomNumber2 = Integer.parseInt(scanner.nextLine());
                    if(hotel.searchRoomBoolean(roomNumber2)){
                        hotel.removeRoom(roomNumber2);
                    }
                    else{
                        System.out.println("Room number does not exist");
                    }
                    break;
                case "3":
                    System.out.println("Please enter the worker ID:");
                    int workerID = Integer.parseInt(scanner.nextLine());
                    if(hotel.searchWorkerBoolean(workerID)){
                        System.out.println("Worker ID already exists");
                        break;
                    }
                    System.out.println("Please enter the worker name:");
                    String workerName = scanner.nextLine();
                    System.out.println("Please enter the worker age:");
                    int workerAge = Integer.parseInt(scanner.nextLine());
                    boolean flag2 = true;
                    while(flag2){
                        System.out.println("Enter 1 for cleaner, 2 for security, 3 fro waiter, 4 for chef:");
                        int workerChoice = Integer.parseInt(scanner.nextLine());
                        if(workerChoice == 1){
                            System.out.println("Please enter the day shift:");
                            int dayShift = Integer.parseInt(scanner.nextLine());
                            try {
                                hotel.addWorker(new Cleaner(workerName, workerAge, workerID, dayShift, true, 0));
                            } catch (CloneNotSupportedException e) {
                                e.printStackTrace();
                            }
                        }else if(workerChoice == 2){
                            System.out.println("Please enter years of experience:");
                            int yearsOfExperience = Integer.parseInt(scanner.nextLine());
                            try {
                                hotel.addWorker(new Security(workerName, workerAge, workerID, yearsOfExperience, true));
                            } catch (CloneNotSupportedException e) {
                                e.printStackTrace();
                            }
                        }else if(workerChoice == 3){
                            System.out.println("Please enter the day shift:");
                            int dayShift = Integer.parseInt(scanner.nextLine());
                            try {
                                hotel.addWorker(new Waiter(workerName, workerAge, workerID, dayShift, true));
                            } catch (CloneNotSupportedException e) {
                                e.printStackTrace();
                            }
                        }else if(workerChoice == 4){
                            System.out.println("Please enter specail meal:");
                            String specialMeal = scanner.nextLine();
                            try {
                                hotel.addWorker(new Chef(workerName, workerAge, workerID, specialMeal, true));
                            } catch (CloneNotSupportedException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            System.out.println("Invalid input");
                        }
                    }
                    break;
                case "4":
                    System.out.println("Please enter the worker ID:");
                    int workerID2 = Integer.parseInt(scanner.nextLine());
                    if(hotel.searchWorkerBoolean(workerID2)){
                        hotel.removeWorker(workerID2);
                    }
                    else{
                        System.out.println("Worker ID does not exist");
                    }
                    break;
                case "5":
                    hotel.printAllRooms();
                    break;
                case "6":
                    hotel.printAllAvailableRooms();
                    break;
                case "7":
                    hotel.printAllUnavailableRooms();
                    break;
                case "8":
                    hotel.printAllWorkers();
                    break;
                case "9":
                    System.out.println("Please enter the worker name:");
                    String workerName2 = scanner.nextLine();
                    hotel.printAllWorkersWithName(workerName2);
                    break;
                case "10":
                    System.out.println("Please enter the room number:");
                    int roomNumber3 = Integer.parseInt(scanner.nextLine());
                    if(hotel.searchRoomBoolean(roomNumber3)){
                        hotel.assignCleanerToRoom(roomNumber3);
                    }
                    else{
                        System.out.println("Room number does not exist");
                    }
                    break;
                case "11"://check if room is available
                    System.out.println("Please enter the room number:");
                    int roomNumber4 = Integer.parseInt(scanner.nextLine());
                    if(hotel.searchRoomBoolean(roomNumber4)){
                        if(hotel.isRoomAvailable(roomNumber4)){
                            System.out.println("Room is available");
                        }
                        else{
                            System.out.println("Room is not available");
                        }
                    }
                    else{
                        System.out.println("Room number does not exist");
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
                
            }

            
        }


        scanner.close();
    }


    /*
     * System.out.println("Welcome to the Hotel Management System");
		System.out.println("Please select an option:");
		System.out.println("1. Add a room");
		System.out.println("2. Remove a room");
		System.out.println("3. Add a worker");
		System.out.println("4. Remove a worker");
		System.out.println("5. Print all rooms");
		System.out.println("6. Print all available rooms");
		System.out.println("7. Print all unavailable rooms");
		System.out.println("8. Print all workers");
		System.out.println("9. Print all workers with a given name");
		System.out.println("10. Assign a cleaner to a room");
		System.out.println("11. Check if a room is available");
		System.out.println("12. Exit");
     */

}
