package org.example.trspolaba4;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        userRepository.user_read(user_table, user_list);

    }

    public void create(int id, String name, String password, String roles, String email) {
        userRepository.user_create(id, name, password, roles, email);
    }

    public void update(int id, String name, String password, String roles, String email) {
        userRepository.user_update(id, name, password, roles, email);
    }

    public void delete(int id) {
        userRepository.user_delete(id);
    }

}
