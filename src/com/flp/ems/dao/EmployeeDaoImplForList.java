package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.List;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IEmployeeDao {
	private static List<Employee> employeeList;
	static{
		employeeList=new ArrayList<Employee>();
	}
	@Override
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	@Override
	public void modifyEmployee(long id, Employee employee) {
		Employee found=null;
		for(Employee e:employeeList){
			if(e.getId()==id){
				found=e;
			}
		}
		employeeList.remove(found);
		employeeList.add(employee);
	}
	@Override
	public void removeEmployee(long id) {
		
	}
	@Override
	public Employee searchEmployee(long id) {
		Employee employee=null;
		for(Employee emp:employeeList){
			if((emp.getId())==id)
				employee=emp;
		}
		return employee;
	}
	@Override
	public List<Employee> getAllEmployee() {
		return employeeList;
	}
}
