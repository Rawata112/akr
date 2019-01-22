<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style><%@include file="../css/LibraryStyling.css"%></style>
<head>
<meta charset="ISO-8859-1">
<title>Library Management</title>
</head>
<body>
<div>
<h2>Library Management Login</h2>
<table border="1" align="center">
<form action="/LibraryManagement/Login" method="post">
<tr><td>Username</td><td><input type="text" name="id" required="required"></td></tr>
<tr><td>Password</td><td><input type="password" name="password"  required="required"></td></tr>
<tr><td colspan="2"><input type="submit" value="Login!"></td></tr>
</form>
<%if(request.getAttribute("errorMessage")!=null){ %>
<tr><th colspan="2"><%=request.getAttribute("errorMessage") %></th></tr>
<% }%>
</table>
</div>
</body>
</html>