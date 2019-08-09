package com.chakra.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

import com.chakra.exception.EmployeeException;
import com.chakra.model.Employee;
import com.chakra.service.EmployeeService;


/**
* This class act as restservice controller

* @author  Chakradhar
* @version 1.0
*/
@RestController
@RequestMapping("api/employee")
@Api(value="EmployeeController", produces="Employee or List Of Employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/fetch")
	@ApiOperation(value = "View a List of All Employees")
	public List<Employee> fetchAllEmployeesList() throws EmployeeException {
		return employeeService.fetchAllEmployeesList();
	}
	
	@PostMapping("/create")
	@ApiOperation(produces="Employee Object", value = "Register an employee")
	@ApiResponses(
			value={
					@ApiResponse(code=100,message="100 is the message"),
					@ApiResponse(code=200,message="200 is the message")
			})
	@ResponseStatus(HttpStatus.OK)
	public Employee createEmployee(@RequestBody Employee employee) throws EmployeeException {
		if(!Optional.ofNullable(employee).isPresent()) throw new EmployeeException("Employee input data missing");
		return employeeService.createEmployee(employee);
	}
}
