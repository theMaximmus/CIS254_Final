package com.maximmus.cis254_final;

import com.maximmus.cis254_final.AccountWindow.AccountWindowController;

import com.maximmus.cis254_final.RegistrationWindow.RegistrationWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.maximmus.cis254_final.MailCellFactory;
import javafx.util.Callback;

import static com.maximmus.cis254_final.RegistrationWindow.RegistrationWindowController.isRegistred;

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
    private ListView<Mail> inboxListView = new ListView<Mail>();

    @FXML
    private ListView<String> sentListView = new ListView<>();

    private boolean isFirstAccount = true;
    private boolean isRegistred = false;

    private static ObservableList<Mail> messages;
    public MailController() {
        messages = FXCollections.observableArrayList();
        messages.add(new Mail("Admin", "", "Welcome!", "Welocme to the program!"));
        messages.add(new Mail("Admin", "", "How to use this program", "It is simple"));
        System.out.println("Generated defaul messages");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Mail Application!");
    }

    @FXML
    protected void onComposeButtonClick() {
        isRegistred = isRegistred();
        if (isRegistred) {
            TextArea recipientAddressTextArea = new TextArea();
            TextArea messageTextArea = new TextArea();
            MenuButton choiceButton = new MenuButton();
            MenuItem saveForLaterMenuItem = new MenuItem("Save for later");
            MenuItem sendMenuItem = new MenuItem("Send");

            choiceButton.getItems().addAll(sendMenuItem, saveForLaterMenuItem);

            recipientAddressTextArea.setFont(new Font("Segoe UI", 14));
            messageTextArea.setFont(new Font("Segoe UI", 16));
            choiceButton.setText("Send");
            choiceButton.setFont(new Font("Segoe UI", 16));

            recipientAddressTextArea.setLayoutX(0);
            recipientAddressTextArea.setLayoutY(0);
            recipientAddressTextArea.setMinWidth(960);
            recipientAddressTextArea.setMinHeight(20);
            recipientAddressTextArea.setPrefHeight(20);
            recipientAddressTextArea.setPromptText("Recepient address");

            messageTextArea.setLayoutX(0);
            messageTextArea.setLayoutY(20);
            messageTextArea.setMinWidth(960);
            messageTextArea.setMinHeight(500);
            messageTextArea.setPromptText("Message");

            choiceButton.setLayoutX(880);
            choiceButton.setLayoutY(520);
            choiceButton.setMinWidth(40);
            choiceButton.setMinHeight(40);


            Stage newWindow = new Stage();
            newWindow.setTitle("Compose a message");

            // Set modality to make the new window a pop-up
            newWindow.initModality(Modality.APPLICATION_MODAL);

            // Create content for the new window
            AnchorPane composeLayout = new AnchorPane();
            composeLayout.getChildren().addAll(recipientAddressTextArea, messageTextArea, choiceButton);

            sendMenuItem.setOnAction(event -> {
                // Implement your action for "Action 1" here
                System.out.println("Message sent");
                newWindow.close();
            });

            saveForLaterMenuItem.setOnAction(event -> {
                // Implement your action for "Action 2" here
                System.out.println("Message was saved for later");
                newWindow.close();
            });

            // Set the scene and display the new window
            Scene newScene = new Scene(composeLayout, 960, 560);
            newWindow.setScene(newScene);
            newWindow.show();
        } else {
            System.out.println("Failed to open the Message Composing window");
            System.out.println("Register an account first!");
            showMessage("Register an account first!", Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Mail[] list = {"Java", "Stalker", "MB?????"};
//        inboxListView.getItems().addAll(list);
//        draftListView.getItems().addAll(list);
//        sentListView.getItems().addAll(list);


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


        inboxListView.setItems(messages);
        inboxListView.setCellFactory(mailListView -> new MailCell());

        System.out.println(inboxListView.getItems());

    }

    /**
     * Displays a pop-up window with a desired message and AlertType
     * @param message Your custom message
     * @param alertType Your custom AlertType
     */
    private void showMessage(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Message");
        alert.setContentText(message);
        alert.showAndWait();
    }

}