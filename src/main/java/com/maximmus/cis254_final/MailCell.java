package com.maximmus.cis254_final;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class MailCell extends ListCell<Mail> {

    @FXML
    private Label messageLabel;

    @FXML
    private Label senderLabel;

    @FXML
    private Label timestampLabel;

    @FXML
    private AnchorPane anchorPane;


    public MailCell() {
        super();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("message-preview.fxml"));
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(Mail message, boolean empty) {
        super.updateItem(message, empty);

        if (empty || message == null) {
            setText(null);
            setGraphic(null);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("message-preview.fxml"));
            loader.setController(this);

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            senderLabel.setText(message.getUsername());
            messageLabel.setText(message.getSubject());
            timestampLabel.setText(message.getSentDate());

//            System.out.println(anchorPane.getChildren());
//            System.out.println(anchorPane.getProperties());
            setText(null);
            setGraphic(anchorPane);
        }

//        if(student.getGender().equals(Student.GENDER.MALE)) {
//            fxIconGender.setIcon(FontAwesomeIcon.MARS);
//        } else if(student.getGender().equals(Student.GENDER.FEMALE)) {
//            fxIconGender.setIcon(FontAwesomeIcon.VENUS);
//        } else {
//            fxIconGender.setIcon(FontAwesomeIcon.GENDERLESS);
//        }
    }


}
