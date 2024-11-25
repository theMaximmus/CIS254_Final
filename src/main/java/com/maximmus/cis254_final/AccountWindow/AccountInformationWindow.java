package com.maximmus.cis254_final.AccountWindow;

import com.maximmus.cis254_final.CustomExceptions.EmptyPasswordException;
import com.maximmus.cis254_final.CustomExceptions.EmptyUsernameException;
import com.maximmus.cis254_final.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountInformationWindow extends Application {
    private Stage primaryStage; // The stage for this window

    private AccountWindowController controller;

    public void setController(AccountWindowController controller) {
        this.controller = controller;
    }

    public void setUser(User user) {
        if (controller != null) {
            controller.setUser(user);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        // Load the FXML file
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/maximmus/cis254_final/account-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set up the scene and stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Your account");
        primaryStage.setScene(scene);
    }

    // Public method to show the window
    public void show() {
        if (primaryStage == null) {
            primaryStage = new Stage();
            try {
                start(primaryStage); // Initialize if not already done
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        primaryStage.show();
        System.out.println("Opened the Account View window");
    }

    public static User registerAnAccount(String username, String password) throws EmptyUsernameException, EmptyPasswordException {
        if (username.isEmpty() || username == null) {
            throw new EmptyUsernameException();
        }
        if (password.isEmpty() || password == null) {
            throw new EmptyPasswordException();
        }
        User user = new User(username, password);
        return user;
    }

}

