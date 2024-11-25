package com.maximmus.cis254_final;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public static void registerAnAccount(String username, String password) throws EmptyUsernameException, EmptyPasswordException {
        if (username.isEmpty() || username == null) {
            throw new EmptyUsernameException();
        }
        if (password.isEmpty() || password == null) {
            throw new EmptyPasswordException();
        }
        User user = new User(username, password);
    }
}
