package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.WishlistDao;
import com.project.model.Wishlist;

@WebServlet("/WishListController")
public class WishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public WishListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		if(action.equalsIgnoreCase("addToWishList")) {
			
			Wishlist w = new Wishlist();
			w.setProductId(pid);
			w.setCustomerId(cid);
			WishlistDao.insertIntoWishlist(w);
			System.out.println("product wishlisted");
			response.sendRedirect("c-home.jsp");
			
		} else if (action.equals("remove_wishlist")) {
			WishlistDao.deleteFromWishlist(cid, pid);
			System.out.println("product removed from wishlist");
			response.sendRedirect("c-home.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
