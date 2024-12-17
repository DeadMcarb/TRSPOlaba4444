package org.example.trspolaba4;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;

public class UserRepository {
    private final Database db = new Database();
    private final Connection connection = db.getConnection();

    public void user_read(TableView userTable, ObservableList<User> userList) {
        userList.clear();
        String sql = "SELECT id, name, password, roles, email FROM user";
        try (PreparedStatement statement = this.connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String roles = resultSet.getString("roles");
                String email = resultSet.getString("email");
                User user = new User(id, name, password, roles, email);
                userList.add(user);
            }
            userTable.setItems(userList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void user_create(int id, String name, String password, String roles, String email) {
        String sql = "INSERT INTO user (id, name, password, roles, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setString(4, roles);
            statement.setString(5, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void user_update(int id, String name, String password, String roles, String email) {
        String sql = "UPDATE user SET name = ?, password = ?, roles = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, roles);
            statement.setString(4, email);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void user_delete(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
