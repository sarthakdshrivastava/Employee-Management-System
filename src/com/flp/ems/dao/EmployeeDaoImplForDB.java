package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForDB implements IEmployeeDao {
	Properties props;
	public EmployeeDaoImplForDB(){
		props=new Properties();
		FileInputStream fileInputStream=null;
		try {
			fileInputStream=new FileInputStream("dbDetails.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			props.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private Connection createConnection(){
		String url=props.getProperty("jdbc.url");
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	@Override
	public void addEmployee(Employee employee) {
		Connection connection=createConnection();
		String insertQuery=props.getProperty("jdbc.query.insert");
		try(PreparedStatement insertStatement=connection.prepareStatement(insertQuery,PreparedStatement.RETURN_GENERATED_KEYS)){
			insertStatement.setString(1, employee.getName());
			insertStatement.setString(2, "dummy");
			insertStatement.setLong(3, employee.getPhoneNumber());
			insertStatement.setDate(4, new java.sql.Date(employee.getDateOfBirth().getTime()));
			insertStatement.setDate(5, new java.sql.Date(employee.getDateOfJoining().getTime()));
			insertStatement.setString(6, employee.getAddress());
			insertStatement.setInt(7,employee.getDepartmentId());
			insertStatement.setInt(8, employee.getProjectId());
			insertStatement.setInt(9, employee.getRoleId());
			insertStatement.execute();
			ResultSet rs=insertStatement.getGeneratedKeys();
			rs.next();
			employee.setId(rs.getLong(1));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String addEmailQuery=props.getProperty("jdbc.query.addEmail");
		try(PreparedStatement addEmailStatement=connection.prepareStatement(addEmailQuery)){
			addEmailStatement.setString(1, employee.getName()+employee.getId()+"@barclaycard.co.uk");
			addEmailStatement.setString(2, "dummy");
			addEmailStatement.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

	@Override
	public void modifyEmployee(Employee employee) {
		Connection connection=createConnection();
		String modifyQuery=props.getProperty("jdbc.query.update");
		try(PreparedStatement modifyStatement=connection.prepareStatement(modifyQuery)){
			modifyStatement.setString(1, employee.getName());
			modifyStatement.setString(2, employee.getEmailId());
			modifyStatement.setLong(3, employee.getPhoneNumber());
			modifyStatement.setDate(4, new java.sql.Date(employee.getDateOfBirth().getTime()));
			modifyStatement.setDate(5, new java.sql.Date(employee.getDateOfJoining().getTime()));
			modifyStatement.setString(6, employee.getAddress());
			modifyStatement.setInt(7,employee.getDepartmentId());
			modifyStatement.setInt(8, employee.getProjectId());
			modifyStatement.setInt(9, employee.getRoleId());
			modifyStatement.setInt(10, (int) employee.getId());
			modifyStatement.executeUpdate();
		}
		catch(Exception e){
			
		}
	}

	@Override
	public boolean removeEmployee(long id) {
		Connection connection=createConnection();
		String removeQuery=props.getProperty("jdbc.query.remove");
		int affected=0;
		try(PreparedStatement removeStatement=connection.prepareStatement(removeQuery)){
			removeStatement.setInt(1,(int) id);
			affected=removeStatement.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(affected==0)
			return false;
		else
			return true;
	}

	@Override
	public List<Employee> searchEmployee(Map<String, String> map) {
		List<Employee> result=new ArrayList<Employee>();
		String searchQuery=generateSearchQuery(map);
		Connection connection=createConnection();
		try(Statement searchStatement=connection.createStatement()){
			ResultSet rs=searchStatement.executeQuery(searchQuery);
			while(rs.next()){
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmailId(rs.getString(3));
				e.setPhoneNumber(rs.getLong(4));
				e.setDateOfBirth(rs.getDate(5));
				e.setDateOfJoining(rs.getDate(6));
				e.setAddress(rs.getString(7));
				e.setDepartmentId(rs.getInt(8));
				e.setProjectId(rs.getInt(9));
				e.setRoleId(rs.getInt(10));
				result.add(e);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> result=new ArrayList<Employee>();
		String searchQuery=props.getProperty("jdbc.query.searchAll");
		Connection connection=createConnection();
		try(Statement searchStatement=connection.createStatement()){
			ResultSet rs=searchStatement.executeQuery(searchQuery);
			while(rs.next()){
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmailId(rs.getString(3));
				e.setPhoneNumber(rs.getLong(4));
				e.setDateOfBirth(rs.getDate(5));
				e.setDateOfJoining(rs.getDate(6));
				e.setAddress(rs.getString(7));
				e.setDepartmentId(rs.getInt(8));
				e.setProjectId(rs.getInt(9));
				e.setRoleId(rs.getInt(10));
				result.add(e);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	private String generateSearchQuery(Map<String,String> map){
		String searchQuery=props.getProperty("jdbc.query.search");
		Set<Entry<String, String>> entrySet=map.entrySet();
		for(Entry entry:entrySet){
			String key=(String) entry.getKey();
			String value=(String) entry.getValue();
			switch(key){
				case "name":
					if(value.equals("")){
						break;
					}
					else{
						searchQuery+=" name='"+value+"' and";
					}
					break;
				case "id":
					if(value.equals("")){
						break;
					}
					else{
						searchQuery+=" employee_id="+value+" and";
					}
					break;
				case "emailId":
					if(value.equals("")){
						break;
					}
					else{
						searchQuery+=" email_id='"+value+"' and";
					}
					break;
			}
		}
		
		searchQuery=searchQuery.substring(0,searchQuery.length()-3);
		return searchQuery;
	}

}
