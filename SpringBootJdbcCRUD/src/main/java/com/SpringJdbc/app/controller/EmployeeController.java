package com.SpringJdbc.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJdbc.app.dao.EmployeeDAO;
import com.SpringJdbc.app.exception.EmployeeListNotFoundException;
import com.SpringJdbc.app.exception.EmployeeNotFoundException;
import com.SpringJdbc.app.model.Employee;
import com.SpringJdbc.app.service.EmployeeService;

//Changes commit
@RestController("/api/v1/")
public class EmployeeController {
	
	@Autowired 
	private EmployeeService eService;
	
	@GetMapping("/employees")
	public List<Employee> findAll() throws EmployeeListNotFoundException {
		return eService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) throws EmployeeNotFoundException {
		return eService.getEmployee(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteById(@PathVariable int id) {
		return eService.deleteEmployee(id)+" Employee(s) delete from the database";
	}
	
	@PostMapping("/employees")
	public String save(@RequestBody Employee e) {
		return eService.addEmployee(e)+" Employee(s) saved successfully";
	}
	
	@PutMapping("/employees/{id}")
	public String update(@RequestBody Employee e, @PathVariable int id) {
		return eService.updateEmployee(e, id)+" Employee(s) updated successfully";
	}
	
}
