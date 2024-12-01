package com.maximmus.cis254_final;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Mail {
    private String username;
    private String address;
    private String recepientName;
    private String subject;
    private String bodyText;
    private String sentDate;

    private int number;

    private Labels label;

    static int orderNumber = 0;

    private ArrayList<LocalDateTime> records = new ArrayList<LocalDateTime>();

    public Mail(User user, String recepientName, String bodyText) {
        this.username = user.getUsername();
        this.label = Labels.Personal;

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.sentDate = myDateObj.format(myFormatObj);
        System.out.println(this.sentDate);
        records.add(myDateObj);

        this.number = orderNumber;
        orderNumber++;
    }

    public Mail (String username, String address, String recepientName, String subject, String bodyText, Labels label) {
        this.username = username;
        this.address = address;
        this.recepientName = recepientName;
        this.subject = subject;
        this.bodyText = bodyText;
        this.label = label;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.sentDate = myDateObj.format(myFormatObj);
        records.add(myDateObj);
        System.out.println("Generated message at " + this.sentDate);

        this.number = orderNumber;
        orderNumber++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", recepientName='" + recepientName + '\'' +
                ", subject='" + subject + '\'' +
                ", bodyText='" + bodyText + '\'' +
                ", sentDate='" + sentDate + '\'' +
                ", records=" + records +
                '}';
    }

    public Labels getLabel() {
        return label;
    }
}

enum Labels {
    Personal,
    Work,
    None
}