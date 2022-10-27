package com.employee.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DepartmentRepositoryTests.class,EmployeeRepositoryTests.class,ProjectRepositoryTests.class})
public class AllTests {

}
