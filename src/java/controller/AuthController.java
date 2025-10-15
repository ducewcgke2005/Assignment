/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.EmployeeDAO;
import model.Employee;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
@WebServlet("/login")
public class AuthController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee emp = employeeDAO.login(email, password);

        if (emp != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", emp);
            response.sendRedirect(request.getContextPath() + "/views/dashboard.jsp");
        } else {
            request.setAttribute("loginError", "Email hoặc mật khẩu không đúng");
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
    }
    
    
}
