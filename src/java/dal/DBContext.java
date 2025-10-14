package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// T là model (ví dụ: Employee, Department, LeaveRequest)
public abstract class DBContext<T> {

    protected Connection connection;

    public DBContext() {
        try {
            String user = "sa";  // đổi lại cho đúng user SQL Server của bạn
            String pass = "123456"; // mật khẩu SQL Server
            String url = "jdbc:sqlserver://NguyenSamSet\\SQLEXPRESS:1433;databaseName=AssignmentPRJ;encrypt=true;trustServerCertificate=true;";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Quản lý Transaction
    protected void beginTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void commitTransaction() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void rollbackTransaction() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void resetTransactionMode() {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Abstract methods cho CRUD (DAO con sẽ override)
    public abstract ArrayList<T> list();

    public abstract T get(int id);

    public abstract void insert(T model);

    public abstract void update(T model);

    public abstract void delete(T model);
}
