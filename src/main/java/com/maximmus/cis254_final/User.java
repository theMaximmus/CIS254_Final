package com.maximmus.cis254_final;

import com.maximmus.cis254_final.CustomExceptions.EmptyPasswordException;
import com.maximmus.cis254_final.CustomExceptions.EmptyUsernameException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import com.maximmus.cis254_final.Mail;

public class User {
    private String username;
    private String address;
    private String password;

    private ArrayList<LocalDateTime> sentDates = new ArrayList<LocalDateTime>();

    private static ObservableList<User> userObservableList = FXCollections.observableArrayList();
//    private static ObservableList<Mail> messages = FXCollections.observableArrayList();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.address = username+"@mail.com";
        userObservableList.add(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String uername) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static ObservableList<User> getUserObservableList() {
        return userObservableList;
    }

//    public static ObservableList<Mail> getMessages() {
//        return messages;
//    }

}
