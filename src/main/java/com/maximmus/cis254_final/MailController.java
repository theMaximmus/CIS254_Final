package com.maximmus.cis254_final;

import com.maximmus.cis254_final.RegistrationWindow.RegistrationWindow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class MailController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Circle userIconCircle;
    @FXML
    private ListView<String> draftListView = new ListView<>();

    @FXML
    private ListView<String> inboxListView = new ListView<>();

    @FXML
    private ListView<String> sentListView = new ListView<>();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Mail Application!");
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
            RegistrationWindow registrationWindow = new RegistrationWindow();
            registrationWindow.show();
        });
    }
}