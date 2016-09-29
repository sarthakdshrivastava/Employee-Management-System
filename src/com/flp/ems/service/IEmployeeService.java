package com.flp.ems.service;

import java.util.HashMap;

public interface IEmployeeService {
	public void addEmployee(HashMap<String,String> map);
	public String searchEmployee(String id);
	public void removeEmployee(String id);
	public void modifyEmployee(String id,HashMap<String,String> map);
	public String getAllEmployee();
}
