<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Logged off successfully
<%
session.invalidate();
%>
<a href=login.jsp>Sign Out</a><br>
</body>
</html>