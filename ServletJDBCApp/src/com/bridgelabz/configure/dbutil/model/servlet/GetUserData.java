package com.bridgelabz.configure.dbutil.model.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserData
{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	static final String DB_URL="jdbc:mysql://localhost/ServletProject";
	static java.sql.Statement stmt =null;
	static Connection conn =null;
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "password";
	static int flag=0;
	static  UserInfo user=null;
	public static UserInfo getUserDetails(UserInfo userinfo, HttpServletRequest req, HttpServletResponse resp)
	{
		try{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			//Connection conn=UpdateToDataBase.getMySQLConnection("localhost",DB_URL, USER, PASS);
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// Execute SQL query
		String sql;
		//String userName=userinfo.getName();
		sql = "SELECT * FROM USERINFO Where name=? and password=?";
		java.sql.PreparedStatement preStatement=conn.prepareStatement(sql);
		preStatement.setString(1,userinfo.getName());
		preStatement.setString(2,userinfo.getPassword());
			ResultSet rs = preStatement.executeQuery();
			// Extract data from result set
			while(rs.next()){
				user=new UserInfo();
				user.setEmail(rs.getString(3));
				user.setName(rs.getString(2));
				user.setPhoneNumber(rs.getString(4));
				user.setPassword(rs.getString(5));
				System.out.println("Name  "+user.getName());
				System.out.println("Password "+user.getPassword());
			}
			rs.close();
			conn.close();
			// Clean-up environment
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		} //end try
		return user;
	}
}
