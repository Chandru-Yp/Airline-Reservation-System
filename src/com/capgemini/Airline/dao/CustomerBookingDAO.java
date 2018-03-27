package com.capgemini.Airline.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.capgemini.Airline.bean.CustomerBean;
import com.capgemini.Airline.bean.SeatBooking;


public class CustomerBookingDAO implements ICustomerBookingDAO {

	@Override
	public int addCustomerDeatils(CustomerBean bean) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		CustomerBean cb= bean;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?user=root&password=chandru");
			
			String qry="select * from seatdetail where seatno=?";
			
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1,cb.getSeat_no());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				
				if((cb.getSeat_no()==rs.getInt("seatno"))||(cb.getSeat_type().equals(rs.getString("seatype")))||(rs.getString("status").equals("not_booked")))
				{
										
					String qry1="update seatdetail set status=? where seatno=?";
					pstmt1=con.prepareStatement(qry1);
					pstmt1.setString(1,"booked");
					pstmt1.setInt(2,cb.getSeat_no());
					pstmt1.executeUpdate();
					
					Random r1= new Random();
					int custid=r1.nextInt(1000);
					cb.setCust_id(custid);
					
					
					String qry2="insert into customerdetails values(?,?,?,?,?,?,?)";
					pstmt2=con.prepareStatement(qry2);
					pstmt2.setInt(1,cb.getCust_id());
					pstmt2.setString(2,cb.getCust_name());
					pstmt2.setString(3,cb.getCust_email());
					pstmt2.setString(4,cb.getCust_addr());
					pstmt2.setInt(5,cb.getCust_no());
					pstmt2.setString(6,cb.getSeat_type());
					pstmt2.setInt(7,cb.getSeat_no());
					pstmt2.executeUpdate();
					
					return 1;
				}
			}			
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt1!=null)
			{
				try {
					pstmt1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt2!=null)
			{
				try {
					pstmt2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public SeatBooking getBookingDetails(int CustomerId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		//PreparedStatement pstmt1=null;
		//PreparedStatement pstmt2=null;
		CustomerBean cb= new CustomerBean();
		SeatBooking sb= new SeatBooking();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?user=root&password=chandru");
			
			String qry="select * from customerdetails where custid=?";
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1,CustomerId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				cb.setCust_id(rs.getInt("custid"));
				cb.setCust_name(rs.getString("custname"));
				cb.setCust_email(rs.getString("email"));
				cb.setCust_addr(rs.getString("custaddress"));
				cb.setCust_no(rs.getInt("mobileno"));
				cb.setSeat_type(rs.getString("seattype"));
				cb.setSeat_no(rs.getInt("seatno"));
				
				sb.setName(rs.getString("custname"));
				sb.setSeat_no(rs.getInt("seatno"));
				sb.setSeat_type(rs.getString("seattype"));
				
				return sb;
			}			
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		
		return null;
	}

}
