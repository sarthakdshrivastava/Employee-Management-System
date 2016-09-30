package com.flp.ems.comparator;

import java.util.Comparator;

import com.flp.ems.domain.Employee;

public class CompareByEmailId implements Comparator<Employee> {
	private String emailId;
	public CompareByEmailId(String emailId){
		this.emailId=emailId;
	}
	@Override
	public int compare(Employee o1, Employee o2) {
//		System.out.println(o1.getName()+" "+o2.getName());
		if(o1.getEmailId().equals(emailId))
			return 1;
		else
			return 0;
	}
}
