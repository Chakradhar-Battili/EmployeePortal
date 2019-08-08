package com.chakra;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.chakra.controller.EmployeeControllerTest;
import com.chakra.service.EmployeeServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({EmployeeControllerTest.class,EmployeeServiceImplTest.class})
public class EmployeePortalTestSuite {

}
