<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int a = 10;%>
	<%!public int getvalue(int a) {
		return a;
	}%>
	
	<% System.out.println("Hello"); %>
	
	<%= getvalue(a) %> <br>
	
	<%= 10+20 %>
	
</body>
</html>