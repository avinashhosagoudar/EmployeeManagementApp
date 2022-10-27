package com.employee.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.DepartmentEntity;
import com.employee.entity.EmployeeEntity;
import com.employee.exception.ResourceNotFoundException;
import com.employee.payload.DepartmentDto;
import com.employee.payload.EmployeeDto;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
@Service
public class EmployeeServiceImplementation implements EmployeeService
{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity=this.modelMapper.map(employeeDto,EmployeeEntity.class);
		EmployeeEntity saveEmployee=this.employeeRepository.save(employeeEntity);
		return this.modelMapper.map(saveEmployee,EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<EmployeeEntity> employeelist=this.employeeRepository.findAll();
		List<EmployeeDto> employeeDtolist=employeelist.stream().map((employee)->
		this.modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList()); 
		return employeeDtolist;
	}

	@Override
	public EmployeeDto getEmployeeById(int employeeId) {
		EmployeeEntity employeeEntity=this.employeeRepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("Employee", "employee id", employeeId));
		return this.modelMapper.map(employeeEntity, EmployeeDto.class);
		
		
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		this.employeeRepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("Employee", "employee id", employeeId));
		this.employeeRepository.deleteById(employeeId);
		
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, int employeeId) {
		EmployeeEntity employeeobj=this.employeeRepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("Employee", "employee id", employeeId));
		
		
		employeeDto.setEmployeeId(employeeId);
		EmployeeEntity updateemployee=this.modelMapper.map(employeeDto, EmployeeEntity.class);
		EmployeeEntity entity= this.employeeRepository.save(updateemployee);
		return this.modelMapper.map(entity, EmployeeDto.class);
		
	}

	@Override
	public List<EmployeeDto> getEmployeeByProject(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
