package com.maximmus.cis254_final.AccountWindow;

import com.maximmus.cis254_final.RegistrationWindow.RegistrationWindowController;
import com.maximmus.cis254_final.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountWindowController implements Initializable {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Button exitButton;

    @FXML
    protected void onExitButtonClick() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        System.out.println("Closed the Information Window");
    }

    @FXML
    protected void onLogOutButtonClick() {
        System.out.println("Logged out of the account");
        RegistrationWindowController.setRegistred(false);
        onExitButtonClick();
        User.getUserObservableList().remove(0);
    }

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
            passwordLabel.setText("Password: " + user.getPassword());
        } else {
            usernameLabel.setText("No user information available.");
            passwordLabel.setText("No user information available.");
        }

    }

}
