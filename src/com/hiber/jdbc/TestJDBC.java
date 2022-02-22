package com.hiber.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hb-03-one-to-many";
			Connection connection = DriverManager.getConnection(url, "root", "Admin@123");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
