package com.SpringJdbc.app.dao;
import java.util.List;

import com.SpringJdbc.app.model.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public int deleteById(int id);
	
	public int save(Employee e);
	
	public int update(Employee e, int id);

}
