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
		//adding cookie in the response 
		Cookie cookie1=new Cookie("user",req.getParameter("name"));//creating cookie object  
		cookie1.setMaxAge(10);
		resp.addCookie(cookie1);
	//	cookie1.setMaxAge(1);
//		Cookie cookie2=new Cookie("userPassword",password);
//		cookie2.setMaxAge(10);
//		resp.addCookie(cookie2);
		out.write("<b> Welcome <b>");
		try 
		{
			UserInfo isUserPresent=GetUserData.getUserDetails(userinfo,req,resp);
			if(isUserPresent!=null) 
			{
				HttpSession session=req.getSession();
				session.setAttribute("name", userinfo.getName());
				String name=userinfo.getName();
				resp.sendRedirect("welcome.jsp?name="+name);
				cookie1.setMaxAge(2);
				resp.sendRedirect("login.html");
				RequestDispatcher rd1 = req.getRequestDispatcher("login.html"); 
				rd1.forward(req, resp);
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


