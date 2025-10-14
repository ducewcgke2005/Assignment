package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Hủy session trên server
        }

        // Xóa cookie JSESSIONID trên trình duyệt
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        cookie.setPath("/"); // Đặt path về root path
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath() + "/views/auth/login.jsp");
    }
}
