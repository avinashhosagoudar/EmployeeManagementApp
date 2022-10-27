package com.employee.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.employee.entity.ProjectEntity;

@DataJpaTest
public class ProjectRepositoryTests 
{

	
	@Autowired
	private ProjectRepository projectRepository;
	
	private ProjectEntity obj;
	
	@BeforeEach
	public void setup()
	{
		 obj=ProjectEntity.builder().projectName("Employee Management System")
				.projectDescription("Managing the Employees")
				.projectDuration("10 hours")
				.build();
	}
	@Test
	@DisplayName("Junit Test for saving the Project list")
	public void given_when_then()
	{
		//Given
//		ProjectEntity obj=ProjectEntity.builder().projectName("Employee Management System")
//														.projectDescription("Managing the Employees")
//														.projectDuration("10 hours")
//														.build();
		//When
		ProjectEntity savedproject=projectRepository.save(obj);
		//Then
		Assertions.assertThat(savedproject).isNotNull();
		Assertions.assertThat(savedproject.getProjectId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Junit Test for get all Project list")
	public void givenProjectObject_whengettingallProject_thenTeturnAllProject()
	{
		//Given
//		ProjectEntity obj=ProjectEntity.builder().projectName("Employee Management System")
//				.projectDescription("Managing the Employees")
//				.projectDuration("10 hours")
//				.build();
		
		ProjectEntity obj1=ProjectEntity.builder().projectName("Placement Management System")
				.projectDescription("Managing the Employees")
				.projectDuration("10 hours")
				.build();
		
		projectRepository.save(obj);
		projectRepository.save(obj1);
		
		//When
		List<ProjectEntity> projectlist=this.projectRepository.findAll();
		
		//Then
		Assertions.assertThat(projectlist.size()).isNotNull();
		Assertions.assertThat(projectlist.size()).isEqualTo(2);
		
		
		
	}
	
	@Test
	@DisplayName("Junit Test for get Project By Id")
	public void givenProjectObject_whenFindById_thenTeturnProjectObject()
	{
		//Given
//		ProjectEntity obj=ProjectEntity.builder().projectName("Employee Management System")
//				.projectDescription("Managing the Employees")
//				.projectDuration("10 hours")
//				.build();
		ProjectEntity savedproject=projectRepository.save(obj);
		//when
		ProjectEntity projectbyid=this.projectRepository.findById(savedproject.getProjectId()).get();
		//then
		Assertions.assertThat(projectbyid).isNotNull();
		Assertions.assertThat(projectbyid.getProjectId()).isGreaterThan(0);
		Assertions.assertThat(projectbyid.getProjectId()).isEqualTo(savedproject.getProjectId());
		
		
	}
	
	@Test
	@DisplayName("Junit Test for Update Project list")
	public void givenProjectObject_whenUpdatedProject_thenTeturnUpdatedProject()
	{
//		ProjectEntity obj=ProjectEntity.builder().projectName("Employee Management System")
//				.projectDescription("Managing the Employees")
//				.projectDuration("10 hours")
//				.build();
		ProjectEntity savedproject=projectRepository.save(obj);
		
		
		ProjectEntity projectDb=this.projectRepository.findById(savedproject.getProjectId()).get();
		
		projectDb.setProjectName("Placement management system");
		ProjectEntity updatedproject=projectRepository.save(projectDb);
		
		
		
		Assertions.assertThat(updatedproject).isNotNull();
		Assertions.assertThat(updatedproject.getProjectName()).isEqualTo("Placement management system");
	}
	
	
	@Test
	@DisplayName("Junit Test for Delate Project list")
	public void givenProjectObject_whenDeletedProject_thenTeturnDeletedProject()
	{
//		ProjectEntity obj=ProjectEntity.builder().projectName("Employee Management System")
//				.projectDescription("Managing the Employees")
//				.projectDuration("10 hours")
//				.build();
		ProjectEntity savedproject=projectRepository.save(obj);
		
		
		ProjectEntity projectDb=this.projectRepository.findById(savedproject.getProjectId()).get();
		this.projectRepository.delete(projectDb);
		
		Optional<ProjectEntity> projectdb=this.projectRepository.findById(obj.getProjectId());
		
		Assertions.assertThat(projectdb).isEmpty();
	
	
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL  Indexed Pram")
	public void givenProjectName_whenFindByJPQLIndexed_thenReturnProjectObject()
	{
		//Given
		ProjectEntity saved=projectRepository.save(obj);
		//When
		ProjectEntity savedDpt=projectRepository.findByProjectNameWithIndexedParam(obj.getProjectName());
		//Then
		Assertions.assertThat(savedDpt).isNotNull();
		Assertions.assertThat(savedDpt.getProjectId()).isGreaterThan(0); 
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL  Named Pram")
	public void givenProjectName_whenFindByJPQLNamed_thenReturnProjectObject()
	{
		//Given
		ProjectEntity saved=projectRepository.save(obj);
		//When
		ProjectEntity savedDpt=projectRepository.findByProjectNameWithNamedParam(obj.getProjectName());
		//Then
		Assertions.assertThat(savedDpt).isNotNull();
		Assertions.assertThat(savedDpt.getProjectId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Indexed Pram")
	public void givenProjectName_whenFindByJPQLWithNativeSQLIndexedParam_thenReturnProjectObject()
	{
		//Given
		ProjectEntity saved=projectRepository.save(obj);
		//When
		ProjectEntity savedDpt=projectRepository.findByProjectNameWithNativeSQLIndexedParam(obj.getProjectName());
		//Then
		Assertions.assertThat(savedDpt).isNotNull();
		Assertions.assertThat(savedDpt.getProjectId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Indexed Pram")
	public void givenProjectName_whenFindByJPQLWithNativeSQLNamedParam_thenReturnProjectObject()
	{
		//Given
		ProjectEntity saved=projectRepository.save(obj);
		//When
		ProjectEntity savedDpt=projectRepository.findByProjectNameWithNativeSQLNamedParam(obj.getProjectName());
		//Then
		Assertions.assertThat(savedDpt).isNotNull();
		Assertions.assertThat(savedDpt.getProjectId()).isGreaterThan(0);
	}
	
	
}
