<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, model.LeaveRequest" %>
<%
    List<LeaveRequest> list = (List<LeaveRequest>) request.getAttribute("leaveRequests");
%>
<html>
<!DOCTYPE html>
<head>
    <title>Your Leave Requests</title>
</head>
<body>
    <h2>Your Leave Requests</h2>
    <a href="<%= request.getContextPath() %>/views/leave/create.jsp">Create new request</a><br><br>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>From</th>
            <th>To</th>
            <th>Status</th>
        </tr>
        <%
            if (list != null && !list.isEmpty()) {
                for (LeaveRequest lr : list) {
        %>
        <tr>
            <td><%= lr.getId() %></td>
            <td><%= lr.getTitle() %></td>
            <td><%= lr.getFromDate() %></td>
            <td><%= lr.getToDate() %></td>
            <td><%= lr.getStatus() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="5">No leave requests found.</td></tr>
        <% } %>
    </table>
</body>
</html>
