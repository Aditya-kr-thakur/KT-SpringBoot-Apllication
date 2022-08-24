package com.SpringJdbc.app.service;

import java.util.List;

import com.SpringJdbc.app.exception.EmployeeListNotFoundException;
import com.SpringJdbc.app.exception.EmployeeNotFoundException;
import com.SpringJdbc.app.model.Employee;

public interface EmployeeService {
	public Employee getEmployee(int id) throws EmployeeNotFoundException;
	public List<Employee> getAllEmployees() throws EmployeeListNotFoundException;
	public int deleteEmployee(int id);
	public int addEmployee(Employee e);
	public int updateEmployee(Employee e, int id);
}
