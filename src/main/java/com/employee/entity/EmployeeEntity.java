package com.employee.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "employee")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	
	@NotEmpty(message = "Employee Name can not be empty")
	@Size(min=4,max=10,message = "Employee Name must be min 4 charecters and Max 20 charecters")
	@Column(nullable = false)
	private String employeeName;

	@NotEmpty(message = "Employee Contact can not be empty")
	@Size(min=10,max=10,message = "Employee Contact must be min 10 digits and Max 10 digits")
	@Column(nullable = false)
	private String employeeContact;
	
	@Column(nullable = false)
	@Min(value=15,message = "Employee age must be min 15")
	@Max(value=60,message  = "Employee Age must be max 60")
	private int employeeAge;
	
	@NotEmpty(message = "Employee Salary can not be null")
	@Size(min=6,max=7,message = "Employee salary must be min 100000 and max 1000000")	
	@Column(nullable = false)
	private String employeeSalary;
	
	@Column(nullable = false)
	@NotEmpty(message = "Employee DOB can not be empty")
	private String employeeDOB;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	
	@JsonIgnore
	private DepartmentEntity department;
	
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonIgnore
	private List<ProjectEntity> projectlist=new ArrayList<>();

	

}
