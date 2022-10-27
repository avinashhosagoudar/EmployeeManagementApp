package com.employee.service;

import java.util.List;
import com.employee.payload.EmployeeDto;

public interface EmployeeService 
{

public EmployeeDto addEmployee(EmployeeDto employeeDto);
	
	public List<EmployeeDto> getAllEmployee();
	
	public EmployeeDto getEmployeeById(int employeeId);
	
	public void deleteEmployeeById(int employeeId);
	
	public EmployeeDto updateEmployee(EmployeeDto employeeDto,int employeeId);
	
	public  List<EmployeeDto> getEmployeeByProject(int projectId);
}
