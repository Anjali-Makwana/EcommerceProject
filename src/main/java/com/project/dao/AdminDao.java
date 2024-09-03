package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.connection.DBConnection;
import com.project.model.Admin;

public class AdminDao {
	
	public static Admin getAdminByEmailPassword(String email, String password) {
		
		Admin admin = null;
		try {
			Connection conn = DBConnection.createConnection();
			String query = "select * from admin where email = ? and password = ?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, email);
			psmt.setString(2, password);

			ResultSet set = psmt.executeQuery();
			while (set.next()) {
				admin = new Admin();
				admin.setId(set.getInt("id"));
				admin.setName(set.getString("name"));
				admin.setEmail(set.getString("email"));
				admin.setPassword(set.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}