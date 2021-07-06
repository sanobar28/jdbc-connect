package com.employeePayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

import com.employeePayroll.exception.JdbcConnectionException;
import java.sql.Driver;


public class JdbcConnection {
	public static void main(String[] args) throws JdbcConnectionException {

		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String password = "Sanobar@28397";

		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException e) {
			throw new JdbcConnectionException("Cannot find the driver in the class path" + e);
		}
		
		listDrivers();
		
		try {
			System.out.println("Connecting to database" + jdbcURL);
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successful!!" + connection);
		} catch (Exception e) {
			throw new JdbcConnectionException(e.getMessage());
		}
				
	}
	

	/**
	 * Method in which drivers are stored in enumeration list
	 * to get its class name
	 */
	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}
}
