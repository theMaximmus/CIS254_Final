package com.maximmus.cis254_final.MessageView;

import com.maximmus.cis254_final.Mail;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MessageViewWindow extends Application {

    private Stage primaryStage; // The stage for this window

    private Mail message;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        // Load the FXML file
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("C:\\Users\\Maximmus\\IdeaProjects\\CIS_254\\CIS254_Final1\\src\\main\\resources\\com\\maximmus\\cis254_final\\message_view.fxml")));
            MessageViewWindowController controller = fxmlLoader.getController();
            controller.setMessage(message);
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set up the scene and stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Message");
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
        System.out.println("Opened the Message View Window");
    }

    public void setMessage(Mail message) {
        this.message = message;
    }
}