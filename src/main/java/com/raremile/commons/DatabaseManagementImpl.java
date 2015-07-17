package com.raremile.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import com.raremile.DALInterfaces.DatabaseManagement;

public class DatabaseManagementImpl implements DatabaseManagement{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/userprofile";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	Connection conn = null;
	Statement stmt = null;

	public Connection getConnection() {
		try {
			// Registering driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (Exception e) {
			System.out.println("Error Connecting");
		}
		return conn;
	}
}
