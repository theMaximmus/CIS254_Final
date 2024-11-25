package com.maximmus.cis254_final;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Mail {
    private String username;
    private String name;
    private String recepientName;
    private String subject;
    private String bodyText;
    private String sentDate;

    private ArrayList<LocalDateTime> records = new ArrayList<LocalDateTime>();

    public Mail(User user) {
        this.username = user.getUsername();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.sentDate = myDateObj.format(myFormatObj);
        System.out.println(this.sentDate);
        records.add(myDateObj);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecepientName() {
        return recepientName;
    }

    public void setRecepientName(String recepientName) {
        this.recepientName = recepientName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }
}

enum Labels {
    Personal,
    Work,
    Advertisement;
}