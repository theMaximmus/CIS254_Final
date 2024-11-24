package com.maximmus.cis254_final;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MailController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private ListView<String> draftListView;

    @FXML
    private ListView<String> inboxListView;

    @FXML
    private ListView<String> sentListView;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Mail Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] list = {"Java", "SOSI", "MB?????"};
        inboxListView.getItems().addAll(list);
    }
}