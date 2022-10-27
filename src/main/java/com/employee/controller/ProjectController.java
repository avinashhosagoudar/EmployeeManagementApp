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
import com.employee.payload.EmployeeDto;
import com.employee.payload.ProjectDto;
import com.employee.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController 
{
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/")
	public ProjectDto addProject(@Valid @RequestBody ProjectDto projectDto)
	{
		return this.projectService.addProject(projectDto);
	}
	
	@GetMapping("/")
	public List<ProjectDto> getAllProject()
	{
		List<ProjectDto> projectList=this.projectService.getAllProject();
		
		return projectList;
		
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<ProjectDto>  getProjectById(@PathVariable("projectId")int projectId)
	{
		ProjectDto project=this.projectService.getProjectById(projectId);
		return new ResponseEntity<ProjectDto>(project,HttpStatus.OK);
	}
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<ApiResponse> deleteProjectById(@PathVariable("projectId")int projectId)
	{
		this.projectService.deleteProjectById(projectId);
		ApiResponse response=new ApiResponse("Project Record Not found", true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/{projectId}")
	public ResponseEntity<ProjectDto> updateProject(@Valid @RequestBody ProjectDto projectDto, @PathVariable("projectId")int projectId)
	{
		ProjectDto updateproject = this.projectService.updateProject(projectDto, projectId);
		return new ResponseEntity<ProjectDto>(updateproject,HttpStatus.OK);
		
	}
	

	
}
