package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.DepartmentEntity;


public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> 
{
	@Query("select d from DepartmentEntity d where d.departmentName=?1")
	DepartmentEntity findByDepartmentNameWithIndexedParam(String departmentName);
	
	@Query("select d from DepartmentEntity d where d.departmentName=:departmentName")
	DepartmentEntity findByDepartmentNameWithNamedParam(@Param("departmentName") String departmentName);
	
	@Query(value="select * from department d where d.department_name=?1",nativeQuery = true)
	DepartmentEntity findByDepartmentNameWithNativeSQLIndexedParam(String departmentName);
	
	@Query(value="select * from department d where d.department_name=:departmentName",nativeQuery = true)
	DepartmentEntity findByDepartmentNameWithNativeSQLNamedParam(@Param("departmentName")String departmentName);
	
}
