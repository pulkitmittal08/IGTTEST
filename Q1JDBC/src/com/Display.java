package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

// insert
//update
//delete
//read

public class Display {

	public static void main(String[] args) {
		// java to database
		// 5 steps
		// step 1 - Load the driver + add the jar file
		// step 2 - create the connection
		// step 3 - create the stmt
		// step 4 - is execute the stmt
		// step 5 - close the connection

		try {
			// put driver name as "com.mysql.cj.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/IGTEXAM", "root", "root");
//	Statement stmt = con.createStatement();
//	stmt.execute("insert into employe values(100,'Bharat',22,5000,'Developer')");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Employee");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getInt(3) + ":" + rs.getInt(4) + ":"
						+ rs.getString(5));
			}

			System.out.println("data Read successfuly...!");

		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
