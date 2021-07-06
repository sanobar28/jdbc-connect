package com.employeePayroll.exception;

public class JdbcConnectionException extends Exception{

	private static final long serialVersionUID = 1L;

	public JdbcConnectionException(String errorMessage) {
		super(errorMessage);
	}
}
