package com.societegenerale.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.societegenerale.exception.EmployeeException;
import com.societegenerale.model.Employee;
import com.societegenerale.service.EmployeeService;


/**
* This class act as restservice controller

* @author  Chakradhar
* @version 1.0
*/
@RestController
@RequestMapping("api/employee")
@Api(value="EmployeeController")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/fetch")
	@ApiOperation(value = "View a List of All Employees", response = List.class)
	public List<Employee> fetchAllEmployeesList() throws EmployeeException {
		return employeeService.fetchAllEmployeesList();
	}
	
	@PostMapping("/create")
	@ApiOperation(value = "Register an employee")
	@ResponseStatus(HttpStatus.OK)
	public Employee createEmployee(@RequestBody Employee employee) throws EmployeeException {
		if(!Optional.ofNullable(employee).isPresent()) throw new EmployeeException("Employee input data missing");
		return employeeService.createEmployee(employee);
	}
}