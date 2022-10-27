package com.employee.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.DepartmentEntity;
import com.employee.exception.ResourceNotFoundException;
import com.employee.payload.DepartmentDto;
import com.employee.repository.DepartmentRepository;
import com.employee.service.DepartmentService;




@Service
public class DepartmentServiceImplementation implements DepartmentService
{
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto addDepartment(DepartmentDto departmentDto) 
	{
		
		DepartmentEntity departmentEntity=this.modelMapper.map(departmentDto, DepartmentEntity.class);
		DepartmentEntity savedepartment=this.departmentRepository.save(departmentEntity);
		return this.modelMapper.map(savedepartment, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {
		List<DepartmentEntity> departmentlist=this.departmentRepository.findAll();
		List<DepartmentDto> departmentDtolist=departmentlist.stream().map((student)->
		this.modelMapper.map(student,DepartmentDto.class)).collect(Collectors.toList()); 
		return departmentDtolist;
	}

	@Override
	public DepartmentDto getDepartmentById(int departmentId) {
		DepartmentEntity departmentEntity=this.departmentRepository.findById(departmentId).orElseThrow(()->
		new ResourceNotFoundException("department", "department id", departmentId));
		return this.modelMapper.map(departmentEntity, DepartmentDto.class);
		
	}

	@Override
	public void deleteDepartmentById(int departmentId) {
		this.departmentRepository.findById(departmentId).orElseThrow(()->
		new ResourceNotFoundException("department", "department id", departmentId));
		this.departmentRepository.deleteById(departmentId);
		
	}

	@Override
	public DepartmentDto updateDepartment(DepartmentDto departmentDto, int departmentId) {
		DepartmentEntity departmentobj=this.departmentRepository.findById(departmentId).orElseThrow(()->
		new ResourceNotFoundException("Department", "department id", departmentId));
		
		
		departmentDto.setDepartmentId(departmentId);
		DepartmentEntity updatedepartment=this.modelMapper.map(departmentDto, DepartmentEntity.class);
		DepartmentEntity entity= this.departmentRepository.save(updatedepartment);
		return this.modelMapper.map(entity, DepartmentDto.class);
		
	}

	@Override
	public List<DepartmentDto> getDepartmentByEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
