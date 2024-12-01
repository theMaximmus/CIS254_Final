package com.maximmus.cis254_final;

import com.maximmus.cis254_final.AccountWindow.AccountWindowController;

import com.maximmus.cis254_final.MessageView.MessageViewWindow;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.maximmus.cis254_final.RegistrationWindow.RegistrationWindowController.isRegistred;
import static com.maximmus.cis254_final.User.getUserObservableList;

public class MailController implements Initializable {
    @FXML
    private Button composeButton;
    @FXML
    private Button deleteMessageButton;
    @FXML
    private Button openButton;
    @FXML
    private Circle userIconCircle;

    @FXML
    private TabPane tabPane;

    @FXML
    private ListView<Mail> draftListView = new ListView<>();

    @FXML
    private ListView<Mail> inboxListView = new ListView<Mail>();

    @FXML
    private ListView<Mail> sentListView = new ListView<>();

    private boolean isFirstAccount = true;
    private boolean isRegistred = false;

    private static ObservableList<Mail> inboxMessages;
    private static ObservableList<Mail> sentMessages;
    private static ObservableList<Mail> draftMessages;
    public MailController() {
        // creating the inboxes
        inboxMessages = FXCollections.observableArrayList();
        sentMessages = FXCollections.observableArrayList();
        draftMessages = FXCollections.observableArrayList();

        // adding custom welcoming messages
        inboxMessages.add(new Mail("Admin", "", "Welcome!", "Welocme to the program!", Labels.Personal));
        inboxMessages.add(new Mail("Admin", "", "How to use this program", "It is simple", Labels.Personal));
        // adding test messages
        sentMessages.add(new Mail("Admin", "", "The Sent messages tab", "This is where your sent messages are stored and displayed", Labels.Personal));
        draftMessages.add(new Mail("Admin", "", "The Draft messages tab", "This is where your drafts are stored and displayed", Labels.Personal));
        System.out.println("Generated default messages");
    }

    @FXML
    protected void onOpenButtonClick() {
        // get selected message
        Mail mail = inboxListView.getSelectionModel().getSelectedItem();

        // set the layout items
        AnchorPane anchorPane = new AnchorPane();
        Label senderNameLabel = new Label();
        Label senderAddressLabel = new Label();
        Label messageLabel = new Label();
        Label timestampLabel = new Label();
        Label messageSubject = new Label();
        Circle userIconCircle = new Circle();

        senderNameLabel.setFont(new Font("Segoe UI", 14));
        senderAddressLabel.setFont(new Font("Segoe UI Bold", 16));
        messageLabel.setFont(new Font("Segoe UI", 16));
        timestampLabel.setFont(new Font("Segoe UI", 14));
        messageSubject.setFont(new Font("Segoe UI Bold", 16));

        Image image = new Image(getClass().getResourceAsStream("/com/maximmus/cis254_final/user_icon.png"));
        userIconCircle.setFill(new ImagePattern(image));
        userIconCircle.setRadius(20);

        // Setting the proper layout
        senderNameLabel.setLayoutX(100);
        senderNameLabel.setLayoutY(110);
        senderAddressLabel.setLayoutX(220);
        senderAddressLabel.setLayoutY(110);
        messageLabel.setLayoutX(140);
        messageLabel.setLayoutY(250);
        timestampLabel.setLayoutX(1040);
        timestampLabel.setLayoutY(110);
        messageSubject.setLayoutX(100);
        messageSubject.setLayoutY(40);
        userIconCircle.setLayoutX(60);
        userIconCircle.setLayoutY(120);

        // set the desired layout sizes
        senderNameLabel.setMinHeight(60);
        senderNameLabel.setMinWidth(20);
        senderAddressLabel.setMinHeight(20);
        senderAddressLabel.setMinWidth(60);
        messageLabel.setMinHeight(Region.USE_COMPUTED_SIZE);
        messageLabel.setMinWidth(1000);
        timestampLabel.setMinHeight(20);
        timestampLabel.setMinWidth(80);
        messageSubject.setMinHeight(40);
        messageSubject.setMinWidth(1040);

        // adding all items to the root pane
        anchorPane.getChildren().addAll(senderAddressLabel, senderNameLabel, messageLabel, timestampLabel, messageSubject, userIconCircle);

        // mapping the text from the message
        messageLabel.setText(mail.getBodyText());
        timestampLabel.setText(mail.getSentDate());
        messageSubject.setText(mail.getSubject());
        senderNameLabel.setText(mail.getName());
        senderAddressLabel.setText(mail.getUsername());

        Stage newWindow = new Stage();
        newWindow.setTitle("Message: " + mail.getSubject());

        // Set the modality so that the newly created window covers all other ones
        newWindow.initModality(Modality.APPLICATION_MODAL);

        // Set the scene and display the new window
        Scene newScene = new Scene(anchorPane, 1180, 680);
        newWindow.setScene(newScene);
        newWindow.show();
        System.out.println("Opened a message");
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
                User user = null;
                if (!getUserObservableList().isEmpty()) {
                    user = getUserObservableList().get(0);
                }
                Mail message = new Mail(user, recipientAddressTextArea.getText(), messageTextArea.getText());
                inboxMessages.add(0, message);
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

        // adding user icon
        Image image = new Image(getClass().getResourceAsStream("/com/maximmus/cis254_final/user_icon.png"));
        userIconCircle.setFill(new ImagePattern(image));

        // Handle the click event on the User Icon circle
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

                if (!getUserObservableList().isEmpty()) {
                    AccountWindowController controller = loader.getController();
                    // Assuming you want the first user in the list:
                    User user = getUserObservableList().get(0); // Replace with actual logic
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


        // Setting up the inboxListView
        inboxListView.setItems(inboxMessages);
        inboxListView.setCellFactory(mailListView -> new MailCell());
        inboxListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        System.out.println(inboxListView.getItems());

        // Setting up the draftListView
        draftListView.setItems(draftMessages);
        draftListView.setCellFactory(draftListView -> new MailCell());
        draftListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Setting up the sentListView
        sentListView.setItems(sentMessages);
        sentListView.setCellFactory(sentListView -> new MailCell());
        sentListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Creating the "Delete" button and setting up the logic for it
        Image trashImage = new Image(getClass().getResourceAsStream("/com/maximmus/cis254_final/trash_icon.png"));
        ImageView trashImageView = new ImageView(trashImage);
        trashImageView.setFitHeight(20);
        trashImageView.setFitWidth(20);
        trashImageView.setPreserveRatio(true);
        deleteMessageButton.setGraphic(trashImageView);
        deleteMessageButton.setOnMouseClicked(mouseEvent -> {
            Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
            if (Objects.equals(selectedTab.getText(), "Inbox")) {
                inboxMessages.remove(inboxListView.getSelectionModel().getSelectedItem());
            } else if (Objects.equals(selectedTab.getText(), "Drafts")) {
                draftMessages.remove(draftListView.getSelectionModel().getSelectedItem());
            } else if (Objects.equals(selectedTab.getText(), "Sent")) {
                sentMessages.remove(sentListView.getSelectionModel().getSelectedItem());
            }
            System.out.println("Deleted selected messages");
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