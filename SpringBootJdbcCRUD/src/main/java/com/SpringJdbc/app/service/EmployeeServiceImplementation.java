package com.SpringJdbc.app.service;

import java.io.Console;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringJdbc.app.dao.EmployeeDAO;
import com.SpringJdbc.app.exception.EmployeeListNotFoundException;
import com.SpringJdbc.app.exception.EmployeeNotFoundException;
import com.SpringJdbc.app.model.Employee;

import ch.qos.logback.classic.Logger;
@Service
public class EmployeeServiceImplementation implements EmployeeService{
    @Autowired
	EmployeeDAO empDao;

	@Override
	public Employee getEmployee(int id) throws EmployeeNotFoundException {
		//List<Employee> empList=empDao.findAll();
		/*int count=0;
		for(Employee emp: empList) {
			if(emp.getId()==id) {
				count++;
			}
		}
		if(count==0) {
			throw new EmployeeNotFoundException("Employee Not Found!");
		}*/
		Employee emp=empDao.findById(id);
		if(emp==null) {
			throw new EmployeeNotFoundException("Employee Not Found!");
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeListNotFoundException {
		
		List<Employee> empList=empDao.findAll();
		if(empList.isEmpty()) {
			throw new EmployeeListNotFoundException("Employee List is Empty");
		}
		return empList;
	}

	@Override
	public int deleteEmployee(int id) {
		return empDao.deleteById(id);
	}

	@Override
	public int addEmployee(Employee e) {
		return empDao.save(e);
	}

	@Override
	public int updateEmployee(Employee e, int id) {
		// TODO Auto-generated method stub
		return empDao.update(e, id);
	}
	
	
}
