package com.societegenerale.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@InjectMocks
	EmployeeServiceImpl service = new EmployeeServiceImpl();

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
		exceptionRule.expectMessage("Employee Data null or missing");
		service.createEmployee(null);
	}
	
	@Test
	public void whenEmptyEmp_thenThrowExceptionAndExpectationSatisfied() throws EmployeeException{
		exceptionRule.expect(NullPointerException.class);
		service.createEmployee(new Employee()).getFirstName();
	}
	
	@Test
	public void createEmployeeTest() throws EmployeeException{
		Mockito.when(employeeDao.save(employee)).thenReturn(employee);
		Employee emp = service.createEmployee(employee);
		assertNotNull(employee);
		assertNotNull(emp);
		assertEquals("chakradhar", emp.getFirstName());
		assertEquals("battili", emp.getLastName());
		assertEquals(Gender.MALE, emp.getGender());
		assertEquals("CSE", emp.getDepartment());
	}
	
	@Test
	public void whenNoEmpFetch_thenThrowExceptedNull() throws EmployeeException{
		assertNull(service.fetchAllEmployeesList());
	}

	@Test
	public void getAllEmployeeDetailsTest() throws EmployeeException{
		Mockito.when(employeeDao.findAll()).thenReturn(listEmp);
		assertNotNull(listEmp);
		assertEquals(listEmp,service.fetchAllEmployeesList());
	}
}
