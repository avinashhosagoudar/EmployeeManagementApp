package com.employee.payload;

import java.util.ArrayList;
import java.util.List;

import com.employee.entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class DepartmentDto 
{

	private int departmentId;
	
	private String departmentName;
	
	private String departmentDescription;
	
	
	
	private List<EmployeeEntity> employeelist=new ArrayList();

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public List<EmployeeEntity> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<EmployeeEntity> employeelist) {
		this.employeelist = employeelist;
	}

	@Override
	public String toString() {
		return "DepartmentDto [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentDescription=" + departmentDescription + ", employeelist=" + employeelist + "]";
	}

	

	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
