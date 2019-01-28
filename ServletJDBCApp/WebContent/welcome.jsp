<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
%>
	Hi
		<%=name%>, Login successful.
<%
		String userName = null;
		Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
				out.println("Cookies are "+userName);
			}
		
		if (userName == null)
			response.sendRedirect("login.html");
	%>
	
<a href=login.html>Sign Out</a><br>

</body>
</html>