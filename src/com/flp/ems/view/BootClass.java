package com.flp.ems.view;

import java.util.Scanner;

public class BootClass {
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(true){
			menuSelection(reader);
			System.out.println("Perform any more operations? Press 1 for Yes\n 2 for No");
			int input=Integer.parseInt(reader.nextLine().trim());
			if(input!=1)
				break;
		}
	}
	public static void menuSelection(Scanner reader){
		UserInteraction requestHandler=new UserInteraction(reader);
		System.out.println("Choose from the following operations");
		System.out.println("1.Add\n2.Modify\n3.Remove\n4.Search\n5.Display All\n");
		int input=Integer.parseInt(reader.nextLine().trim());
		switch(input){
			case 1:
				requestHandler.addEmployee();
				break;
			case 2:
				requestHandler.modifyEmployee();
				break;
			case 3:
				requestHandler.removeEmployee();
				break;
			case 4:
				requestHandler.searchEmployee();
				break;
			case 5:
				requestHandler.getAllEmployee();
				break;
			default:
				System.out.println("Invalid input!");
			
		}
	}
}
