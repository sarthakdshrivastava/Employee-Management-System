package com.flp.ems.service;

import java.util.HashMap;
import java.util.Map;

public interface IEmployeeService {
	public void addEmployee(Map<String,String> map);
	public String searchEmployee(Map<String,String> map);
	public boolean removeEmployee(String id);
	public boolean modifyEmployee(String id,HashMap<String,String> map);
	public String getAllEmployee();
}
