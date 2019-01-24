package com.bridgelabz.configure.dbutil.model.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginRegistatrionApp extends HttpServlet {
	//List<UserInfo> listOfuserInfo=new ArrayList<>();
	UserInfo userInfo=null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserInfo userInfo=new UserInfo();
		String phoneNumber=req.getParameter("phoneNumber");
		userInfo.setEmail(req.getParameter("email"));
		userInfo.setName(req.getParameter("name1"));
		userInfo.setGender(req.getParameter("gender"));
		userInfo.setPassword(req.getParameter("password"));
		userInfo.setPhoneNumber(phoneNumber);
	//	listOfuserInfo.add(userInfo);
		try {
			UpdateToDataBase.registration(userInfo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		display(userInfo);
		PrintWriter out = resp.getWriter(); 
		out.write("<b> Successfully Registered <b>");
//		RequestDispatcher rd1 = req.getRequestDispatcher("login.html"); 
//		rd1.include(req, resp);  
	}
	public void display(UserInfo userInfo2) {
		System.out.println("Name:         "+ userInfo2.getName());
		System.out.println("email:	      "+userInfo2.getEmail());
		System.out.println("Phone Number: "+userInfo2.getPhoneNumber());
		System.out.println("Gender:       "+userInfo2.getGender());
		System.out.println("Password:     "+userInfo2.getPassword());

	}
}
