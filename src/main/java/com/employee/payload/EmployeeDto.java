package com.employee.payload;

import java.util.ArrayList;
import java.util.List;

import com.employee.entity.DepartmentEntity;
import com.employee.entity.ProjectEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class EmployeeDto 
{
	private int employeeId;
	
	private String employeeName;
	
	private String employeeContact;
	
	private int employeeAge;
	
	private String employeeSalary;
	
	private String employeeDOB;
	
	//@JsonIgnore
	private DepartmentEntity department;

	private List<ProjectEntity> projectlist=new ArrayList<>();


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeeContact() {
		return employeeContact;
	}


	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}


	public int getEmployeeAge() {
		return employeeAge;
	}


	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}


	public String getEmployeeSalary() {
		return employeeSalary;
	}


	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}


	public String getEmployeeDOB() {
		return employeeDOB;
	}


	public void setEmployeeDOB(String employeeDOB) {
		this.employeeDOB = employeeDOB;
	}


	public DepartmentEntity getDepartment() {
		return department;
	}


	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}


	public List<ProjectEntity> getProjectlist() {
		return projectlist;
	}


	public void setProjectlist(List<ProjectEntity> projectlist) {
		this.projectlist = projectlist;
	}


	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeContact="
				+ employeeContact + ", employeeAge=" + employeeAge + ", employeeSalary=" + employeeSalary
				+ ", employeeDOB=" + employeeDOB + ", department=" + department + ", projectlist=" + projectlist + "]";
	}


	public EmployeeDto(int employeeId, String employeeName, String employeeContact, int employeeAge,
			String employeeSalary, String employeeDOB, DepartmentEntity department, List<ProjectEntity> projectlist) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeContact = employeeContact;
		this.employeeAge = employeeAge;
		this.employeeSalary = employeeSalary;
		this.employeeDOB = employeeDOB;
		this.department = department;
		this.projectlist = projectlist;
	}


	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
