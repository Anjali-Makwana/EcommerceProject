package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.CustomerDao;
import com.project.model.Customer;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("register")) {
			
			Customer customer = new Customer();
			customer.setName(request.getParameter("name"));
			customer.setContact(Long.parseLong(request.getParameter("contact")));
			customer.setAddress(request.getParameter("address"));
			customer.setEmail(request.getParameter("email"));
			customer.setPassword(request.getParameter("password"));
			String pass = request.getParameter("password");
			String cpass = request.getParameter("confirmPassword");
			
			if (pass.equals(cpass)) {
				CustomerDao.customerRegister(customer);
				response.sendRedirect("c-login.jsp");
			} else {
				request.setAttribute("msg", "Password and Confirm Password is not matched");
				request.getRequestDispatcher("c-regisration.jsp").forward(request, response);
			}
			
		} else if (action.equalsIgnoreCase("login")) {
			
			Customer customer = new Customer();
			customer.setEmail(request.getParameter("email"));
			customer.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			
			boolean flag = CustomerDao.checkEmail(email);
			if (flag == true) {
				Customer cust = CustomerDao.customerLogin(customer);
				if (cust == null) {
					request.setAttribute("msg", "password is incorrect");
					request.getRequestDispatcher("c-login.jsp").forward(request, response);
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("customerData", cust);
					request.getRequestDispatcher("c-home.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("msg", "Account doesn't exist");
				request.getRequestDispatcher("c-login.jsp").forward(request, response);
			}
		} else if(action.equalsIgnoreCase("update")) {
			
			Customer customer = new Customer();
			customer.setId(Integer.parseInt(request.getParameter("id")));
			customer.setName(request.getParameter("name"));
			customer.setContact(Long.parseLong(request.getParameter("contact")));
			customer.setAddress(request.getParameter("address"));
			customer.setEmail(request.getParameter("email"));
			CustomerDao.udpateCustomerProfile(customer);
			HttpSession session = request.getSession();
			session.setAttribute("customerData", customer);
			request.getRequestDispatcher("c-home.jsp").forward(request, response);
		} else if(action.equalsIgnoreCase("password_update")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			
			boolean flag = CustomerDao.checkOldPassword(op);
			if(flag == true) {
				
				if(np.equals(cnp)) {
					CustomerDao.customerUpdatePassword(np, id);
					response.sendRedirect("c-home.jsp");
				}
				else {
					request.setAttribute("msg", "New Password and Confirm Password not matched");
					request.getRequestDispatcher("c-change-pass.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Old password is incorrect");
				request.getRequestDispatcher("c-change-pass.jsp").forward(request, response);
			}
		}
	}
}