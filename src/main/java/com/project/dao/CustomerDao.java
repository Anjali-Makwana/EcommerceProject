package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.connection.DBConnection;
import com.project.model.Customer;

public class CustomerDao {
	
	public static void customerRegister(Customer customer) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into customer(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, customer.getName());
			pst.setLong(2, customer.getContact());
			pst.setString(3, customer.getAddress());
			pst.setString(4, customer.getEmail());
			pst.setString(5, customer.getPassword());
			pst.executeUpdate();
			System.out.println("customer registered.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Customer customerLogin(Customer c) {
		Customer customer = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from customer where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getEmail());
			pst.setString(2, c.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setContact(rs.getLong("contact"));
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	public static void udpateCustomerProfile(Customer c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update customer set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setLong(2, c.getContact());
			pst.setString(3, c.getAddress());
			pst.setString(4, c.getEmail());
			pst.setInt(5, c.getId());
			pst.executeUpdate();
			System.out.println("customer data udpated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkOldPassword(String op) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from customer where password=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, op);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void customerUpdatePassword(String np,int id) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update customer set password=? where id=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("customer password updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from customer where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}