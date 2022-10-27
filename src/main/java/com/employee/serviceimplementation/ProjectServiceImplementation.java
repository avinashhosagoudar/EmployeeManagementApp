package com.employee.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.employee.entity.ProjectEntity;
import com.employee.exception.ResourceNotFoundException;

import com.employee.payload.ProjectDto;
import com.employee.repository.ProjectRepository;
import com.employee.service.ProjectService;
@Service
public class ProjectServiceImplementation implements ProjectService
{
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public ProjectDto addProject(ProjectDto projectDto) {
		ProjectEntity projectEntity=this.modelMapper.map(projectDto,ProjectEntity.class);
		ProjectEntity saveproject=this.projectRepository.save(projectEntity);
		return this.modelMapper.map(saveproject,ProjectDto.class);
	
	}

	@Override
	public List<ProjectDto> getAllProject() {
		List<ProjectEntity> projectlist=this.projectRepository.findAll();
		List<ProjectDto> projectDtolist=projectlist.stream().map((project)->
		this.modelMapper.map(project,ProjectDto.class)).collect(Collectors.toList()); 
		return projectDtolist;
	
	}

	@Override
	public ProjectDto getProjectById(int projectId) {
		ProjectEntity projectEntity=this.projectRepository.findById(projectId).orElseThrow(()->
		new ResourceNotFoundException("Project", "project id", projectId));
		return this.modelMapper.map(projectEntity, ProjectDto.class);
		
	}

	@Override
	public void deleteProjectById(int projectId) {
		this.projectRepository.findById(projectId).orElseThrow(()->
		new ResourceNotFoundException("Project", "project id", projectId));
		this.projectRepository.deleteById(projectId);
		
	}

	@Override
	public ProjectDto updateProject(ProjectDto projectDto, int projectId) {
		ProjectEntity projectEntity=this.projectRepository.findById(projectId).orElseThrow(()->
		new ResourceNotFoundException("Project", "project id", projectId));
		
		projectDto.setProjectId(projectId);
		ProjectEntity updateproject=this.modelMapper.map(projectDto, ProjectEntity.class);
		ProjectEntity entity= this.projectRepository.save(updateproject);
		return this.modelMapper.map(entity, ProjectDto.class);
		
	}

	@Override
	public List<ProjectDto> getProjectByCourse(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
