package com.employee.repository;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.employee.entity.EmployeeEntity;

@DataJpaTest
public class EmployeeRepositoryTests 
{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	private EmployeeEntity obj;
	@BeforeEach
	public void setup()
	{
		 obj=EmployeeEntity.builder().employeeName("arjun")
				.employeeContact("8792293306")
				.employeeAge(25)
				.employeeSalary("400000")
				.employeeDOB("14/07/1999")
				.build();
	}
	
	@Test
	@DisplayName("Junit Test for saving the students list")
	public void given_when_then()
	{
		//Given
//		EmployeeEntity obj=EmployeeEntity.builder().employeeName(                  "arjun")
//													.employeeContact("8792293306")
//													.employeeAge(25)
//													.employeeSalary("400000")
//													.employeeDOB("14/07/1999")
//													.build();
												  
		//When
		EmployeeEntity savedemp=employeeRepository.save(obj);
		//Then
		Assertions.assertThat(savedemp).isNotNull();
		Assertions.assertThat(savedemp.getEmployeeId()).isGreaterThan(0);
	}
	
	
	@Test
	@DisplayName("Junit Test for get all Student list")
	public void givenStudentObject_whengettingallStudent_thenTeturnAllStudent()
	{
		//Given
//		EmployeeEntity obj=EmployeeEntity.builder().employeeName("arjun")
//				.employeeContact("8792293306")
//				.employeeAge(25)
//				.employeeSalary("400000")
//				.employeeDOB("14/07/1999")
//				.build();
		
		EmployeeEntity obj1=EmployeeEntity.builder().employeeName("amith")
				.employeeContact("8792293306")
				.employeeAge(25)
				.employeeSalary("400000")
				.employeeDOB("14/07/1999")
				.build();
		
		
		employeeRepository.save(obj);
		employeeRepository.save(obj1);
		
		//When
		List<EmployeeEntity> emplist=this.employeeRepository.findAll();
		
		//Then
		Assertions.assertThat(emplist.size()).isNotNull();
		Assertions.assertThat(emplist.size()).isEqualTo(2);
		
		
		
	}
	

	@Test
	@DisplayName("Junit Test for get Student By Id")
	public void givenStudentObject_whenFindById_thenTeturnStudentObject()
	{
		//Given
//		EmployeeEntity obj=EmployeeEntity.builder().employeeName("arjun")
//				.employeeContact("8792293306")
//				.employeeAge(25)
//				.employeeSalary("400000")
//				.employeeDOB("14/07/1999")
//				.build();
		EmployeeEntity savedemp= employeeRepository.save(obj);
		//when
		EmployeeEntity employeebyid=this.employeeRepository.findById(savedemp.getEmployeeId()).get();
		//then
		Assertions.assertThat(employeebyid).isNotNull();
		Assertions.assertThat(employeebyid.getEmployeeId()).isGreaterThan(0);
		Assertions.assertThat(employeebyid.getEmployeeId()).isEqualTo(savedemp.getEmployeeId());
		
		
	}
	
	@Test
	@DisplayName("Junit Test for Update Student list")
	public void givenStudentObject_whenUpdatedStudent_thenTeturnUpdatedStudent()
	{
//		EmployeeEntity obj=EmployeeEntity.builder().employeeName("arjun")
//				.employeeContact("8792293306")
//				.employeeAge(25)
//				.employeeSalary("400000")
//				.employeeDOB("14/07/1999")
//				.build();
		EmployeeEntity savedemp= employeeRepository.save(obj);
		
		EmployeeEntity employeedb=this.employeeRepository.findById(savedemp.getEmployeeId()).get();
		
		
		employeedb.setEmployeeName("Praveen");
		EmployeeEntity updatedEmployee=employeeRepository.save(employeedb);
		
		
		Assertions.assertThat(updatedEmployee).isNotNull();
		Assertions.assertThat(updatedEmployee.getEmployeeName()).isEqualTo("Praveen");
	}
	
	@Test
	@DisplayName("Junit Test for Delate Student list")
	public void givenStudentObject_whenDeletedStudent_thenTeturnDeletedStudent()
	{
//		EmployeeEntity obj=EmployeeEntity.builder().employeeName("arjun")
//				.employeeContact("8792293306")
//				.employeeAge(25)
//				.employeeSalary("400000")
//				.employeeDOB("14/07/1999")
//				.build();
		EmployeeEntity savedemp= employeeRepository.save(obj);
		
		
		EmployeeEntity employeedb=this.employeeRepository.findById(savedemp.getEmployeeId()).get();
		this.employeeRepository.delete(employeedb);
		
		Optional<EmployeeEntity> empdb=this.employeeRepository.findById(obj.getEmployeeId());
		
		Assertions.assertThat(empdb).isEmpty();
	
	
	}
	
	
	
	@Test
	@DisplayName("JUNIT test for JPQL Indexed Pram")
	public void givenEmployeeNameandEmployeeAge_whenFindByJPQLIndex_thenReturnEmployeeObject()
	{
		//Given
		EmployeeEntity saved=employeeRepository.save(obj);
		//When
		EmployeeEntity savedemp=employeeRepository.findByEmployeeNameandEmployeeAgeWithIndexedParam(obj.getEmployeeName(),obj.getEmployeeAge());
		//Then
		Assertions.assertThat(savedemp).isNotNull();
		Assertions.assertThat(savedemp.getEmployeeId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL named Pram")
	public void givenEmployeeNameandEmployeeAge_whenFindByJPQLNamed_thenReturnEmployeeObject()
	{
		//Given
		EmployeeEntity saved=employeeRepository.save(obj);
		//When
		EmployeeEntity savedemp=employeeRepository.findByEmployeeNameandEmployeeAgeWithNamedParam(obj.getEmployeeName(),obj.getEmployeeAge());
		//Then
		Assertions.assertThat(savedemp).isNotNull();
		Assertions.assertThat(savedemp.getEmployeeId()).isGreaterThan(0);
	}
	
	
	@Test
	@DisplayName("JUNIT test for JPQL with NativeSQLIndexed Pram")
	public void givenEmployeeNameandEmployeeAge_whenFindByJPQLWithNaviteSQLIndexedParam_thenReturnEmployeeObject()
	{
		//Given
		EmployeeEntity saved=employeeRepository.save(obj);
		//When
		EmployeeEntity savedemp=employeeRepository.findByEmployeeNameandEmployeeAgeWithNativeSQLIndexedParam(obj.getEmployeeName(),obj.getEmployeeAge());
		//Then
		Assertions.assertThat(savedemp).isNotNull();
		Assertions.assertThat(savedemp.getEmployeeId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL with NativeSQLIndexed Pram")
	public void givenEmployeeNameandEmployeeAge_whenFindByJPQLWithNaviteSQLNamedParam_thenReturnEmployeeObject()
	{
		//Given
		EmployeeEntity saved=employeeRepository.save(obj);
		//When
		EmployeeEntity savedemp=employeeRepository.findByEmployeeNameandEmployeeAgeWithNativeSQLNamedParam(obj.getEmployeeName(),obj.getEmployeeAge());
		//Then
		Assertions.assertThat(savedemp).isNotNull();
		Assertions.assertThat(savedemp.getEmployeeId()).isGreaterThan(0);
	}
	
	
	
}
