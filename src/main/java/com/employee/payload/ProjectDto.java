package com.employee.payload;

import com.employee.entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ProjectDto 
{

	private int projectId;
	
	private String projectName;
	
	private String projectDescription;
	
	private String projectDuration;
	
	//@JsonIgnore
	private EmployeeEntity employee;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ProjectDto [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", projectDuration=" + projectDuration + ", employee=" + employee + "]";
	}

	public ProjectDto(int projectId, String projectName, String projectDescription, String projectDuration,
			EmployeeEntity employee) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectDuration = projectDuration;
		this.employee = employee;
	}

	public ProjectDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
