package com.employeePayroll.model;

import java.time.LocalDate;

public class Employee {

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employee_name=" + employee_name + ", gender=" + gender + ", start_date="
				+ start_date + ", department=" + department + "]";
	}
	
	public Employee() {
		
	}

	public Employee(int id, String employee_name, String gender, LocalDate start_date, String department) {
		super();
		this.id = id;
		this.employee_name = employee_name;
		this.gender = gender;
		this.start_date = start_date;
		this.department = department;
	}

	public int id;
	public String employee_name;
	public String gender;
	public LocalDate start_date;
	public String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
