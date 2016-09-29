package com.flp.ems.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.dao.IEmployeeDao;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDao employeeDao;
	public EmployeeServiceImpl(){
		employeeDao=new EmployeeDaoImplForList();
	}
	@Override
	public String searchEmployee(String id) {
		return null;
	}

	@Override
	public void removeEmployee(String id) {
		
	}

	@Override
	public void modifyEmployee(String id, HashMap<String, String> map) {
		Employee emp=employeeDao.searchEmployee(Long.parseLong(id));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		Set<Entry<String,String>> entrySet=map.entrySet();
		for(Entry entry:entrySet){
			String value=(String)entry.getValue();
			if(value.equals(""))
				continue;
			String key=(String) entry.getKey();
			if(key.equals("name"))
				emp.setName(value);
			if(key.equals("phoneNumber"))
				emp.setPhoneNumber(Long.parseLong(value));
			if(key.equals("dateOfBirth")){
				Date d=null;
				try {
					d=simpleDateFormat.parse(value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				emp.setDateOfBirth(d);
			}
			if(key.equals("dateOfJoining")){
				Date d=null;
				try {
					d=simpleDateFormat.parse(value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				emp.setDateOfJoining(d);
			}
				emp.setName(value);
			if(key.equals("name"))
				emp.setName(value);
			
		}
	}

	@Override
	public String getAllEmployee() {
		List<Employee> employeeList=employeeDao.getAllEmployee();
		String outString="Total employees are "+employeeList.size()+"\n";
		for(Employee e:employeeList){
			outString=outString+e.toString()+"\n";
		}
		return outString;
	}

	@Override
	public void addEmployee(HashMap<String, String> map){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		String name=map.get("name");
		long phoneNumber=Long.parseLong(map.get("phoneNumber"));
		String dobString=map.get("dateOfBirth");
		Date dateOfBirth=null;
		try {
			dateOfBirth=simpleDateFormat.parse(dobString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dojString=map.get("dateOfJoining");
		Date dateOfJoining=null;
		try {
			dateOfJoining=simpleDateFormat.parse(dojString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String address=map.get("address");
		int departmentId=Integer.parseInt(map.get("departmentId"));
		int roleId=Integer.parseInt(map.get("roleId"));
		int projectId=Integer.parseInt(map.get("projectId"));
		Employee employee=new Employee(name,phoneNumber,dateOfBirth,dateOfJoining,address,departmentId,roleId,projectId);
		employeeDao.addEmployee(employee);
	}

}
//Employee(String name,long phoneNumber,Date dateOfBirth,Date dateOfJoining,String address,int departmentId,int roleId,int projectId)