package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> 
{

	@Query("select e from EmployeeEntity e where e.employeeName=?1 and e.employeeAge=?2")
	EmployeeEntity findByEmployeeNameandEmployeeAgeWithIndexedParam(String employeeName,int employeeAge);
	
	@Query("select e from EmployeeEntity e where e.employeeName=:employeeName and e.employeeAge=:employeeAge")
	EmployeeEntity findByEmployeeNameandEmployeeAgeWithNamedParam(@Param("employeeName") String employeeName,@Param("employeeAge") int employeeAge);
	
	@Query(value="select * from employee e where e.employee_name=?1 and e.employee_age=?2",nativeQuery = true)
	EmployeeEntity findByEmployeeNameandEmployeeAgeWithNativeSQLIndexedParam(String employeeName,int employeeAge);
	
	@Query(value="select * from employee e where e.employee_name=:employeeName and e.employee_age=:employeeAge",nativeQuery = true)
	EmployeeEntity findByEmployeeNameandEmployeeAgeWithNativeSQLNamedParam(@Param("employeeName")String employeeName,@Param("employeeAge") int employeeAge);

}
