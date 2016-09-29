package com.flp.ems.view;

import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.service.IEmployeeService;

public class UserInteraction {
	private Scanner reader;
	IEmployeeService employeeService;
	UserInteraction(Scanner reader){
		this.reader = reader;
		employeeService=new EmployeeServiceImpl();
	}
	public void addEmployee(){
		String name;
		String phoneNumber;
		String dateOfBirth;
		String dateOfJoining;
		String address;
		String departmentId;
		String projectId;
		String roleId;
		
		System.out.println("Enter the name:");
		name=reader.nextLine().trim();
		System.out.println("Enter the phone number:");
		phoneNumber=reader.nextLine().trim();
		System.out.println("Enter the date of birth:");
		dateOfBirth=reader.nextLine().trim();
		System.out.println("Enter the date of joining:");
		dateOfJoining=reader.nextLine().trim();
		System.out.println("Enter the address:");
		address=reader.nextLine().trim();
		System.out.println("Enter the department id:");
		departmentId=reader.nextLine();
		System.out.println("Enter the project id:");
		projectId=reader.nextLine().trim();
		System.out.println("Enter the role id:");
		roleId=reader.nextLine().trim();
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("name",name);
		map.put("phoneNumber",phoneNumber);
		map.put("dateOfBirth",dateOfBirth);
		map.put("dateOfJoining", dateOfJoining);
		map.put("address",address);
		map.put("departmentId", departmentId);
		map.put("projectId",projectId);
		map.put("roleId",roleId);
		employeeService.addEmployee(map);
	}
	public void modifyEmployee(){
		String id;
		String name;
		String phoneNumber;
		String dateOfBirth;
		String dateOfJoining;
		String address;
		String departmentId;
		String projectId;
		String roleId;
		
		System.out.println("Enter the employee id to modify:");
		id=reader.nextLine();
		System.out.println("Enter value to modify the field. If you do not wish to modify the field,just press enter");
		
		System.out.println("Enter the name:");
		name=reader.nextLine().trim();
		System.out.println("Enter the phone number:");
		phoneNumber=reader.nextLine().trim();
		System.out.println("Enter the date of birth:");
		dateOfBirth=reader.nextLine().trim();
		System.out.println("Enter the date of joining:");
		dateOfJoining=reader.nextLine().trim();
		System.out.println("Enter the address:");
		address=reader.nextLine().trim();
		System.out.println("Enter the department id:");
		departmentId=reader.nextLine();
		System.out.println("Enter the project id:");
		projectId=reader.nextLine().trim();
		System.out.println("Enter the role id:");
		roleId=reader.nextLine().trim();
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("name",name);
		map.put("phoneNumber",phoneNumber);
		map.put("dateOfBirth",dateOfBirth);
		map.put("dateOfJoining", dateOfJoining);
		map.put("address",address);
		map.put("departmentId", departmentId);
		map.put("projectId",projectId);
		map.put("roleId",roleId);
		employeeService.modifyEmployee(id, map);
	}
	public void removeEmployee(){
		
	}
	public void searchEmployee(){
		
	}
	public void getAllEmployee(){
		System.out.println(employeeService.getAllEmployee());
	}
}
