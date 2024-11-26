package com.maximmus.cis254_final.AccountWindow;

import com.maximmus.cis254_final.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountWindowController implements Initializable {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;

    private User currentUser;

    public void setUser(User user) {
        this.currentUser = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        usernameLabel.setText(currentUser.getUsername()); // of course you would change it if you want to have multiple accounts
//        passwordLabel.setText(currentUser.getPassword()); // of course you would change it if you want to have multiple accounts
    }

    public void displayUserInfo(User user) {
        if (user != null) {
            usernameLabel.setText("Username: " + user.getUsername());
            passwordLabel.setText(user.getPassword());
        } else {
            usernameLabel.setText("No user information available.");
            passwordLabel.setText("No user information available.");
        }

    }

}
