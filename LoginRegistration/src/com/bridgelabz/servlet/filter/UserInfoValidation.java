package com.bridgelabz.servlet.filter;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoValidation implements 	Filter {
	//static final String REGEX_EMAIL_ID = "^[a-z0-9._%+-]+@[A-Z0-9.-]+\\\\.[a-z]{2,6}$";
	static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	static final String REGEX_CONTACT = "^[0-9]{10}$";

	public void init(FilterConfig arg0) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chainObj)
			throws IOException, ServletException {
		RequestDispatcher requestDispatcher = null;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		String emailid = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("phoneNumber");
		if (/*emailid.matches(REGEX_EMAIL_ID) &&*/ (password.matches(password)) && (contact.matches(REGEX_CONTACT))) {
			//if((contact.matches(REGEX_CONTACT)&& (password.matches(REGEX_PASSWORD)))){
			chainObj.doFilter(request, response);
		}
		else {
			PrintWriter out = response.getWriter(); 
			out.write("<b> Please enter the valid name or E-mail ID or Phone Number <b>");
			requestDispatcher = request.getRequestDispatcher("/index.html");
			requestDispatcher.include(request, response);
		}
	}
	public void destroy() {
	}
}
