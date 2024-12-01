package com.maximmus.cis254_final.MessageView;

import com.maximmus.cis254_final.Mail;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageViewWindowController implements Initializable {

    @FXML
    private Circle senderIconCircle;

    @FXML
    private Label senderNameLabel;

    @FXML
    private Label senderAddressLabel;

    @FXML
    private Label timestampLabel;

    @FXML
    private Label messageLabel;

    @FXML
    private Label messageSubject;

    @FXML
    private AnchorPane anchorPane;

    private Mail message;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        messageSubject.setText(message.getSubject());
    }

    public void setMessage(Mail message) {
        this.message = message;
    }
}
