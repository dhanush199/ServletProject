<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.bridgelabz.configure.dbutil.model.servlet.UserInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>You are on Home page</h1>
<%
String name=request.getParameter("name");
out.println("Welcome : "+name);
UserInfo isUserPresent=(UserInfo)session.getAttribute("USERInfo");
String userName = null;
Cookie[] cookies = request.getCookies();
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("user"))
			userName = cookie.getValue();
	}

%>
	Hi
		<%out.println("User Name= "+isUserPresent.getName());%>, Login successful.
		<%out.println("User Password= "+isUserPresent.getPassword());%>
		<%out.println("User Email= "+isUserPresent.getEmail());%>
	   <%out.println("User PhoneNum= "+isUserPresent.getPhoneNumber());%>
		
<a href=login.html>Sign Out</a><br>
<a href=editUserInfo.jsp>Edit user Info</a><br>


</body>
</html>