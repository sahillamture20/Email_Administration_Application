package com.java.emailapp;
import java.util.*;

public class EmailApp {

    public static void main(String[] args) {
    	System.out.println("=========================================================================================");
    	System.out.println("                                  Email Administration System                             "); 
    	System.out.println("=========================================================================================");	 
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter First Name: ");
        String fname = sc.next();
        
        System.out.print("Enter Last Name: ");
        String lname = sc.next();
        System.out.println("=========================================================================================");
        // Creating a new employee (i.e. an object of the Email class)
        Email em1 = new Email(fname, lname);

        int choice = -1;
        do {
            System.out.print("1.Show Info\n2.Change Password"
                    + "\n3.Change Mailbox Capacity\n4.Set Alternate Email\n5.Store data in file\n6.Show file\n7.Exit\n");
            System.out.println("=========================================================================================");
            System.out.println("ENTER YOUR CHOICE: ");
            System.out.println("=========================================================================================");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.setPassword();
                    break;
                case 3:
                    em1.set_mailCap();
                    break;
                case 4:
                    em1.alternate_email();
                    break;
                case 5:
                    em1.storefile();
                    break;
                case 6:
                    em1.read_file();
                    break;
                case 7:
                    System.out.println("\nTHANKS!!!");
                    break;
                default:
                    System.out.println("INVALID CHOICE! ENTER AGAIN!");
            }

        }while(choice!=7);

    }

}