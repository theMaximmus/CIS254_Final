package com.maximmus.cis254_final;

import com.maximmus.cis254_final.RegistrationWindow.RegistrationWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class MessagePreviewController implements Initializable {
    @FXML
    private Label senderLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private Circle trashIconCircle;
    @FXML
    private CheckBox checkBox;

    @FXML
    private ListView<String> draftListView = new ListView<>();

    @FXML
    private ListView<String> inboxListView = new ListView<>();

    @FXML
    private ListView<String> sentListView = new ListView<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // adding user icon
        Image image = new Image(getClass().getResourceAsStream("/com/maximmus/cis254_final/trash_icon.png"));
        trashIconCircle.setFill(new ImagePattern(image));

        // Handle the click event on the circle
        trashIconCircle.setOnMouseClicked(event -> {
            RegistrationWindow registrationWindow = new RegistrationWindow();
            registrationWindow.show();
        });
    }
}