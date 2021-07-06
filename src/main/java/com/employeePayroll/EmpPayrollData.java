package com.employeePayroll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employeePayroll.exception.JdbcConnectionException;
import com.employeePayroll.model.Employee;
import com.employeePayroll.util.JdbcConnection;

public class EmpPayrollData {

	/**
	 * Method to retrieve employee data from database and stored in list 
	 * @return
	 * @throws JdbcConnectionException
	 * @throws SQLException
	 */
	public List<Employee> getEmployeeList() throws JdbcConnectionException, SQLException {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		String query = "select * from employee_payroll";
		Connection connection = JdbcConnection.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			Employee employee = new Employee();
			
			employee.setEmployee_name(resultSet.getString("employee_name"));
			employee.setGender(resultSet.getString("gender"));
			employee.setId(resultSet.getInt("id"));
			employee.setStart_date(resultSet.getDate("start_date").toLocalDate());
			employee.setDepartment(resultSet.getString("department"));
			employeeList.add(employee);
			System.out.println(resultSet.getInt("id") + " " + resultSet.getString("employee_name"));	
		}
		
		return employeeList;

		
		
		
	}

}
