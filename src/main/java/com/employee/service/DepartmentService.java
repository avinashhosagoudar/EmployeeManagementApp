package com.employee.service;

import java.util.List;

import com.employee.payload.DepartmentDto;




public interface DepartmentService 
{
	public DepartmentDto addDepartment(DepartmentDto departmentDto);
	
	public List<DepartmentDto> getAllDepartment();
	
	public DepartmentDto getDepartmentById(int departmentId);
	
	public void deleteDepartmentById(int departmentId);
	
	public DepartmentDto updateDepartment(DepartmentDto departmentDto,int departmentId);
	
	public  List<DepartmentDto> getDepartmentByEmployee(int employeeId);

	
}
