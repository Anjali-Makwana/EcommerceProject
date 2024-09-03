package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.AdminDao;
import com.project.model.Admin;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("action");

		if (login.trim().equals("adminLogin")) {
			try {
				String email = request.getParameter("email");
				String password = request.getParameter("password");

				Admin admin = AdminDao.getAdminByEmailPassword(email, password);

				HttpSession session = request.getSession();
				if (admin != null) {
					session.setAttribute("activeAdmin", admin);
					response.sendRedirect("home.jsp");
				} else {
					session.setAttribute("message", "Invalid details.!");
					response.sendRedirect("login.jsp");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}