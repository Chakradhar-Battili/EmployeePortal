package com.chakra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chakra.model.Employee;
/**
* This class will handle all DB operations
*
* @author  Chakradhar
*/
@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long>{

}
