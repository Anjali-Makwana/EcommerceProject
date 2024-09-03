package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.CartDao;
import com.project.model.Wishlist;
 
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CartController() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		if(action.equalsIgnoreCase("addToCartlist")) {
			
			Wishlist w = new Wishlist();
			w.setProductId(pid);
			w.setCustomerId(cid);
			CartDao.insertIntoCartlist(w);
			System.out.println("product added in cart");
			response.sendRedirect("c-home.jsp");
			
		} else if (action.equals("removeFromCart")) {
			CartDao.deleteFromCartList(cid, pid);
			System.out.println("product removed from cart.");
			response.sendRedirect("c-home.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
