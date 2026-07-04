package dao;

import db.DatabaseConnection;
import model.Role;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    RoleDao roleDao = new RoleDao();

    // چک وجود username
    public boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    // ثبت کاربر
    public boolean save(User user) {
        String sql = "INSERT INTO users (username, password, role_name) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRoleName());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveDoctor(User user, String medicalCode) {
        String insertUserSql = "INSERT INTO users (username, password, role_name) VALUES (?, ?, ?)";
        String insertDoctorSql = "INSERT INTO doctor_profiles (user_id) VALUES (?)";

        Connection conn = null;
        PreparedStatement userStmt = null;
        PreparedStatement doctorStmt = null;
        ResultSet generatedKeys = null;

        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            userStmt = conn.prepareStatement(insertUserSql, PreparedStatement.RETURN_GENERATED_KEYS);
            userStmt.setString(1, user.getUsername());
            userStmt.setString(2, user.getPassword());
            userStmt.setString(3, user.getRoleName());

            int affectedRows = userStmt.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                return false;
            }

            generatedKeys = userStmt.getGeneratedKeys();
            if (!generatedKeys.next()) {
                conn.rollback();
                return false;
            }

            int userId = generatedKeys.getInt(1);

            doctorStmt = conn.prepareStatement(insertDoctorSql);
            doctorStmt.setInt(1, userId);

            int doctorRows = doctorStmt.executeUpdate();
            if (doctorRows == 0) {
                conn.rollback();
                return false;
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;

        } finally {
            try { if (generatedKeys != null) generatedKeys.close(); } catch (Exception ignored) {}
            try { if (userStmt != null) userStmt.close(); } catch (Exception ignored) {}
            try { if (doctorStmt != null) doctorStmt.close(); } catch (Exception ignored) {}
            try { if (conn != null) conn.setAutoCommit(true); } catch (Exception ignored) {}
            try { if (conn != null) conn.close(); } catch (Exception ignored) {}
        }
    }


    // login
    public User login(String username, String password) {

        String sql = """
               SELECT u.id,u.username,u.password,r.name as role
               FROM users u
               JOIN roles r ON u.role_id = r.id
               WHERE u.username=? AND u.password=?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRoleName(rs.getString("role"));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
