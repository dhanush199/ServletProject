package com.bridgelabz.loginregistrationapp;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class guru_register
 */
public class Guru_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String first_name = req.getParameter("first_name");
//		String last_name = req.getParameter("last_name");
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		UserInfo userInfo=new UserInfo();
//		userInfo.setFirst_name(first_name);
//		userInfo.setLast_name(last_name);
		userInfo.setName(name);
		userInfo.setEmail(req.getParameter("userEmail"));
		userInfo.setPhoneNumber(req.getParameter("phoneNum"));
		userInfo.setPassword(password);
		try {
			UpdateToDataBase.registration(userInfo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//display(userInfo);
		PrintWriter out = resp.getWriter(); 
		out.write("<b> Successfully Registered <b>");
		RequestDispatcher rd1 = req.getRequestDispatcher("Register_1.jsp"); 
		rd1.include(req, resp);  
	}
 
}
