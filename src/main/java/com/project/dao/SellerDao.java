package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.connection.DBConnection;
import com.project.model.Seller;

public class SellerDao {
	
	public static void sellerRegister(Seller s) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql ="insert into seller(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3, s.getAddres());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getPass()); 
			pst.executeUpdate();
			System.out.println("seller registered.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from seller where email=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static Seller sellerLogin(Seller s) {
		Seller s1 = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from seller where email=? and password=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPass());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				s1 = new Seller();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setContact(rs.getLong("contact"));
				s1.setAddres(rs.getString("address"));
				s1.setEmail(rs.getString("email"));
				s1.setPass(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	public static void udpateSellerProfile(Seller s) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update seller set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3, s.getAddres());
			pst.setString(4, s.getEmail());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			System.out.println("seller data udpated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkOldPassword(String op) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from seller where password=?";
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
	public static void sellerUpdatePassword(String np,int id) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update seller set password=? where id=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("pass updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void sellerNewPassword(String np,String email) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update seller set password=? where email=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("pass updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}