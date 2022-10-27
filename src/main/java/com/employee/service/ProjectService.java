package com.employee.service;

import java.util.List;


import com.employee.payload.ProjectDto;

public interface ProjectService 
{
	
public ProjectDto addProject(ProjectDto projectDto);
	
	public List<ProjectDto> getAllProject();
	
	public ProjectDto getProjectById(int projectId);
	
	public void deleteProjectById(int projectId);
	
	public ProjectDto updateProject(ProjectDto projectDto,int projectId);
	
	public  List<ProjectDto> getProjectByCourse(int courseId);
}


