package com.capgemini.Airline.bean;

public class SeatBooking {
	
	private int seat_no;
	private String seat_type;
	private String status;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public String getSeat_type() {
		return seat_type;
	}
	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "SeatBooking [seat_no=" + seat_no + ", seat_type=" + seat_type + ", status=" + status + "]";
	}
	
	
	

}
