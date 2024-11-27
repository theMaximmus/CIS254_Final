package com.maximmus.cis254_final;

import com.maximmus.cis254_final.AccountWindow.AccountWindowController;

import com.maximmus.cis254_final.MessageComposing.MessageComposeWindow;
import com.maximmus.cis254_final.RegistrationWindow.RegistrationWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private ListView<String> inboxListView = new ListView<>();

    @FXML
    private ListView<String> sentListView = new ListView<>();

    private boolean isFirstAccount = true;
    private boolean isRegistred = false;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Mail Application!");
    }

    @FXML
    protected void onComposeButtonClick() {
//        isRegistred = isRegistred();
        if (true) {
            TextArea recipientAddressTextArea = new TextArea();
            TextArea messageTextArea = new TextArea();
            MenuButton choiceButton = new MenuButton();
            MenuItem saveForLaterMenuItem = new MenuItem("Save for later");

            choiceButton.getItems().add(saveForLaterMenuItem);

            recipientAddressTextArea.setFont(new Font("Segoe UI", 16));
            messageTextArea.setFont(new Font("Segoe UI", 16));
            choiceButton.setText("Send");
            choiceButton.setFont(new Font("Segoe UI", 16));

            recipientAddressTextArea.setLayoutX(0);
            recipientAddressTextArea.setLayoutY(0);
            recipientAddressTextArea.setMinWidth(960);
            recipientAddressTextArea.setMinHeight(20);
            recipientAddressTextArea.setPrefHeight(20);

            messageTextArea.setLayoutX(0);
            messageTextArea.setLayoutY(20);
            messageTextArea.setMinWidth(960);
            messageTextArea.setMinHeight(500);

            choiceButton.setLayoutX(880);
            choiceButton.setLayoutY(520);
            choiceButton.setMinWidth(40);
            choiceButton.setMinHeight(40);


            choiceButton.setOnAction(event -> {
                // Implement your action for "Action 1" here
                System.out.println("Message sent");
            });

            saveForLaterMenuItem.setOnAction(event -> {
                // Implement your action for "Action 2" here
                System.out.println("Message was saved for later");
            });

            Stage newWindow = new Stage();
            newWindow.setTitle("Compose a message");

            // Set modality to make the new window a pop-up
            newWindow.initModality(Modality.APPLICATION_MODAL);

            // Create content for the new window
            AnchorPane composeLayout = new AnchorPane();
            composeLayout.getChildren().addAll(recipientAddressTextArea, messageTextArea, choiceButton);

            // Set the scene and display the new window
            Scene newScene = new Scene(composeLayout, 960, 560);
            newWindow.setScene(newScene);
            newWindow.show();
        } else {
            System.out.println("Failed to open the Message Composing window");
            System.out.println("Register an account first!");
            showMessage("Register an account first!", Alert.AlertType.ERROR);
        }
//        if (isRegistred) {
//            MessageComposeWindow messageComposeWindow = new MessageComposeWindow();
//            messageComposeWindow.showMessageComposeWindow();
//            System.out.println("Opened the Message Composing window");
//        } else {
//            System.out.println("Failed to open the Message Composing window");
//            System.out.println("Register an account first!");
//            showMessage("Register an account first!", Alert.AlertType.ERROR);
//        }
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