<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bridgelabz.configure.dbutil.model.servlet.UserInfo"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: lightblue;
}

p1.dotted {
	border-style: dotted;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	height: auto; /*if more info comes on the page, it will stretch down*/
	width: 1000px;
	margin: 0 auto; /*this will cause the div to be in the center*/
}

p {
	color: green;
	text-align: center;
}
</style>
</head>
<body>
	<div align="center" />
	<p1>
	<h2 style="color: blue">Greetings..!! Home page</h2>
	<p>
		Hi <br>
		<%
			String name = request.getParameter("name");
			out.println("Welcome : ");
			UserInfo isUserPresent = (UserInfo) session.getAttribute("USERInfo");
			String userName = null;
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
			}
		%>
		<br>Login Successful <br>
		<%
			out.println("User Name= " + isUserPresent.getName());
		%>
		<br>
		<%
			out.println("User Password= " + isUserPresent.getPassword());
		%>
		<br>
		<%
			out.println("User Email= " + isUserPresent.getEmail());
		%>
		<br>
		<%
			out.println("User PhoneNum= " + isUserPresent.getPhoneNumber());
		%>
		<br>
		<%
			out.println("Session ID= " + session.getId());
			session.setAttribute("name", isUserPresent.getName());
		%>
	
	</p1>

		<br> <a href=startPage.jsp>Sign Out</a> <br> <a
			href=editUserInfo.jsp>Edit user Info</a> <br>
		<p1>
		</div>
</body>
</html>