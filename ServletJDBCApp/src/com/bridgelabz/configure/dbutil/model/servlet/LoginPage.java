package com.bridgelabz.configure.dbutil.model.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserInfo userinfo=new UserInfo();
		userinfo.setName(req.getParameter("name"));
		userinfo.setPassword(req.getParameter("password"));
		System.out.println(userinfo.getName());
		System.out.println(userinfo.getPassword());
		PrintWriter out = resp.getWriter(); 
		out.write("<b> Welcome <b>");
		try {
			UserInfo isUserPresent=GetUserData.getUserDetails(userinfo);
			if(isUserPresent!=null) {
				RequestDispatcher rd1 = req.getRequestDispatcher("home.html");
				rd1.forward(req, resp);  
			}
			else{ 
				out.print("Password incorrect!!"); 
				RequestDispatcher rd1 = req.getRequestDispatcher("login.html"); 
				rd1.include(req, resp);  
			}
		}catch(Exception e) {
			System.out.println("404 finding....");

		}
	}
}
