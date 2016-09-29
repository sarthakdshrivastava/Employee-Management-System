package com.flp.ems.dao;

import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeDao {
	public void addEmployee(Employee employee);
	public void modifyEmployee(long id,Employee employee);
	public void removeEmployee(long id);
	public Employee searchEmployee(long id);
	public List<Employee> getAllEmployee();
}
