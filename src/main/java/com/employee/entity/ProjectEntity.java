package com.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "project")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	
	@NotEmpty(message = "Project Name can not be empty")
	@Size(min=4,max=100,message = "Project Name must be min 4 charecters and Max 100 charecters")
	@Column(nullable = false)
	private String projectName;
	
	@NotEmpty(message = "Project Description can not be empty")
	@Size(min=4,max=100,message = "Project Description must be min 4 charecters and Max 100 charecters")
	@Column(nullable = false)
	private String projectDescription;
	
	@NotEmpty(message = "Project Duration can not be empty")
	@Size(min=4,max=10,message = "Project Duration must be min 4 charecters and Max 10 charecters")
	@Column(nullable = false)
	private String projectDuration;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	@JsonIgnore
	private EmployeeEntity employee;
	
}
