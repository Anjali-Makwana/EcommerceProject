<%@page import="com.project.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%int pid = Integer.parseInt(request.getParameter("pid")); %>
	<%ProductDao.deleteProduct(pid); %>
	<%response.sendRedirect("s-manage-product.jsp"); %>
</body>
</html>