package com.bridgelabz.configure.dbutil.model.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPage extends HttpServlet{
	static final long serialVersionUID=12356L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserInfo userinfo=new UserInfo();
		userinfo.setName(req.getParameter("name"));
		userinfo.setPassword(req.getParameter("password"));
		String password=userinfo.getPassword();
		PrintWriter out = resp.getWriter(); 
		Cookie cookie1=new Cookie("user",req.getParameter("name"));//creating cookie object  
		resp.addCookie(cookie1);//adding cookie in the response 
		cookie1.setMaxAge(1800);
		Cookie cookie2=new Cookie("userPassword",password);
		cookie2.setMaxAge(1800);
		resp.addCookie(cookie2);
		out.write("<b> Welcome <b>");
		try 
		{
			UserInfo isUserPresent=GetUserData.getUserDetails(userinfo);
			if(isUserPresent!=null) 
			{
				resp.sendRedirect("CookieValidation.jsp");
				cookie2.setMaxAge(0);
				resp.addCookie(cookie2);
				cookie1.setMaxAge(0);
				resp.addCookie(cookie1);
				HttpSession session = req.getSession();
				session.setAttribute("username", "name");
				System.out.println(session.getAttribute("username"));
				resp.sendRedirect("CookieValidation.jsp");
				RequestDispatcher rd1 = req.getRequestDispatcher("home.html");
				rd1.forward(req, resp); 	
				//rd1.forward(req, resp); 
			} 
			else
			{ 
				out.print("Password incorrect!!"); 
				RequestDispatcher rd1 = req.getRequestDispatcher("login.html"); 
				rd1.include(req, resp);  
			}
		}		
		catch(Exception e) {
			System.out.println("404 finding....");
		}
	}
}


