package com.flp.ems.comparator;

import java.util.Comparator;

import com.flp.ems.domain.Employee;

public class CompareById implements Comparator<Employee>{
	private long id;
	public CompareById(long id){
		this.id=id;
	}
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		//System.out.println(o1.getName()+" "+o2.getName());
		if(o1.getId()==id)
			return 1;
		else
			return 0;
	}

}
