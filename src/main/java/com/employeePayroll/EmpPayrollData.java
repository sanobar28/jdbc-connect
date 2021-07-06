package com.employeePayroll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employeePayroll.exception.EmployeePayrollException;
import com.employeePayroll.exception.JdbcConnectionException;
import com.employeePayroll.model.Employee;
import com.employeePayroll.util.JdbcConnection;

public class EmpPayrollData {

	private static EmpPayrollData empPayrolldata;

	/**
	 * created instance of class object
	 * 
	 * @return
	 */
	public static EmpPayrollData getInstance() {
		if (empPayrolldata == null) {
			empPayrolldata = new EmpPayrollData();
		}
		return empPayrolldata;
	}

	/**
	 * Method to retrieve employee data from database and stored in list
	 * 
	 * @return
	 * @throws JdbcConnectionException
	 * @throws SQLException
	 */
	public List<Employee> getEmployeeList() throws JdbcConnectionException, SQLException, EmployeePayrollException {

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

	/**
	 * Method to update employee salary by name using prepared statement
	 * 
	 * @param name
	 * @param salary
	 * @return
	 * @throws JdbcConnectionException
	 * @throws SQLException
	 * @throws EmployeePayrollException
	 */
	public int updateSalaryByName(String name, Double salary)
			throws JdbcConnectionException, SQLException, EmployeePayrollException {
		try (Connection connection = JdbcConnection.getJdbcConnection()) {
			String query = "update employee_payroll set salary=? where employee_name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, salary);
			preparedStatement.setString(2, name);
			int resultSet = preparedStatement.executeUpdate();
			return resultSet;
		} catch (Exception e) {
			throw new EmployeePayrollException(e.getMessage());
		}
	}

	/**
	 * Method to get employee salary by name using prepared statement
	 * @param name
	 * @return
	 * @throws JdbcConnectionException
	 * @throws SQLException
	 * @throws EmployeePayrollException
	 */
	public Double getSalaryByName(String name) throws JdbcConnectionException, SQLException, EmployeePayrollException {
		try (Connection connection = JdbcConnection.getJdbcConnection()) {
			String query = "select salary from employee_payroll where employee_name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			Double salary = 0.0;
			while (resultSet.next()) {
				salary = resultSet.getDouble("salary");
			}
			return salary;
		} catch (Exception e) {
			throw new EmployeePayrollException(e.getMessage());
		}

	}
}
