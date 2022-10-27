package com.employee.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "department")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;
	
	@Column(nullable = false)
	@NotEmpty(message = "Department Name can not be empty")
	@Size(min=4,max=10,message = "Department Name must be min 4 charecters and Max 10 charecters")
	private String departmentName;
	
	@Column(nullable = false)
	@NotEmpty(message = "Department Description can not be empty")
	@Size(min=4,max=100,message = "Department Description must be min 4 charecters and Max 100 charecters")
	private String departmentDescription;
	
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<EmployeeEntity> employeelist=new ArrayList();
	



	
	
	
	
	
	
	

}
