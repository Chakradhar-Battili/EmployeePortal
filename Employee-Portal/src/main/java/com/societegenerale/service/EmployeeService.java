package com.societegenerale.service;

import java.util.List;

import com.societegenerale.exception.EmployeeException;
import com.societegenerale.model.Employee;

public interface EmployeeService {
	public List<Employee> fetchAllEmployeesList() throws EmployeeException;
	public Employee createEmployee(Employee emp) throws EmployeeException;
}
