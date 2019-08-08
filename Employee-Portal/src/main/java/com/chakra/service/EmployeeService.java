package com.chakra.service;

import java.util.List;

import com.chakra.exception.EmployeeException;
import com.chakra.model.Employee;

public interface EmployeeService {
	public List<Employee> fetchAllEmployeesList() throws EmployeeException;
	public Employee createEmployee(Employee emp) throws EmployeeException;
}
