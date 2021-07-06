package com.employeePayroll;

import java.sql.SQLException;
import com.employeePayroll.exception.JdbcConnectionException;

public class EmpPayrollMain {
	
	public static void main(String[] args) throws JdbcConnectionException, SQLException {
		 
		EmpPayrollData emppayrolldata = new EmpPayrollData();
		emppayrolldata.getEmployeeList();
		
	}

}
