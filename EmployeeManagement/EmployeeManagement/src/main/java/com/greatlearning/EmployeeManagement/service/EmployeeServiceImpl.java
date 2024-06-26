package com.greatlearning.EmployeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.entity.Employee;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepo;
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeRepo.findById(id).get();
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepo.deleteById(id);
		
	}

}
