package com.java.emailapp;

import java.util.*;
import java.io.*;

public class Email {

	public Scanner sc = new Scanner(System.in);
	public Random ra = new Random();

//	Declaring the variables 
	private String first_name;
	private String last_name;
	private String department;
	private String email;
	private String password;
	private int mail_capacity = 500;
	private String alternate_email;
	
//	Getting first name and last name using constructor
	public Email(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
		System.out.println("NEW EMPLOYEE: " + this.first_name + " " + this.last_name);
		 System.out.println("=========================================================================================");
//		getting selected department
		this.department = this.setDept();
		
//		call a method that returns a random password
		this.password = this.randomPassword(8);
		
//		assigning generated email
		this.email = this.generateEmail();
	}
	
//	Method to generate the email address from first and last name
	private String generateEmail() {
		return this.first_name.toLowerCase()+this.last_name.toLowerCase()+ra.nextInt()+this.department.toLowerCase()+"@company.com";
	}
	
//	method to select the department
	private String setDept() {
		System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Production \n3 for Desingning\n"
				+ "4 for Testing\n5 for Human Resource\n6 for Customer Service\n7 for Development");
		 System.out.println("=========================================================================================");
		boolean flag = false;
		do {
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			System.out.println("=========================================================================================");
			switch(choice) {
			case 1: 
				return "Sales";
			case 2: 
				return "Production";
			case 3: 
				return "Designing";
			case 4: 
				return "Testing";
			case 5: 
				return "Human Resource";
			case 6: 
				return "Customer Service";
			case 7:
				return "Development";
			default: System.out.println("Invalid choice");;
			}
			
		}while(!flag);
		return null;
		
	}
	
//	method to generate random password
	private String randomPassword(int length) {
		String capital_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String small_letters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String special_char = "!@#$%^&*";
		String values = capital_letters+small_letters+numbers+special_char;
		
		String password = "";
		for(int i=0;i<length;i++) {
			password = password+values.charAt(ra.nextInt(values.length()));
		}
		return password;
	}
	
//	method to change password
	public void setPassword() {
		boolean flag = false;
		String new_password;
		do {
			System.out.println("Are you sure you want to change password?\n1.Y\n2.N");
			char choice = sc.next().charAt(0);
			if(choice=='Y' || choice == 'y') {
				flag = true;
				System.out.print("Enter the password: ");
				new_password = sc.next();
				if(new_password.equals(password)) {
					System.out.println("Password same as previous is not allowed");
				}else {
					System.out.print("Re-enter password: ");
					password = sc.next();
					if(new_password.equals(password)) {
						System.out.println("Password changed successfully");
						 System.out.println("=========================================================================================");
					}else {
						System.out.println("Password doesn't match.");
					}
				}
			}else {
				if(choice == 'N' || choice == 'n') {
					flag = false;
					System.out.println("Chnaging Password is cancelled");
					 System.out.println("=========================================================================================");
				}else {
					System.out.println("Please enter the valid choice");
				}
			}
		}while(!flag);
	}
	
//	Set the mailbox capacity
    public void set_mailCap() {
        System.out.println("Current capacity = " + this.mail_capacity + "mb");
        System.out.print("Enter new capacity: ");
        this.mail_capacity = sc.nextInt();
        System.out.println("MAILBOX CAPACITY CHANGED SUCCESSFULLY!");
        System.out.println("=========================================================================================");
    }

//    Set the alternate email
    public void alternate_email() {
        System.out.print("Enter new alternate email: ");
        this.alternate_email = sc.next();
        System.out.println("ALTERNATE EMAIL SET SUCCESSFULLY!");
        System.out.println("=========================================================================================");
    }
    
//	method to store the data in file
	public void storefile() {
		try {
			FileWriter fw = new FileWriter("C:\\Users\\Sahil Simran\\eclipse-workspace\\EmailApplication\\Employee.txt");
			fw.write("\nFirst name: "+this.first_name);
			fw.append("\nLast name: "+this.last_name);
			fw.append("\nEmail ID: "+this.email);
			fw.append("\nPassword: "+this.password);
			fw.append("\nDepartment: "+this.department);
			fw.append("\nAlternate Email ID: "+this.alternate_email);
			fw.append("\nEmail Capacity: "+this.mail_capacity);
			fw.close();
			System.out.println("****Data Stored****");
			 System.out.println("=========================================================================================");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public void read_file() {
        try {
            FileReader f1 = new
                    FileReader("C:\\Users\\Sahil Simran\\eclipse-workspace\\EmailApplication\\Employee.txt");
            int i;
            while ((i = f1.read()) != -1) {
                System.out.print((char) i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();

    }

	public void getInfo() {
	        System.out.println("NAME: " + this.first_name + " " + this.last_name);
	        System.out.println("DEPARTMENT: " + this.department);
	        System.out.println("EMAIL: " + this.email);
	        System.out.println("PASSWORD: " + this.password);
	        System.out.println("MAILBOX CAPACITY: " + this.mail_capacity + "mb");
	        System.out.println("ALTERNATE EMAIL: " + this.alternate_email);
	}
}
