package org.example.trspolaba4;


import javafx.scene.control.*;


public class UserController {



    public TableView user_table;
    public TableColumn user_id;
    public TableColumn user_name;
    public TableColumn user_password;
    public TableColumn user_roles;
    public TableColumn user_email;



    public Label user_idLabel;
    public Label user_nameLabel;
    public Label user_passwordLabel;
    public Label user_rolesLabel;
    public Label user_emailLabel;

    public TextField user_idTextField;
    public TextField user_nameTextField;
    public TextField user_passwordTextField;
    public TextField user_rolesTextField;
    public TextField user_emailTextField;

    UserRepository dbCtrl = new UserRepository();
    UserService uCtrl = new UserService(dbCtrl);



    public void reconnect() {
        user_read();
    }


    public void initialize() {
        user_read();

        user_autofill();
    }

    //Users
    private void user_read() {
        uCtrl.read(user_table, user_id, user_name, user_password, user_roles, user_email);
    }

    public void user_createButton() {
        uCtrl.create(Integer.parseInt(user_idTextField.getText()),
                user_nameTextField.getText(),
                user_passwordTextField.getText(),
                user_rolesTextField.getText(),
                user_emailTextField.getText());
        user_read();
    }

    public void user_updateButton() {
        uCtrl.update(Integer.parseInt(user_idTextField.getText()),
                user_nameTextField.getText(),
                user_passwordTextField.getText(),
                user_rolesTextField.getText(),
                user_emailTextField.getText());
        user_read();
    }

    public void user_deleteButton() {
        uCtrl.delete(Integer.parseInt(user_idTextField.getText()));
        user_read();
    }

    private void user_autofill() {
        user_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == null) return;
            User selectedUser = (User) newValue;
            user_idTextField.setText(String.valueOf(selectedUser.getId()));
            user_nameTextField.setText(selectedUser.getName());
            user_passwordTextField.setText(selectedUser.getPassword());
            user_rolesTextField.setText(selectedUser.getRoles());
            user_emailTextField.setText(selectedUser.getEmail());
        });
    }

}

