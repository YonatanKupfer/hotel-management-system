package com.hotelmanagement;

import java.util.Scanner;

public class HotelSystem {
    
    
    public HotelSystem(){
    }
    
    public void hotelManager(){
        Hotel hotel = new Hotel();
        ////////////////test variables///////////////
        try {
        Cleaner cl1 = new Cleaner("Moti", 21, 111, 1, true);
		Cleaner cl2 = new Cleaner("Yosi", 22, 112, 1, true);
		Cleaner cl3 = new Cleaner("Walid", 23, 113, 1, true);
		Cleaner cl4 = new Cleaner("Ahmed", 24, 114, 2, true);
        Cleaner cl5 = new Cleaner("Dvir", 26, 115, 2, true);
        Cleaner cl6 = new Cleaner("Dvir", 26, 116, 3, true);
		Security se1 = new Security("Avi", 35, 211, 7, true);
		Security se2 = new Security("Mor", 31, 212, 8, true);
		Chef ch1 = new Chef("Vivian", 28, 311, "Chicken with tomato", true);
		Chef ch2 = new Chef("Avia", 29, 312, "Fish and chips", true);
		Waiter wa1 = new Waiter("Adina", 17, 411, 3, true);
		Waiter wa2 = new Waiter("Ora", 16, 412, 4, true);
		Waiter wa3 = new Waiter("Amir", 16, 413, 4, true);
        Waiter wa4 = new Waiter("Yonatan", 21, 414, 5, true);
        Waiter wa5 = new Waiter("Yakov", 18, 415, 3, true);
		FunctionHall fh1 = new FunctionHall(11, "big", "Conference room", 100); 
		FunctionHall fh2 = new FunctionHall(12, "small", "Storage room", 10); 
		GuestRoom gr1 = new GuestRoom(21, "Regular room", 4);
		GuestRoom gr2 = new GuestRoom(22, "Regular room", 3);
		GuestRoom gr3 = new GuestRoom(23, "Regular room", 5);
		GuestRoom gr4 = new GuestRoom(24, "Regular room", 4);
		GuestRoom su1 = new GuestRoom(25, "Suite room", 2);
		GuestRoom su2 = new GuestRoom(26, "Suite room", 2);
		hotel.addWorker(cl1);
		hotel.addWorker(cl2);
        hotel.addWorker(cl3);
        hotel.addWorker(cl4);
        hotel.addWorker(cl5);
        hotel.addWorker(cl6);
        hotel.addWorker(se1);
        hotel.addWorker(se2);
        hotel.addWorker(ch1);
        hotel.addWorker(ch2);
        hotel.addWorker(wa1);
        hotel.addWorker(wa2);
        hotel.addWorker(wa3);
        hotel.addWorker(wa4);
        hotel.addWorker(wa5);
        hotel.addRoom(fh1);
		hotel.addRoom(fh2);
		hotel.addRoom(gr1);
		hotel.addRoom(gr2);
		hotel.addRoom(gr3);
		hotel.addRoom(gr4);
		hotel.addRoom(su1);
		hotel.addRoom(su2);
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
		
        ///////////////end of variables//////////////
        
        
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String menu = "";
    

        while(!exit){
            hotel.printSystemMenu();
            menu = scanner.nextLine();
            switch(menu){
                case "1":
                    boolean exit_hotel = false;
                    while(!exit_hotel){
                        hotel.printHotelMenu();
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
                                boolean flag = true;
                                while(flag){
                                    System.out.println("Enter 1 for guest room, 2 for function hall:");
                                    int roomChoice = Integer.parseInt(scanner.nextLine());
                                    if(roomChoice == 1){
                                        boolean roomTypeFlag = true;
                                        String roomType = "";
                                        while(roomTypeFlag){
                                            System.out.println("Please choose a room type:(1 for regular room, 2 for suite room)");
                                            int roomTypeChoise = Integer.parseInt(scanner.nextLine());
                                            if(roomTypeChoise == 1){
                                                roomType = "Regular room";
                                                roomTypeFlag = false;
                                            }
                                            else if(roomTypeChoise == 2){
                                                roomType = "Suite room";
                                                roomTypeFlag = false;
                                            }
                                            else{
                                                System.out.println("Invalid input");
                                            }
                                        }
                                        System.out.println("Please enter the number of beds:");
                                        int numberOfBeds = Integer.parseInt(scanner.nextLine());
                                        try {
                                            hotel.addRoom(new GuestRoom(roomNumber, roomType, numberOfBeds));
                                            flag = false;
                                            System.out.println("Room number " + roomNumber + " was added successfully");
                                        } catch (CloneNotSupportedException e) {
                                            e.printStackTrace();
                                        }
                                    }else if(roomChoice == 2){
                                        boolean roomTypeFlag = true;
                                        String roomType = "";
                                        while(roomTypeFlag){
                                            System.out.println("Please choose a room type:(1 for big, 2 for small)");
                                            int roomTypeChoise = Integer.parseInt(scanner.nextLine());
                                            if(roomTypeChoise == 1){
                                                roomType = "big";
                                                roomTypeFlag = false;
                                            }
                                            else if(roomTypeChoise == 2){
                                                roomType = "small";
                                                roomTypeFlag = false;
                                            }
                                            else{
                                                System.out.println("Invalid input");
                                            }
                                        }
                                        System.out.println("Please enter the purpose:");
                                        String purpose = scanner.nextLine();
                                        System.out.println("Please enter the capacity:");
                                        int capacity = Integer.parseInt(scanner.nextLine());
                                        try {
                                            hotel.addRoom(new FunctionHall(roomNumber, roomType, purpose, capacity));
                                            flag = false;
                                            System.out.println("Room number " + roomNumber + " was added successfully");
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
                                    Room roomToRemove = hotel.getRoomByNumber(roomNumber2);
                                    hotel.removeRoom(roomNumber2);
                                    System.out.println("Room number " + roomToRemove.getRoomNumber() + " was removed successfully");
                                }
                                else{
                                    System.out.println("Room number does not exist");
                                }
                                break;
                            case "3"://sort rooms by room number
                                hotel.sortRoomsByRoomNumber();
                                System.out.println("Rooms were sorted by room number");
                                break;
                            case "4":
                                hotel.printAllRooms();
                                break;
                            case "5":
                                System.out.println("Please enter a given day in a month:");
                                int date = Integer.parseInt(scanner.nextLine());
                                hotel.printAllAvailableRooms(date);
                                break;
                            case "6":
                                System.out.println("Please enter a given day un a month:");
                                int date2 = Integer.parseInt(scanner.nextLine());
                                hotel.printAllUnavailableRooms(date2);
                                break;
                            case "7"://check if room is available
                                System.out.println("Please enter the room number:");
                                int roomNumber4 = Integer.parseInt(scanner.nextLine());
                                System.out.println("Please enter a day in a month:");
                                int date3 = Integer.parseInt(scanner.nextLine());
                                if(hotel.searchRoomBoolean(roomNumber4)){
                                    if(hotel.isRoomAvailable(roomNumber4, date3)){
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
                            case "8"://book a room
                                System.out.println("Please enter wanted date:");
                                int date4 = Integer.parseInt(scanner.nextLine());
                                System.out.println("Please choose a room type:(1 for guest room, 2 for function hall)");
                                int roomChoice2 = Integer.parseInt(scanner.nextLine());
                                if(roomChoice2 == 1){
                                    System.out.println("Please choose a room type:(1 for regular room, 2 for suite room)");
                                    int roomType2 = Integer.parseInt(scanner.nextLine());
                                    if(roomType2 == 1){
                                        int roomToBook = hotel.findAvailableRoom(date4, "Regular room");
                                        if(roomToBook != -1){
                                            System.out.println("Room number " + roomToBook + " is available");
                                            System.out.println("Do you want to book this room? (y/n)");
                                            String answer = scanner.nextLine();
                                            if(answer.equals("y")){
                                                hotel.assignRoomToGuest(roomToBook, date4);
                                            }
                                            else{
                                                System.out.println("Room was not booked");
                                            }
                                        }
                                        else{
                                            System.out.println("No available rooms");
                                        }
                                    }
                                    else if(roomType2 == 2){
                                        int roomToBook = hotel.findAvailableRoom(date4, "Suite room");
                                        if(roomToBook != -1){
                                            System.out.println("Room number " + roomToBook + " is available");
                                            System.out.println("Do you want to book this room? (y/n)");
                                            String answer = scanner.nextLine();
                                            if(answer.equals("y")){
                                                hotel.assignRoomToGuest(roomToBook, date4);
                                            }
                                            else{
                                                System.out.println("Room was not booked");
                                            }
                                        }
                                        else{
                                            System.out.println("No available rooms");
                                        }
                                    }
                                    else{
                                        System.out.println("Invalid input");
                                    }
                                }
                                else if(roomChoice2 == 2){
                                    System.out.println("Please choose a room type:(1 for big, 2 for small)");
                                    int roomType2 = Integer.parseInt(scanner.nextLine());
                                    if(roomType2 == 1){
                                        int roomToBook = hotel.findAvailableRoom(date4, "big");
                                        if(roomToBook != -1){
                                            System.out.println("Room number " + roomToBook + " is available");
                                            System.out.println("Do you want to book this room? (y/n)");
                                            String answer = scanner.nextLine();
                                            if(answer.equals("y")){
                                                hotel.assignRoomToGuest(roomToBook, date4);
                                            }
                                            else{
                                                System.out.println("Room was not booked");
                                            }
                                        }
                                        else{
                                            System.out.println("No available rooms");
                                        }
                                    }
                                    else if(roomType2 == 2){
                                        int roomToBook = hotel.findAvailableRoom(date4, "small");
                                        if(roomToBook != -1){
                                            System.out.println("Room number " + roomToBook + " is available");
                                            System.out.println("Do you want to book this room? (y/n)");
                                            String answer = scanner.nextLine();
                                            if(answer.equals("y")){
                                                hotel.assignRoomToGuest(roomToBook, date4);
                                            }
                                            else{
                                                System.out.println("Room was not booked");
                                            }
                                        }
                                        else{
                                            System.out.println("No available rooms");
                                        }
                                    }
                                    else{
                                        System.out.println("Invalid input");
                                    }
                                }
                                else{
                                    System.out.println("Invalid input");
                                }
                                break;
                            case "9":// leave room
                                System.out.println("Please enter the room number:");
                                int roomNumber3 = Integer.parseInt(scanner.nextLine());
                                System.out.println("Please enter this month's day:");
                                int date5 = Integer.parseInt(scanner.nextLine());
                                if(hotel.searchRoomBoolean(roomNumber3)){
                                    if(hotel.isRoomAvailable(roomNumber3, date5)){
                                        System.out.println("Room is already available");
                                    }
                                    else{
                                        hotel.leaveRoom(roomNumber3, date5);
                                    }
                                }
                                else{
                                    System.out.println("Room number does not exist");
                                }
                                break;
                            case "10"://exit to main menu
                                exit_hotel = true;
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                            
                        }
                    }
                    break;
                case "2":
                    boolean exit_workers = false;
                    while(!exit_workers){
                        hotel.printWorkersMenu();
                        input = scanner.nextLine();
                        switch(input){
                            case "1":
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
                                            hotel.addWorker(new Cleaner(workerName, workerAge, workerID, dayShift, true));
                                            flag2 = false;
                                            System.out.println("Cleaner, " + workerName + ", day shift: " + dayShift + " was added successfully");
                                        } catch (CloneNotSupportedException e) {
                                            e.printStackTrace();
                                        }
                                    }else if(workerChoice == 2){
                                        System.out.println("Please enter years of experience:");
                                        int yearsOfExperience = Integer.parseInt(scanner.nextLine());
                                        try {
                                            hotel.addWorker(new Security(workerName, workerAge, workerID, yearsOfExperience, true));
                                            flag2 = false;
                                            System.out.println("Security, " + workerName + ", was added successfully");
                                        } catch (CloneNotSupportedException e) {
                                            e.printStackTrace();
                                        }
                                    }else if(workerChoice == 3){
                                        System.out.println("Please enter the day shift:");
                                        int dayShift = Integer.parseInt(scanner.nextLine());
                                        try {
                                            hotel.addWorker(new Waiter(workerName, workerAge, workerID, dayShift, true));
                                            flag2 = false;
                                            System.out.println("Waiter, " + workerName + ", day shift: " + dayShift + " was added successfully");
                                        } catch (CloneNotSupportedException e) {
                                            e.printStackTrace();
                                        }
                                    }else if(workerChoice == 4){
                                        System.out.println("Please enter specail meal:");
                                        String specialMeal = scanner.nextLine();
                                        try {
                                            hotel.addWorker(new Chef(workerName, workerAge, workerID, specialMeal, true));
                                            flag2 = false;
                                            System.out.println("Chef, " + workerName + ", was added successfully");
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
                                System.out.println("Please enter the worker ID:");
                                int workerID2 = Integer.parseInt(scanner.nextLine());
                                if(hotel.searchWorkerBoolean(workerID2)){
                                    Worker workerToRemove = hotel.getWorkerByID(workerID2);
                                    hotel.removeWorker(workerID2);
                                    System.out.println("Worker " + workerToRemove.getWorkerID() + ", " + workerToRemove.getName() + ", was removed successfully");
                                }
                                else{
                                    System.out.println("Worker ID does not exist");
                                }
                                break;
                            case "3":
                                hotel.printAllWorkers();
                                break;
                            case "4":
                                System.out.println("Please enter the worker name:");
                                String workerName2 = scanner.nextLine();
                                hotel.printAllWorkersWithName(workerName2);
                                break;
                            case "5":
                                System.out.println("Please enter the room number:");
                                int roomNumber3 = Integer.parseInt(scanner.nextLine());
                                System.out.println("Please enter the day shift:");
                                int dayShift = Integer.parseInt(scanner.nextLine());
                                if(hotel.searchRoomBoolean(roomNumber3)){
                                    hotel.assignCleanerToRoom(roomNumber3, dayShift);
                                }
                                else{
                                    System.out.println("Room number does not exist");
                                }
                                break;
                            case "6"://check sufficiency of workers
                                hotel.checkChef();
                                hotel.checkCleaningStaff();
                                hotel.checkSecurityStaff();
                                hotel.checkWaiterStaff();
                                break;
                            case "7":
                                exit_workers = true;
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    }
                    break;
                case "3":
                    exit = true;
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
		System.out.println("6. Print all available rooms in a given day");
		System.out.println("7. Print all unavailable rooms in a given day");
		System.out.println("8. Print all workers");
		System.out.println("9. Print all workers with a given name");
		System.out.println("10. Assign a cleaner to a room");
		System.out.println("11. Check if a room is available");
		System.out.println("12. Exit");
     */

}
