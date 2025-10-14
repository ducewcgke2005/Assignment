<%-- 
    Document   : dashboard
    Created on : Oct 12, 2025, 11:43:13 PM
    Author     : ADMIN
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Employee" %>
<%
    Employee user = (Employee) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("auth/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h2>Welcome, <%= user.getName() %>!</h2>
    <p>Email: <%= user.getEmail() %></p>
    <p>Role: <%= user.getRoleName() %></p>

    <a href="<%= request.getContextPath() %>/logout">Log out</a>

</body>
</html>

