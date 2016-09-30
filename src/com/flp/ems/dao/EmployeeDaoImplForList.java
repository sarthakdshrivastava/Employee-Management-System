package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

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
	public void modifyEmployee(Employee employee) {
		Employee found=null;
		long id=employee.getId();
		for(Employee e:employeeList){
			if(e.getId()==id){
				found=e;
			}
		}
		employeeList.remove(found);
		employeeList.add(employee);
	}
	
	@Override
	public boolean removeEmployee(long id) {
		Employee e=searchEmployeeById(id);
		if(e==null){		
			return false;
		}
		else{
			employeeList.remove(e);
			return true;
		}
	}
	
	@Override
	public List<Employee> searchEmployee(Map<String,String> map) {
		List<Employee> foundEmployees=new ArrayList<Employee>();
		Set<Entry<String,String>> entrySet=map.entrySet();
		TreeSet treeSet;

		for(Employee employee:employeeList){
			boolean found=true;
			for(Entry entry:entrySet){
				String key=(String) entry.getKey();
				String value=(String) entry.getValue();
				switch(key){
					case "name":
						if(value.equals("")){
							break;
						}
						else{
							if(!value.equals(employee.getName()))
								found=false;
						}
						break;
					case "id":
						if(value.equals("")){
							break;
						}
						else{
							if(!value.equals(employee.getId()+""))
								found=false;
						}
						break;
					case "emailId":
						if(value.equals("")){
							break;
						}
						else{
							if(!value.equals(employee.getEmailId()))
								found=false;
						}
						break;
				}
			}
			if(found)
				foundEmployees.add(employee);
		}
		return foundEmployees;
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeList;
	}
	private Employee searchEmployeeById(long id) {
		Employee employee=null;
		for(Employee emp:employeeList){
			if((emp.getId())==id)
				employee=emp;
		}
		return employee;
	}
}
