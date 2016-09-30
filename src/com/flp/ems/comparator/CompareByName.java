package com.flp.ems.comparator;

import java.util.Comparator;

import com.flp.ems.domain.Employee;

public class CompareByName implements Comparator<Employee>{
	private String name;
	public CompareByName(String name){
		this.name=name;
	}
	@Override
	public int compare(Employee o1, Employee o2) {
		//System.out.println(o1.getName()+" "+o2.getName());
		if(o1.getName().equals(name))
			return 1;
		else
			return 0;
	}

}
