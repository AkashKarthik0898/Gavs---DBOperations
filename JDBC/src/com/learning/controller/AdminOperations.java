package com.learning.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminOperations {

	public static void start() throws SQLException {
		// TODO Auto-generated method stub
		
		String choice;
		AdminUtilities adutil = new AdminUtilities();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter your operation:");
			System.out.println("1-Insert a data\n2-Read all data from Database\n3-Update data\n"
					+ "4-Delete\n5-Search for a value\n6-Exit the system");
			choice = scan.nextLine();
			switch(choice) {
			case "1":
				adutil.write();
				break;
			case "2":
				adutil.read();
				break;
			case "3":
				adutil.update();
				break;
			case "4":
				adutil.delete();
				break;
			case "5":
				adutil.search();
			case "6":
				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Responce. Try again");
				break;
			}
		
		}
		
	}

}
