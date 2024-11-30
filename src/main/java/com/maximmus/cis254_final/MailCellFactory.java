package com.maximmus.cis254_final;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class MailCellFactory implements Callback<ListView<Mail>, ListCell<Mail>> {

    @Override
    public ListCell<Mail> call(ListView<Mail> param) {
        return new MailCell();
    }
}
