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
<tr><th>Book ID</th><th>Book Name</th><th>Book Price</th><th>Available</th><th>Action</th></tr>
<c:forEach items="${book}" var="book">
    <tr>
      <td><c:out value="${book.bookId}" /></td>
      <td><c:out value="${book.bookName}" /></td>
      <td><c:out value="${book.price}" /></td>
      <td><c:out value="${book.available}" /></td>
      <td><a href="/LibraryManagement/BookIssue?bookId=${book.bookId}&username=<%=session.getAttribute("username")%>">Issue</a></td>
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