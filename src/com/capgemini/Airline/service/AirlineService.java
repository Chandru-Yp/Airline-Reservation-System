package com.capgemini.Airline.service;

import java.util.Scanner;

import com.capgemini.Airline.bean.CustomerBean;
import com.capgemini.Airline.bean.SeatBooking;
import com.capgemini.Airline.dao.CustomerBookingDAO;

public class AirlineService  implements IAirlineService{

	@Override
	public int addCustomerDetails(CustomerBean bean) {
		
		Scanner sc1=new Scanner(System.in);
		CustomerBean c1= new CustomerBean();
		CustomerBookingDAO dao= new CustomerBookingDAO();
		System.out.println("Welcome to Flight Booking");
		System.out.println("Please enter yout details");
		System.out.println("Enter your name");
		c1.setCust_name(sc1.next());
		System.out.println("Enter your email");
		c1.setCust_email(sc1.next());
		System.out.println("Enter your Address");
		c1.setCust_addr(sc1.next());
		System.out.println("Enter your Phone");
		c1.setCust_no(sc1.nextInt());
		System.out.println("Enter your seat no ");
		c1.setSeat_no(sc1.nextInt());
		System.out.println("Enter your room type");
		c1.setSeat_type(sc1.next());
		
		int count=dao.addCustomerDeatils(c1);
		
		if(count==1)
		{
			System.out.println("Seat booked...");
			System.out.println("Seat details are...");
			System.out.println("Customer ID is " + c1.getCust_id());
			System.out.println("Customer name is " + c1.getCust_name());
			System.out.println("Customer email is " + c1.getCust_email());
			System.out.println("Customer address is " + c1.getCust_addr());
			System.out.println("Customer mobile no  is " + c1.getCust_no());
			System.out.println("Customer ID is " + c1.getSeat_no());
			System.out.println("Customer ID is " + c1.getSeat_type());
			
			return 1;
		}
		
		return 0;
	}

	@Override
	public SeatBooking getBookingDeatils(int CustomerID) {
		
		CustomerBookingDAO dao= new CustomerBookingDAO();
		SeatBooking sb= dao.getBookingDetails(CustomerID);
		if(sb!=null)
		{
			sb.setStatus("booked");
			return sb;
		}
		else
		{
		return null;
		}
	}

}
