package com.societegenerale.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.societegenerale.dao.EmployeeDAO;
import com.societegenerale.enums.Gender;
import com.societegenerale.exception.EmployeeException;
import com.societegenerale.model.Employee;
import com.societegenerale.service.EmployeeService;
import com.societegenerale.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@InjectMocks
	EmployeeController controller = new EmployeeController();
	
	@InjectMocks
	EmployeeService  empService = new EmployeeServiceImpl();
	
	@Mock
	EmployeeService employeeService;
	
	@Mock
	EmployeeDAO employeeDao;

	Employee employee = new Employee();
	List<Employee> listEmp = new ArrayList<>();
	@Before
	public void setUp() throws ParseException {
		MockitoAnnotations.initMocks(this);
		employee.setFirstName("chakradhar");
		employee.setLastName("battili");	
		employee.setGender(Gender.MALE);
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("28-08-2001"));
		employee.setDepartment("CSE");
		listEmp.add(employee);
	}
	
	@Test
	public void whenNoEmp_thenThrowExceptionAndExpectationSatisfied() throws EmployeeException{
		exceptionRule.expect(EmployeeException.class);
		exceptionRule.expectMessage("Employee input data missing");
		controller.createEmployee(null);
	}
	
	@Test
	public void whenEmptyEmp_thenThrowExceptionAndExpectationSatisfied() throws EmployeeException{
		exceptionRule.expect(NullPointerException.class);
		controller.createEmployee(new Employee()).getFirstName();
	}

	@Test
	public void createEmployeeTest() throws EmployeeException {
		Mockito.when(employeeService.createEmployee(employee)).thenReturn(employee);
		assertNotNull(employee);
		assertEquals(employee.getFirstName(),controller.createEmployee(employee).getFirstName());
	}

	@Test
	public void whenNoEmpFetch_Empty() throws EmployeeException{
		Mockito.when(employeeService.fetchAllEmployeesList()).thenReturn(new ArrayList<Employee>());
		assertEquals(0,controller.fetchAllEmployeesList().size());
	}
	
	@Test
	public void getAllEmployeeDetailsTest() throws EmployeeException {
		Mockito.when(employeeService.fetchAllEmployeesList()).thenReturn(listEmp);
		assertNotNull(listEmp);
		assertEquals(listEmp,controller.fetchAllEmployeesList());
	}
}

