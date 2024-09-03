package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.connection.DBConnection;
import com.project.dao.ProductDao;
import com.project.model.Cart;
import com.project.model.Customer;
import com.project.model.Product;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        HttpSession session = request.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("c-cartlist.jsp?error=empty");
            return;
        }

        Customer customer = (Customer) session.getAttribute("customerData");
        
        double totalPrice = 0;

        try (Connection conn = DBConnection.createConnection()) {
            String sql = "INSERT INTO orders (user_id, product_id, quantity, total_price) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            for (Cart c : cart) {
            	
            	Product p = ProductDao.getProductByPid(c.getProductId());
            	  
                ps.setInt(1, customer.getId());
                ps.setInt(2, c.getProductId());
                ps.setInt(3, 1);
                ps.setDouble(4, p.getProductPrice());
                ps.addBatch();

               // totalPrice += item.getQuantity() * item.getPrice();
            }

            ps.executeBatch();

            //session.removeAttribute("cart");
            //response.sendRedirect("checkout-success.jsp?total=" + totalPrice);
        } catch (SQLException e) {
            throw new ServletException("Checkout failed", e);
        }
    }
}