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
import com.employee.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController 
{
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public DepartmentDto addDepartment(@Valid @RequestBody DepartmentDto departmentDto)
	{
		return departmentService.addDepartment(departmentDto);
		
	}
	
	@GetMapping("/")
	public List<DepartmentDto> getAllDepartment()
	{
		List<DepartmentDto> department=this.departmentService.getAllDepartment();
		
		return department;
	}
	
	@GetMapping("/{departmentId}")
	public ResponseEntity<DepartmentDto>  getDepartmentById(@PathVariable("departmentId")int departmentId)
	{
		DepartmentDto dpt=this.departmentService.getDepartmentById(departmentId);
		return new ResponseEntity<DepartmentDto>(dpt,HttpStatus.OK);
	}
	
	@DeleteMapping("/{departmentId}")
	public ResponseEntity<ApiResponse> deleteDepartmentById(@PathVariable("departmentId")int departmentId)
	{
		this.departmentService.deleteDepartmentById(departmentId);
		ApiResponse response=new ApiResponse("Department Record Not found", true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/{departmentId}")
	public ResponseEntity<DepartmentDto> updateDepartment(@Valid @RequestBody DepartmentDto departmentDto, @PathVariable("departmentId")int departmentId)
	{
		DepartmentDto updateDepartment = this.departmentService.updateDepartment(departmentDto, departmentId);
		return new ResponseEntity<DepartmentDto>(updateDepartment,HttpStatus.OK);
		
	}


	
	
}
