package dal;

import model.LeaveRequest;
import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class LeaveRequestDAO extends DBContext<LeaveRequest> {

    @Override
    public ArrayList<LeaveRequest> list() {
        ArrayList<LeaveRequest> list = new ArrayList<>();
        String sql = """
            SELECT lr.*, e1.name AS created_name, e2.name AS processed_name
            FROM leave_requests lr
            LEFT JOIN employees e1 ON lr.created_by_id = e1.id
            LEFT JOIN employees e2 ON lr.processed_by_id = e2.id
            ORDER BY lr.created_at DESC
        """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LeaveRequest lr = new LeaveRequest();
                lr.setId(rs.getInt("id"));
                lr.setTitle(rs.getString("title"));
                lr.setFromDate(rs.getDate("from_date"));
                lr.setToDate(rs.getDate("to_date"));
                lr.setReason(rs.getString("reason"));
                lr.setStatus(rs.getString("status"));
                lr.setCreatedAt(rs.getTimestamp("created_at"));
                lr.setProcessedAt(rs.getTimestamp("processed_at"));

                // Created By
                Employee created = new Employee();
                created.setId(rs.getInt("created_by_id"));
                created.setName(rs.getString("created_name"));
                lr.setCreatedBy(created);

                // Processed By
                int processedId = rs.getInt("processed_by_id");
                if (processedId != 0) {
                    Employee processed = new Employee();
                    processed.setId(processedId);
                    processed.setName(rs.getString("processed_name"));
                    lr.setProcessedBy(processed);
                }

                list.add(lr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LeaveRequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return list;
    }

    @Override
    public LeaveRequest get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(LeaveRequest model) {
        String sql = """
            INSERT INTO leave_requests (title, from_date, to_date, reason, status, created_by_id, created_at)
            VALUES (?, ?, ?, ?, 'Inprogress', ?, GETDATE())
        """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, model.getTitle());
            ps.setDate(2, model.getFromDate());
            ps.setDate(3, model.getToDate());
            ps.setString(4, model.getReason());
            ps.setInt(5, model.getCreatedBy().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LeaveRequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void update(LeaveRequest model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(LeaveRequest model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
