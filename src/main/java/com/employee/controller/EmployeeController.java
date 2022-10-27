package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.ApiResponse;
import com.employee.payload.DepartmentDto;
import com.employee.payload.EmployeeDto;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/")
	public EmployeeDto addEmployee(@Valid @RequestBody EmployeeDto employeeDto)
	{
		return this.employeeService.addEmployee(employeeDto);
	}
	
	@GetMapping("/")
	public List<EmployeeDto> getAllEmployee()
	{
		List<EmployeeDto> emploList=this.employeeService.getAllEmployee();
		
		return emploList;
		
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto>  getEmployeeById(@PathVariable("employeeId")int employeeId)
	{
		EmployeeDto emp=this.employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<EmployeeDto>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<ApiResponse> deleteEmployeeById(@PathVariable("employeeId")int employeeId)
	{
		this.employeeService.deleteEmployeeById(employeeId);
		ApiResponse response=new ApiResponse("Employee Record Not found", true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto, @PathVariable("employeeId")int employeeId)
	{
		EmployeeDto updateemp = this.employeeService.updateEmployee(employeeDto, employeeId);
		return new ResponseEntity<EmployeeDto>(updateemp,HttpStatus.OK);
		
	}

}
