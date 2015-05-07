<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Member JSP View</title>
</head>
<body>
	<table border="1">
		<tr>
		<td>NAME</td>
		<td>Phone</td>
		<td>Email</td>
		</tr>
		<tr>
			<td>${member.name}</td>
			<td>${member.email}</td>
			<td>${member.phone}</td>
		</tr>
	</table>
</body>
</html>