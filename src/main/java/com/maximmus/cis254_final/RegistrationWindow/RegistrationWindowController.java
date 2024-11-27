package com.maximmus.cis254_final.RegistrationWindow;

import com.maximmus.cis254_final.AccountWindow.AccountInformationWindow;
import com.maximmus.cis254_final.AccountWindow.AccountWindowController;
import com.maximmus.cis254_final.CustomExceptions.EmptyPasswordException;
import com.maximmus.cis254_final.CustomExceptions.EmptyUsernameException;
import com.maximmus.cis254_final.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.maximmus.cis254_final.AccountWindow.AccountInformationWindow.registerAnAccount;

public class RegistrationWindowController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button registerButton;
    @FXML
    private Button cancelRegistrationButton;

    static boolean isRegistred = false;


    @FXML
    protected void onCancelRegistrationButtonClick() {
        Stage stage = (Stage) cancelRegistrationButton.getScene().getWindow();
        stage.close();
        System.out.println("Closed the Registration Window");
    }

    @FXML
    protected void onRegisterButtonClick() {
        isRegistred = isRegistred();
        try {
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            isRegistred = registerAnAccount(username, password);
            

            System.out.println("A new user account is created (Username: " + username + ", Password: " + password + ")");
        } catch (EmptyUsernameException emptyUsernameException) {
            showMessage("Username field cannot be empty", Alert.AlertType.ERROR);
            System.out.println("Username field is empty");
        } catch (EmptyPasswordException emptyPasswordException) {
            showMessage("Password field cannot be empty", Alert.AlertType.ERROR);
            System.out.println("Password field is empty");
        }
        if (isRegistred) {
            Stage stage = (Stage) cancelRegistrationButton.getScene().getWindow();
            stage.close();
            System.out.println("Closed the Registration Window");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Displays a pop-up window with a desired message and AlertType
     * @param message Your custom message
     * @param alertType Your custom AlertType
     */
    private void showMessage(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Message");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean isRegistred() {
        return isRegistred;
    }

    public static void setRegistred(boolean registred) {
        isRegistred = registred;
    }
}
