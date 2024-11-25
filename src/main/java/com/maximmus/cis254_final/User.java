package com.maximmus.cis254_final;

import com.maximmus.cis254_final.CustomExceptions.EmptyPasswordException;
import com.maximmus.cis254_final.CustomExceptions.EmptyUsernameException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.LinkedList;

public class User {
    private String username;
    private String password;

    private static ObservableList<User> userObservableList = FXCollections.observableArrayList();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userObservableList.add(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
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
}
