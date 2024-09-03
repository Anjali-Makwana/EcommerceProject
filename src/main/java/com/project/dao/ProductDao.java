package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.connection.DBConnection;
import com.project.model.Product;

public class ProductDao {
	public static void uploadProduct(Product p) {
		try {
			Connection con = DBConnection.createConnection();
			String sql = "insert into product(seller_id,product_name,product_price,product_category,product_image,product_description) "
					+ " values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, p.getSellerId());
			pst.setString(2, p.getProduct_name());
			pst.setDouble(3, p.getProductPrice());
			pst.setString(4, p.getProduct_category());
			pst.setString(5, p.getProduct_image());
			pst.setString(6,p.getProduct_description());
			pst.executeUpdate();
			System.out.println("product uploaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Product> getAllProductBySid(int sid){
		List<Product> list = new ArrayList<Product>();
		try {
			Connection con = DBConnection.createConnection();
			String sql = "select * from product where seller_id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setSellerId(rs.getInt("seller_id"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProductPrice(rs.getInt("product_price"));
				p.setProduct_category(rs.getString("product_category"));
				p.setProduct_image(rs.getString("product_image"));
				p.setProduct_description(rs.getString("product_description"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Product getProductByPid(int pid) {
		Product p = null;
		try {
			Connection con = DBConnection.createConnection();
			String sql = "select * from product where id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setSellerId(rs.getInt("seller_id"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProductPrice(rs.getInt("product_price"));
				p.setProduct_category(rs.getString("product_category"));
				p.setProduct_image(rs.getString("product_image"));
				p.setProduct_description(rs.getString("product_description"));
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public static void updateProduct(Product p) {
		try {
			Connection con = DBConnection.createConnection();
			String sql = "update product set product_name=?,product_price=?,product_category=?,product_image=?,product_description=? where id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, p.getSellerId());
			pst.setString(2, p.getProduct_name());
			pst.setDouble(3, p.getProductPrice());
			pst.setString(4, p.getProduct_category());
			pst.setString(5, p.getProduct_image());
			pst.setString(6,p.getProduct_description());
			pst.setInt(6, p.getId());
			pst.executeUpdate();
			System.out.println("product updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteProduct(int pid) {
		try {
			Connection con = DBConnection.createConnection();
			String sql = "delete from product where id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
			System.out.println("product deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Product> getAllProdcuts(){
		List<Product> list = new ArrayList<Product>();
		try {
			Connection con = DBConnection.createConnection();
			String sql = "select * from product";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setSellerId(rs.getInt("seller_id"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProductPrice(rs.getInt("product_price"));
				p.setProduct_category(rs.getString("product_category"));
				p.setProduct_image(rs.getString("product_image"));
				p.setProduct_description(rs.getString("product_description"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
