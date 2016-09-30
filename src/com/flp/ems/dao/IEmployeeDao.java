package com.flp.ems.dao;

import java.util.List;
import java.util.Map;

import com.flp.ems.domain.Employee;

public interface IEmployeeDao {
	public void addEmployee(Employee employee);
	public void modifyEmployee(Employee employee);
	public boolean removeEmployee(long id);
	public List<Employee> searchEmployee(Map<String,String> map);
	public List<Employee> getAllEmployee();
}
