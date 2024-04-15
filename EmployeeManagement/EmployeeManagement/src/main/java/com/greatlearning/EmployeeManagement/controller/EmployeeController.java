package com.greatlearning.EmployeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.EmployeeManagement.entity.Employee;
import com.greatlearning.EmployeeManagement.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;
	
	@GetMapping("/employees")
	public String listOfEmployees(Model model)
	{
		List<Employee> empList = employeeService.getAllEmployees();
		model.addAttribute("employees", empList);
		return "employees";
		
	}
	
	@GetMapping("/employees/new")
	public String createEmployee (Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create-employee";
		
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployee(@PathVariable int id, Model model)
	{
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute(employee);
		return "edit-employee";
		
	}
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
		
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee newEmployee)
	{
		Employee employee = employeeService.getEmployeeById(id);
		employee.setFirstName(newEmployee.getFirstName());
		employee.setLastName(newEmployee.getLastName());
		employee.setEmail(newEmployee.getEmail());
		employeeService.updateEmployee(employee);
		return "redirect:/employees";
	}
	
	
}
