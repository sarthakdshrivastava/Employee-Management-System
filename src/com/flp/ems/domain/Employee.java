package com.flp.ems.domain;

import java.util.Date;

public class Employee implements Cloneable {
	private static long uid;
	private long id;
	private String emailId;
	private String name;
	private long phoneNumber;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private String address;
	private int departmentId;
	private int projectId;
	private int roleId;
	static{
		uid=1;
	}
	public Employee(){
	}
	public Employee(String name,long phoneNumber,Date dateOfBirth,Date dateOfJoining,String address,int departmentId,int roleId,int projectId){
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.dateOfBirth=dateOfBirth;
		this.dateOfJoining=dateOfJoining;
		this.address=address;
		this.departmentId=departmentId;
		this.roleId=roleId;
		this.projectId=projectId;
		this.id=uid;
		uid++;
		this.emailId=name+this.id+"@barclaycard.co.uk";
	}
	@Override
	public String toString(){
		return "Id: "+id+"\nName: "+name+"\nEmail id: "+emailId+"\nPhone Number: "+phoneNumber+"\nAddress: "+address+"\nDate of birth: "+dateOfBirth+"\nDate of Joining:"+dateOfJoining;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
