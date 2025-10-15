package controller;

import dal.LeaveRequestDAO;
import model.Employee;
import model.LeaveRequest;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/leave/list")
public class LeaveListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Employee user = (Employee) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/views/auth/login.jsp");
            return;
        }
        LeaveRequestDAO dao = new LeaveRequestDAO();
        // Lấy danh sách đơn của chính user
        List<LeaveRequest> list = dao.getRequestsByCreator(user.getId());

        // Đưa vào request để JSP đọc được
        request.setAttribute("leaveRequests", list);
        System.out.println("So don tim thay: " + list.size());
        // Forward sang JSP
        request.getRequestDispatcher("/views/leave/list_self.jsp").forward(request, response);
    }
}
