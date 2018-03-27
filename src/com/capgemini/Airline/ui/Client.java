package com.capgemini.Airline.ui;

import java.util.Scanner;

import com.capgemini.Airline.bean.CustomerBean;
import com.capgemini.Airline.bean.SeatBooking;
import com.capgemini.Airline.service.AirlineService;


public class Client {
	
public static void main(String[] args) {
	
	Scanner sc1=new Scanner(System.in);
	AirlineService as= new AirlineService();
	CustomerBean c1=null;
	System.out.println("Welcome to Airline reservation System");
	System.out.println("Please enter your choice");
	System.out.println("Press 1 for booking a seat in flight");
	System.out.println("Press 2 to view booking status");
	System.out.println("Press 3 to exit ");
	int choice=sc1.nextInt();
	
	switch(choice)
	{
		case 1 : int count=as.addCustomerDetails(c1); 
					if(count==1)
					{
						System.out.println("Thank you for booking..have a safe journey");
					}
					else
					{
						System.out.println("Sorry seat cannot be booked for the given details");
					}
					break;
		case 2 : System.out.println("Enter customer id :");
				 int cid=sc1.nextInt();
				 SeatBooking sb=as.getBookingDeatils(cid);
				 if(sb!=null)
				 {
					 System.out.println("Display :");
					 System.out.println("Name of Customer :" + sb.getName() );
					 System.out.println("Booking Status :" + sb.getStatus());
					 System.out.println("Seat No :" + sb.getSeat_no());
					 System.out.println("Seat Type : " + sb.getSeat_type());
				 }
				 else
				 {
					 System.out.println("invalid customer id");
				 }
				 break;
				
		case 3 : System.out.println("thank you for using the application");
				 break;
	}
	
	}

}

