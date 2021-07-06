package com.employeePayroll;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.employeePayroll.exception.EmployeePayrollException;
import com.employeePayroll.exception.JdbcConnectionException;
import com.employeePayroll.model.Employee;
import com.employeePayroll.service.EmployeePayrollService;

/**
 * Unit test for simple App.
 */
public class EmployeePayrollServiceTest 
{
	private EmployeePayrollService employeePayrollService;

	@Before
	public void initialize() {
		employeePayrollService = new EmployeePayrollService();
	}
	
	@Test
	public void givenEmployeeRecordsInTable_shouldFetchEmployeeList()
			throws EmployeePayrollException, SQLException, JdbcConnectionException {
		List<Employee> employeeList = employeePayrollService.getEmployeeList();
		assertEquals(8, employeeList.size());
	}

	@Test
	public void givenSalaryAndEmpName_shouldUpdateSalaryForGivenEmpName()
			throws JdbcConnectionException, SQLException, EmployeePayrollException {
		int updatedRows = employeePayrollService.updateSalaryByName("Sanobar", 300000.0);
		assertTrue(updatedRows > 0);
	}
	
	
	public void givenEmpName_shouldRetrieveSalary()
			throws JdbcConnectionException, SQLException, EmployeePayrollException {
		List<Employee> employeeList = employeePayrollService.getEmployeeList();
		Double salary = employeePayrollService.getSalaryByName("Sanobar");
		assertEquals(300000.0, employeeList.get(2));
	}
}
