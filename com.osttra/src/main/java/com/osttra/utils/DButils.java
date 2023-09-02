package com.osttra.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButils {
	static Connection conn = null;

	public static Connection getConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Root");

			return conn;
		} catch (Exception e) {
			System.out.println("Inside catch of getConnection()...");
			e.printStackTrace();
		}

		return conn;
	}
}
