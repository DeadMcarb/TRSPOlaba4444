package org.example.trspolaba4.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.trspolaba4.model.User;


public class UserController {
    private final DatabaseController databaseController;

    public UserController(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    private final ObservableList<User> user_list = FXCollections.observableArrayList();

    public void read(TableView user_table,
                     TableColumn id,
                     TableColumn name,
                     TableColumn password,
                     TableColumn roles,
                     TableColumn email) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        roles.setCellValueFactory(new PropertyValueFactory<>("roles"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        databaseController.user_read(user_table, user_list);

    }

    public void create(int id, String name, String password, String roles, String email) {
        databaseController.user_create(id, name, password, roles, email);
    }

    public void update(int id, String name, String password, String roles, String email) {
        databaseController.user_update(id, name, password, roles, email);
    }

    public void delete(int id) {
        databaseController.user_delete(id);
    }


    public ObservableList<User> getIdAndNameUsers() {
        return databaseController.getIdAndNameUsers();
    }
}
