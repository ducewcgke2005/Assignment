/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author ADMIN
 */
public class EmployeeDAO extends DBContext<Employee> {

    public Employee login(String email, String password) {
    try {
        String sql = """
                     SELECT e.id,
                            e.name,
                            e.email,
                            e.role_id,
                            r.name AS role_name
                     FROM employees e
                     LEFT JOIN roles r ON e.role_id = r.id
                     WHERE e.email = ? 
                     AND e.password = ?
                     """;

        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, email);
        stm.setString(2, password);

        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            Employee e = new Employee();
            e.setId(rs.getInt("id"));
            e.setName(rs.getNString("name"));
            e.setEmail(rs.getString("email"));
            e.setRoleId(rs.getInt("role_id"));
            e.setRoleName(rs.getNString("role_name"));
            return e;
        }

    } catch (SQLException ex) {
        Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        closeConnection();
    }
    return null;
}


    @Override
    public ArrayList<Employee> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Employee get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Employee model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Employee model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Employee model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
