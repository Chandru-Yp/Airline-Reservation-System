package com.capgemini.Airline.bean;

public class CustomerBean {
	
	private int cust_id;
	private String cust_name;
	private String cust_email;
	private String cust_addr;
	private int cust_no;
	private String seat_type;
	private int seat_no;
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public String getCust_addr() {
		return cust_addr;
	}
	public void setCust_addr(String cust_addr) {
		this.cust_addr = cust_addr;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public String getSeat_type() {
		return seat_type;
	}
	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	
	
	
	@Override
	public String toString() {
		return "CustomerBean [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_email=" + cust_email
				+ ", cust_addr=" + cust_addr + ", cust_no=" + cust_no + ", seat_type=" + seat_type + ", seat_no="
				+ seat_no + "]";
	}
	
	
	
	
	

}
