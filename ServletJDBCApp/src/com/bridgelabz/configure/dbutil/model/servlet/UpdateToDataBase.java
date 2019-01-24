package com.bridgelabz.configure.dbutil.model.servlet;

import java.sql.*;

public class UpdateToDataBase
{
	public static Connection getMySQLConnection()
			throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "ServletProject";
		String userName = "root";
		String password = "password";
		return getMySQLConnection(hostName, dbName, userName, password);
	}
	public static Connection getMySQLConnection(String hostName, String dbName,
			String userName, String password) throws SQLException,
	ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName,
				password);
		return conn;
	}
	public static void registration(UserInfo userInfo) throws SQLException, ClassNotFoundException
	{
		String query = " insert into USERINFO (id,name, email_id,phone_num, password)"
				+ " values (?,?, ?, ?, ?)";
		Connection conn=getMySQLConnection();

		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt(1, 0);
		preparedStmt.setString (2, userInfo.getName());
		preparedStmt.setString (3, userInfo.getEmail());
		preparedStmt.setString (4,userInfo.getPhoneNumber() );
		preparedStmt.setString(5, userInfo.getPassword());
		preparedStmt.execute();
		System.out.println("Corresponding key is "+preparedStmt.getGeneratedKeys());
		DatabaseMetaData d=conn.getMetaData();
		System.out.println("Driver version is "+ d.getDriverVersion());
		System.out.println("Driver version is "+ d.getDriverName());
		System.out.println("Driver version is "+ d.getDriverVersion());
		System.out.println("Driver version is "+ d.getDatabaseProductName());
		System.out.println("Driver version is "+ d.getDatabaseProductVersion());
		conn.close();
	}
}

