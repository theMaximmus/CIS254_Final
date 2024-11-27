package com.maximmus.cis254_final;

import com.maximmus.cis254_final.AccountWindow.AccountWindowController;
import com.maximmus.cis254_final.RegistrationWindow.RegistrationWindow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MailController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button composeButton;
    @FXML
    private Circle userIconCircle;
    @FXML
    private ListView<String> draftListView = new ListView<>();

    @FXML
    private ListView<String> inboxListView = new ListView<>();

    @FXML
    private ListView<String> sentListView = new ListView<>();

    private boolean isFirstAccount = true;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Mail Application!");
    }

    @FXML
    protected void onComposeButtonClick() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] list = {"Java", "Stalker", "MB?????"};
        inboxListView.getItems().addAll(list);
        draftListView.getItems().addAll(list);
        sentListView.getItems().addAll(list);
        System.out.println(inboxListView.getItems().size());

        // adding user icon
        Image image = new Image(getClass().getResourceAsStream("/com/maximmus/cis254_final/user_icon.png"));
        userIconCircle.setFill(new ImagePattern(image));

        // Handle the click event on the circle
        userIconCircle.setOnMouseClicked(event -> {
            if (isFirstAccount) {
                isFirstAccount = false;
                RegistrationWindow registrationWindow = new RegistrationWindow();
                registrationWindow.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("account-view.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (!User.getUserObservableList().isEmpty()) {
                    AccountWindowController controller = loader.getController();
                    // Assuming you want the first user in the list:
                    User user = User.getUserObservableList().get(0); // Replace with actual logic
                    controller.displayUserInfo(user);

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Account Information");
                    stage.show();
                } else {
                    RegistrationWindow registrationWindow = new RegistrationWindow();
                    registrationWindow.show();
                }
            }
        });
    }
}