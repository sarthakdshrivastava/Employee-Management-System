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
		boolean errorCode=employeeService.modifyEmployee(id, map);
		if(!errorCode)
			System.out.println("Employee not found");
		else
			System.out.println("Employee modified Successfully");
	}
	public void removeEmployee(){
		System.out.println("Enter the employee id to remove:");
		String input=reader.nextLine().trim();
		boolean code=employeeService.removeEmployee(input);
		if(code)
			System.out.println("Employee removed successfully");
		else
			System.out.println("Employee not found");
	}
	public void searchEmployee(){
		System.out.println("Enter value to search by the field.If you do not wish to search by the field, just press enter");
		System.out.println("Enter employee id to search:");
		String id=reader.nextLine().trim();
		System.out.println("Enter name to search" );
		String name=reader.nextLine().trim();
		System.out.println("Enter email id to search");
		String emailId=reader.nextLine().trim();
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("id", id);
		map.put("name", name);
		map.put("emailId", emailId);
		String result=employeeService.searchEmployee(map);
		System.out.println(result);
	}
	public void getAllEmployee(){
		System.out.println(employeeService.getAllEmployee());
	}
}
