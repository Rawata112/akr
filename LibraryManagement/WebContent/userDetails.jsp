<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style><%@include file="../css/LibraryStyling.css"%></style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2" align="center">
<tr><th>User ID</th><th>First Name</th><th>Last Name</th><th>User Type</th></tr>
<c:forEach items="${user}" var="user">
    <tr>
      <td><c:out value="${user.id}" /></td>
      <td><c:out value="${user.first}" /></td>
      <td><c:out value="${user.last}" /></td>
      <td><c:out value="${user.type}" /></td>
    </tr>
  </c:forEach>
</table>
<table align="center">
<tr><td><a href="/LibraryManagement/Home.jsp">Home</a></td>
</tr>
</table>
<%if(request.getAttribute("error")!=null){ %>
<tr><th colspan="2"><%=request.getAttribute("error") %></th></tr>
<% }%>
</body>
</html>