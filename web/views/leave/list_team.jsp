<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, model.LeaveRequest" %>
<%
    List<LeaveRequest> list = (List<LeaveRequest>) request.getAttribute("leaveRequests");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Team Leave Requests</title>
</head>
<body>
    <h2>Leave Requests of Your Team</h2>
<!--    <a href="<%= request.getContextPath() %>/views/dashboard.jsp">Back to Dashboard</a><br><br>-->

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Employee</th>
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
            <td><%= lr.getCreatedBy() != null ? lr.getCreatedBy().getName() : "" %></td>
            <td><%= lr.getTitle() %></td>
            <td><%= lr.getFromDate() %></td>
            <td><%= lr.getToDate() %></td>
            <td><%= lr.getStatus() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="6">No team leave requests found.</td></tr>
        <% } %>
    </table>
</body>
</html>
