package com.employee.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.employee.entity.DepartmentEntity;

@DataJpaTest
public class DepartmentRepositoryTests 
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	private DepartmentEntity obj;
	
	
	@BeforeEach
	public void setup()
	{
	 obj=DepartmentEntity.builder().departmentName("IT team")
				.departmentDescription("Information Technology")
				.build();
	}
	
	@Test
	@DisplayName("Junit Test for saving the Department list")
	public void given_when_then()
	{
		//Given
//		DepartmentEntity obj=DepartmentEntity.builder().departmentName("IT")
//														.departmentDescription("Information Technology")
//														.build();
		//When
		DepartmentEntity savedDpt=departmentRepository.save(obj);
		//Then
		Assertions.assertThat(savedDpt).isNotNull();
		Assertions.assertThat(savedDpt.getDepartmentId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Junit Test for get all Department list")
	public void givenDepartmentObject_whengettingallDepartment_thenTeturnAllDepartment()
	{
		//Given
//		DepartmentEntity obj=DepartmentEntity.builder().departmentName("IT Team")
//													   .departmentDescription("Information Technology")
//													   .build();
		
		DepartmentEntity obj1=DepartmentEntity.builder().departmentName("Support")
				   .departmentDescription("Support Team")
				   .build();
		departmentRepository.save(obj);
		departmentRepository.save(obj1);
		
		//When
		List<DepartmentEntity> departmentlist=this.departmentRepository.findAll();
		
		//Then
		Assertions.assertThat(departmentlist.size()).isNotNull();
		Assertions.assertThat(departmentlist.size()).isEqualTo(2);
		
		
		
	}
	
	@Test
	@DisplayName("Junit Test for get Department By Id")
	public void givenDepartmentObject_whenFindById_thenTeturnDepartmentObject()
	{
		//Given
//		DepartmentEntity obj=DepartmentEntity.builder().departmentName("IT")
//													   .departmentDescription("Information Technology")
//													   .build();
		DepartmentEntity savedDepartment= departmentRepository.save(obj);
		//when
		DepartmentEntity departmentbyid=this.departmentRepository.findById(savedDepartment.getDepartmentId()).get();
		//then
		Assertions.assertThat(departmentbyid).isNotNull();
		Assertions.assertThat(departmentbyid.getDepartmentId()).isGreaterThan(0);
		Assertions.assertThat(departmentbyid.getDepartmentId()).isEqualTo(savedDepartment.getDepartmentId());
		
		
	}
	
	@Test
	@DisplayName("Junit Test for Update Department list")
	public void givenDepartmentObject_whenUpdatedDepartment_thenTeturnUpdatedDepartment()
	{
//		DepartmentEntity obj=DepartmentEntity.builder().departmentName("IT")
//				.departmentDescription("Information Technology").build();
		DepartmentEntity savedDpt=departmentRepository.save(obj);
		
		
		DepartmentEntity departmentDb=this.departmentRepository.findById(savedDpt.getDepartmentId()).get();
		
		departmentDb.setDepartmentName("support");
		DepartmentEntity updatedDepartment=departmentRepository.save(departmentDb);
		
		
		
		Assertions.assertThat(updatedDepartment).isNotNull();
		Assertions.assertThat(updatedDepartment.getDepartmentName()).isEqualTo("support");
	}
	
	
	@Test
	@DisplayName("Junit Test for Delate Department list")
	public void givenDepartmentObject_whenDeletedDepartmentt_thenTeturnDeletedDepartment()
	{
//		DepartmentEntity obj=DepartmentEntity.builder().departmentName("IT")
//													   .departmentDescription("Information Technology")
//													   .build();
		DepartmentEntity savedDpt=departmentRepository.save(obj);
		
		
		DepartmentEntity departmentDb=this.departmentRepository.findById(savedDpt.getDepartmentId()).get();
		this.departmentRepository.delete(departmentDb);
		
		Optional<DepartmentEntity> dptdb=this.departmentRepository.findById(obj.getDepartmentId());
		
		Assertions.assertThat(dptdb).isEmpty();
	
	
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL Indexed Pram")
	public void givenDepartmentName_whenFindByJPQLIndex_thenReturnDepartmentObject()
	{
		//Given
		DepartmentEntity saved=departmentRepository.save(obj);
		//When
		DepartmentEntity savedDpt=departmentRepository.findByDepartmentNameWithIndexedParam(obj.getDepartmentName());
		//Then
		Assertions.assertThat(savedDpt).isNotNull();
		Assertions.assertThat(savedDpt.getDepartmentId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL Named Pram")
	public void givenDepartmentName_whenFindByJPQLNamed_thenReturnDepartmentObject()
	{
		//Given
		DepartmentEntity saved=departmentRepository.save(obj);
		//When
		DepartmentEntity savedDpt=departmentRepository.findByDepartmentNameWithNamedParam(obj.getDepartmentName());
		//Then
		Assertions.assertThat(savedDpt).isNotNull();
		Assertions.assertThat(savedDpt.getDepartmentId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Indexed Pram")
	public void givenDepartmentName_whenFindByJPQLNativeIndexed_thenReturnDepartmentObject()
	{
		//Given
		DepartmentEntity saved=departmentRepository.save(obj);
		//When
		DepartmentEntity savedDpt=departmentRepository.findByDepartmentNameWithNativeSQLIndexedParam(obj.getDepartmentName());
		//Then
		Assertions.assertThat(savedDpt).isNotNull();
		Assertions.assertThat(savedDpt.getDepartmentId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Named Pram")
	public void givenDepartmentName_whenFindByJPQLNativeNamed_thenReturnDepartmentObject()
	{
		//Given
		DepartmentEntity saved=departmentRepository.save(obj);
		//When
		DepartmentEntity savedDpt=departmentRepository.findByDepartmentNameWithNativeSQLNamedParam(obj.getDepartmentName());
		//Then
		Assertions.assertThat(savedDpt).isNotNull();
		Assertions.assertThat(savedDpt.getDepartmentId()).isGreaterThan(0);
	}
	
	
	
	
}
