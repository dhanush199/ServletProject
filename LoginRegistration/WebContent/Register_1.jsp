<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guru Registration Form</title>
</head>
<body>
<h1>Guru Register Form</h1>
<form action="guru_register" method="get">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="name" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="email" name="userEmail" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="phoneNum" /></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>

</body>
</html>