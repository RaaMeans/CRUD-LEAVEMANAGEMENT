package net.javaguides.leavemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.leavemanagement.model.Leave;
import net.javaguides.leavemanagement.model.User;

public class CombinedDAO {
    private String jdbcURL = "jdbc:derby:C:\\Users\\ACER\\MyDB;create=true";
    private String jdbcUsername = "admin";
    private String jdbcPassword = "12345";

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, email, contactNumber) VALUES (?, ?, ?, ?)";
    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT id, username, password, email, contactNumber FROM users WHERE username = ? AND password = ?";
    
    private static final String INSERT_LEAVE_SQL = "INSERT INTO leaves (name, status, type) VALUES (?, ?, ?)";
    private static final String SELECT_LEAVE_BY_ID = "SELECT id, name, status, type FROM leaves WHERE id = ?";
    private static final String SELECT_ALL_LEAVES = "SELECT id, name, status, type FROM leaves";
    private static final String DELETE_LEAVE_SQL = "DELETE FROM leaves WHERE id = ?";
    private static final String UPDATE_LEAVE_SQL = "UPDATE leaves SET name = ?, status = ?, type = ? WHERE id = ?";

    public CombinedDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public void registerUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getContactNumber());
            preparedStatement.executeUpdate();
        }
    }

    public User loginUser(String username, String password) throws SQLException {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String contactNumber = rs.getString("contactNumber");
                user = new User(id, username, password, email, contactNumber);
            }
        }
        return user;
    }

    public void insertLeave(Leave leave) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LEAVE_SQL)) {
            preparedStatement.setString(1, leave.getName());
            preparedStatement.setString(2, leave.getStatus());
            preparedStatement.setString(3, leave.getType());
            preparedStatement.executeUpdate();
        }
    }

    public Leave selectLeave(int id) throws SQLException {
        Leave leave = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LEAVE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String status = rs.getString("status");
                String type = rs.getString("type");
                leave = new Leave(id, name, status, type);
            }
        }
        return leave;
    }

    public List<Leave> selectAllLeaves() throws SQLException {
        List<Leave> leaves = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LEAVES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String status = rs.getString("status");
                String type = rs.getString("type");
                leaves.add(new Leave(id, name, status, type));
            }
        }
        return leaves;
    }

    public boolean deleteLeave(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_LEAVE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateLeave(Leave leave) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_LEAVE_SQL)) {
            statement.setString(1, leave.getName());
            statement.setString(2, leave.getStatus());
            statement.setString(3, leave.getType());
            statement.setInt(4, leave.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    
}