<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style><%@include file="../css/LibraryStyling.css"%></style>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
<form action="/LibraryManagement/FindUser">
<input type="text" name="username">
<input type="submit" value="go">
</form>
<table align="center">
<tr><td><a href="/LibraryManagement/Home.jsp">Home</a></td>
</tr>
</table>
<%if(request.getAttribute("error")!=null){ %>
<tr><th colspan="2"><%=request.getAttribute("error") %></th></tr>
<% }%>
</body>
</html>