package com.maximmus.cis254_final;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    }
}