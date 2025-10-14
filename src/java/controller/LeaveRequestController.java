package controller;

import dal.LeaveRequestDAO;
import model.Employee;
import model.LeaveRequest;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/leave/create")
public class LeaveRequestController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy user hiện tại từ session
        HttpSession session = request.getSession(false);
        Employee user = (Employee) session.getAttribute("user");

        // Nếu chưa đăng nhập → quay lại login
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/views/auth/login.jsp");
            return;
        }

        // Lấy dữ liệu từ form
        String title = request.getParameter("title");
        String fromDateStr = request.getParameter("from_date");
        String toDateStr = request.getParameter("to_date");
        String reason = request.getParameter("reason");

        // Tạo đối tượng LeaveRequest
        LeaveRequest leave = new LeaveRequest();
        leave.setTitle(title);
        leave.setFromDate(Date.valueOf(fromDateStr));
        leave.setToDate(Date.valueOf(toDateStr));
        leave.setReason(reason);
        leave.setStatus("Inprogress");
        leave.setCreatedBy(user);

        // Gọi DAO để thêm vào DB
        LeaveRequestDAO dao = new LeaveRequestDAO();
        dao.insert(leave);

        // Chuyển hướng về trang danh sách đơn nghỉ phép
        response.sendRedirect(request.getContextPath() + "/views/leave/list.jsp");
    }
}
