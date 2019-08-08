package com.chakra.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chakra.dao.EmployeeDAO;
import com.chakra.exception.EmployeeException;
import com.chakra.model.Employee;


/**
* The EmployeeServiceImpl service class implements business logic.
*
* @author  Chakradhar
* @version 1.0
*/
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDao;
	
	 /**
	   * This method will fetch all Employees from H2 DB.
	   * @param Nothing.
	   * @return List<Employee>.
	   * @exception EmployeeException.
	   */
	@Override
	public List<Employee> fetchAllEmployeesList() throws EmployeeException{
		try{
			List<Employee> employeeList = employeeDao.findAll();
			if(employeeList == null || employeeList.isEmpty()) return null;
			
			employeeList.sort(Comparator.comparing(Employee::getFirstName));
			return employeeList;
		}catch(Exception ex){
			throw new EmployeeException("Issue while fetching Employees data");
		}
	}


	 /**
	   * This method will insert new Employee record in H2 DB.
	   * @param Employee.
	   * @return Employee.
	   * @exception EmployeeException.
	   */
	@Override
	public Employee createEmployee(Employee emp) throws EmployeeException{
		if(!Optional.ofNullable(emp).isPresent()) throw new EmployeeException("Employee Data null or missing");
		try{
			return employeeDao.save(emp);
		}catch(Exception ex){
			throw new EmployeeException("Issue while inserting Employees data", ex);
		}
	}
}
