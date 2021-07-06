package com.employeePayroll.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeePayroll.EmpPayrollData;
import com.employeePayroll.exception.EmployeePayrollException;
import com.employeePayroll.exception.JdbcConnectionException;
import com.employeePayroll.model.Employee;

public class EmployeePayrollService {

	private final EmpPayrollData employeePayrollData = new EmpPayrollData();
	public List<Employee> employeeList = new ArrayList<Employee>();

	public EmployeePayrollService() {

	}

	
	/**
	 * Method to retrieve employee data in list
	 * @return
	 * @throws EmployeePayrollException
	 * @throws SQLException
	 * @throws JdbcConnectionException
	 */
	public List<Employee> getEmployeeList() throws EmployeePayrollException, SQLException, JdbcConnectionException {
		employeeList = employeePayrollData.getEmployeeList();
		System.out.println("Number of employees " + employeeList.size());
		System.out.println("List of employees " + employeeList.toString());
		return employeeList;
	}
	
	
	/**
	 * UC-3 Method to update the salary by name
	 * @param name
	 * @param salary
	 * @return
	 * @throws JdbcConnectionException
	 * @throws SQLException
	 * @throws EmployeePayrollException
	 */
	public int updateSalaryByName(String name, Double salary)
			throws JdbcConnectionException, SQLException, EmployeePayrollException {
		int result = employeePayrollData.updateSalaryByName(name, salary);
		if (result == 0) {
			throw new EmployeePayrollException("Could not update the salary for name " + name);
		}
		return result;
	}
	
	/**
	 * Method to get salary by name
	 * @param name
	 * @return
	 * @throws JdbcConnectionException
	 * @throws SQLException
	 * @throws EmployeePayrollException
	 */
	public Double getSalaryByName(String name) throws JdbcConnectionException, SQLException, EmployeePayrollException {
		Double result = employeePayrollData.getSalaryByName(name);
		System.out.println("Employee Name " + name + " Salary " + result);
		return result;
	}

}
