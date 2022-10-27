package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> 
{
	@Query("select p from ProjectEntity p where p.projectName=?1")
	ProjectEntity findByProjectNameWithIndexedParam(String projectName);
	
	@Query("select p from ProjectEntity p where p.projectName=:projectName")
	ProjectEntity findByProjectNameWithNamedParam(@Param("projectName") String projectName);
	
	@Query(value="select * from project d where d.project_name=?1",nativeQuery = true)
	ProjectEntity findByProjectNameWithNativeSQLIndexedParam(String projectName);
	
	@Query(value="select * from project d where d.project_name=:projectName",nativeQuery = true)
	ProjectEntity findByProjectNameWithNativeSQLNamedParam(@Param("projectName")String projectName);

}
