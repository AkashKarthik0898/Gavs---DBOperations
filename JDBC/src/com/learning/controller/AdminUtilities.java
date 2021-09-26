package com.learning.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminUtilities {

	PreparedStatement ps;
	static Scanner scan;
	static Connection con;
	static {
		con = Conections.getConnection();
		scan = new Scanner(System.in);

	}

	public void write() throws SQLException {
		// TODO Auto-generated method stub
		int i;
		ps = con.prepareStatement("insert into user_login(uname,upassword,utype) values" + "(?,?,?)");
		System.out.println("Enter The User name , password  to add to the database:");
		ps.setString(1, scan.nextLine());
		ps.setString(2, scan.nextLine());
		System.out.println("Enter Privilage to add to the user");
		System.out.println("List of available privilages: \n 1-"+ Privilages.ADMIN 
				+ "\n2-" + Privilages.MANAGER
				+ "\n3-" + Privilages.DEVELOPER
				+ "\n4-" + Privilages.CLIENT);
		i = Integer.parseInt(scan.nextLine());
		switch(i) {
			case 1:  ps.setString(3, "admin");
		}
	}

	public void read() {
		// TODO Auto-generated method stub
		System.out.println(Privilages.ADMIN.toString());
	}

	public void update() {
		// TODO Auto-generated method stub

	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public void search() {
		// TODO Auto-generated method stub

	}

}
