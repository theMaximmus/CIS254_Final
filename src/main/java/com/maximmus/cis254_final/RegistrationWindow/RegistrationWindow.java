package com.maximmus.cis254_final.RegistrationWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationWindow extends Application {

    private Stage primaryStage; // The stage for this window

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        // Load the FXML file
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/maximmus/cis254_final/Registration_view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set up the scene and stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Registration Window");
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
    }
}
