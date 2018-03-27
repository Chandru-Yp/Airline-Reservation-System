package com.capgemini.Airline.dao;

import com.capgemini.Airline.bean.CustomerBean;
import com.capgemini.Airline.bean.SeatBooking;

public interface ICustomerBookingDAO {

	int addCustomerDeatils(CustomerBean bean);
	SeatBooking getBookingDetails(int CustomerId);
}
