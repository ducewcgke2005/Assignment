<%-- 
    Document   : create
    Created on : Oct 14, 2025, 10:21:47 PM
    Author     : ADMIN
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Employee" %>
<%
    Employee user = (Employee) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/views/auth/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Request Leave</title>
</head>
<body>
    <h2>Create Leave Request</h2>
    <p>Employee: <strong><%= user.getName() %></strong></p>

    <form action="<%= request.getContextPath() %>/leave/create" method="post">
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title" placeholder="E.g. Wedding Leave"><br><br>

        <label for="from_date">From Date:</label><br>
        <input type="date" id="from_date" name="from_date" required><br><br>

        <label for="to_date">To Date:</label><br>
        <input type="date" id="to_date" name="to_date" required><br><br>

        <label for="reason">Reason:</label><br>
        <textarea id="reason" name="reason" rows="4" cols="50" placeholder="Enter reason..." required></textarea><br><br>

        <button type="submit">Submit Request</button>
        <a href="<%= request.getContextPath() %>/views/dashboard.jsp">Cancel</a>
    </form>
</body>
</html>

