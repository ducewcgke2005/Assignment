<%-- 
    Document   : login
    Created on : Oct 12, 2025, 11:20:45 PM
    Author     : ADMIN
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login System</title>
    </head>
    <body>
        <div class="login-container">
            <h2>Login System</h2>

            <form action="<%= request.getContextPath() %>/login" method="post">

                <label for="email">Email</label>
                <input type="text" id="email" name="email" required>
                <br>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
                <br><!-- comment -->
                <button type="submit">Login</button>
            </form>

            <c:if test="${not empty loginError}">
                <p style="color:red">${loginError}</p>
            </c:if>
        </div>
    </body>
</html>

