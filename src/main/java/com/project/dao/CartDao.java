package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.connection.DBConnection;
import com.project.model.Cart;
import com.project.model.Wishlist;

public class CartDao {
	
	public static void insertIntoCartlist(Wishlist w) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into cart(product_id,customer_id) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, w.getProductId());
			pst.setInt(2, w.getCustomerId());
			pst.executeUpdate();
			System.out.println("cart updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Cart> getCartListByCusId(int cid) {
		List<Cart> list = new ArrayList<Cart>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from cart where customer_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Cart c = new Cart();
				c.setId(rs.getInt("id"));
				c.setCustomerId(rs.getInt("customer_id"));
				c.setProductId(rs.getInt("product_id"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void deleteFromCartList(int cid, int pid) {
		try {
			Connection conn = DBConnection.createConnection();
			String query = "delete from cart where customer_id = ? and product_id = ?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, cid);
			psmt.setInt(2, pid);
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
