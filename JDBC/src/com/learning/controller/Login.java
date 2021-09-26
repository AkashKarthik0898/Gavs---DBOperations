package com.learning.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String uname;
		Connection con = null;
		PreparedStatement ps;
		String upassword;
		ResultSet rs;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Login UserId and Password:");
		while (true) {
			uname = scan.nextLine();
			upassword = scan.nextLine();
			con = Conections.getConnection();
			ps = con.prepareStatement("select * from user_login where uname = ? and upassword = ?");
			ps.setString(1, uname);
			ps.setString(2, upassword);
			rs = ps.executeQuery();

			if (!rs.next()) {
				System.out.println("Invalid Request. Try Again");
			} else {
				scan.close();
				ps = con.prepareStatement("select * from user_login where uname = ?");
				ps.setString(1, uname);
				rs = ps.executeQuery();
				rs.next();
				String s = rs.getString(4);

				if (s.equalsIgnoreCase("admin")) {
					System.out.println("Welcome "+rs.getString(4)+" user! You have logged in as " + rs.getString(2)  );
					AdminOperations.start();
				}
					
				else {
					System.out.println("Welcome "+rs.getString(4)+" user! You have logged in as " + rs.getString(2)  );
					UserOperations.start();
				}
					

			}
		}

	}

}
