package com.capgemini.Airline.service;

import com.capgemini.Airline.bean.CustomerBean;
import com.capgemini.Airline.bean.SeatBooking;

public interface IAirlineService {
	
	int addCustomerDetails(CustomerBean bean);
	SeatBooking getBookingDeatils(int CustomerID);

}
