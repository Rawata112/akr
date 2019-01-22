<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style><%@include file="../css/LibraryStyling.css"%></style>
<head>
<meta charset="ISO-8859-1">
<title>Library Home</title>
</head>
<body>
<table border="2" align="center">
<form action="FindBook">
	<tr><th><input type="text" name="bookName" placeholder="Book Name"></th>
	<th><input type="submit" value="Find"></th></tr>
</form>
</table>
<table border="1" align="center">
<tr><th colspan="2">Hello ${user.id}</th></tr>
<tr><td colspan="2">Welcome to Library Management</td></tr>
<tr><td>Show Books</td><td><a href="/LibraryManagement/ShowBooks">Go!</a></td></tr>
<tr><td>Show Books Stock</td><td><a href="/LibraryManagement/ShowBooksMax">Go!</a></td></tr>
<tr><td>User Management</td><td><a href="/LibraryManagement/UserMgmt.jsp">Go!</a></td></tr>
<tr><td>Issued Books</td><td><a href="/LibraryManagement/IssuedBooks">Go!</a></td></tr>
<tr><td>Book Not Available</td><td><a href="/LibraryManagement/BookNotAvailable">Go!</a></td></tr>
</table>
<%if(request.getAttribute("error")!=null){ %>
<tr><th colspan="2"><%=request.getAttribute("error") %></th></tr>
<% }%>
<table align="center">
<tr><td><a href="/LibraryManagement/Home.jsp">Home</a></td>
</tr>
</table>
</body>
</html>