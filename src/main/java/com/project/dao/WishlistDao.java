package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.connection.DBConnection;
import com.project.model.Wishlist;

public class WishlistDao {
	
	public static void insertIntoWishlist(Wishlist w) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into wishlist(product_id,customer_id) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, w.getProductId());
			pst.setInt(2, w.getCustomerId());
			pst.executeUpdate();
			System.out.println("wishlist updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Wishlist> getWishListByCudId(int cid) {
		List<Wishlist> list = new ArrayList<Wishlist>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from wishlist where customer_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Wishlist w = new Wishlist();
				w.setId(rs.getInt("id"));
				w.setCustomerId(rs.getInt("customer_id"));
				w.setProductId(rs.getInt("product_id"));
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void deleteFromWishlist(int cid, int pid) {
		try {
			Connection conn = DBConnection.createConnection();
			String query = "delete from wishlist where customer_id = ? and product_id = ?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, cid);
			psmt.setInt(2, pid);
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
