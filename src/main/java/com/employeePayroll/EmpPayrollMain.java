package com.employeePayroll;

import java.sql.SQLException;

import com.employeePayroll.exception.EmployeePayrollException;
import com.employeePayroll.exception.JdbcConnectionException;
import com.employeePayroll.service.EmployeePayrollService;

public class EmpPayrollMain {
	
	public static void main(String[] args) throws JdbcConnectionException, SQLException, EmployeePayrollException {
		 
		EmployeePayrollService emppayrolldata = new EmployeePayrollService();
		emppayrolldata.getEmployeeList();
		
	}
}
