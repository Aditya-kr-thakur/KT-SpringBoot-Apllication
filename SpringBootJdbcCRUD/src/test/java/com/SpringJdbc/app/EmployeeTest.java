package com.SpringJdbc.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.SpringJdbc.app.controller.EmployeeController;
import com.SpringJdbc.app.dao.EmployeeDAO;
import com.SpringJdbc.app.exception.EmployeeListNotFoundException;
import com.SpringJdbc.app.exception.EmployeeNotFoundException;
import com.SpringJdbc.app.model.Employee;
import com.SpringJdbc.app.service.EmployeeService;
import com.SpringJdbc.app.service.EmployeeServiceImplementation;

@SpringBootTest
public class EmployeeTest {
	
	@Mock
	private EmployeeDAO empDao;

	@InjectMocks
	private EmployeeServiceImplementation empService;
	
	@Test
	public void testFindAll() {
		
		ArrayList<Employee> empList=new ArrayList<Employee>();
		when(empDao.findAll()).thenReturn(empList);
		assertThrows(EmployeeListNotFoundException.class,()->empService.getAllEmployees());
	}
	
	@Test
	public void testFindAll1() throws EmployeeListNotFoundException {
		ArrayList<Employee> empList=new ArrayList<Employee>();
		empList.add(new Employee(1,"jhgj","hfuj","jgig"));
		when(empDao.findAll()).thenReturn(empList);
		assertEquals(empList,empService.getAllEmployees());
	}
	
	@Test
	public void findById() {
		Employee emp=new Employee(1,"hfjy","tfru","yurfu");
		when(empDao.findById(0)).thenReturn(emp);
		assertThrows(EmployeeNotFoundException.class,()->empService.getEmployee(2));
	}
	
	@Test
	public void findById2() throws EmployeeNotFoundException {
		Employee emp=new Employee(1,"hfjy","tfru","yurfu");
		when(empDao.findById(1)).thenReturn(emp);
		assertEquals(emp,empService.getEmployee(1));
	}
}
