package com.societegenerale;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.societegenerale.controller.EmployeeControllerTest;
import com.societegenerale.service.EmployeeServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({EmployeeControllerTest.class,EmployeeServiceImplTest.class})
public class EmployeePortalTestSuite {

}
