package com.bridgelabz.configure.dbutil.model.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUserInfo extends HttpServlet{
	static final long serialVersionUID=1234L;
	static Connection con=null;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String query = "update USERINFO set name = ?, email_id=?,password=? where phone_num=?";
			con=UpdateToDataBase.getMySQLConnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, req.getParameter("name1"));
			preparedStmt.setString(2, req.getParameter("email"));
			preparedStmt.setString(3, req.getParameter("password"));
			preparedStmt.setString(4, req.getParameter("phoneNumber"));
			preparedStmt.executeUpdate();
			PrintWriter out = resp.getWriter(); 
			out.write("<b> UserInfo Successfully updated <b>");
			RequestDispatcher rd1 = req.getRequestDispatcher("login.html"); 
			rd1.include(req, resp);  
		}catch(SQLException | ClassNotFoundException s) {
			PrintWriter out = resp.getWriter(); 
			s.printStackTrace();
			out.write("<b> Please enter correct old Phone Number <b>");
			RequestDispatcher rd1 = req.getRequestDispatcher("editUserInfo.jsp"); 
			rd1.include(req, resp); 
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
}
