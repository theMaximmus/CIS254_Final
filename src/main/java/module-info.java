module com.maximmus.cis254_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.maximmus.cis254_final to javafx.fxml;
    exports com.maximmus.cis254_final;
    exports com.maximmus.cis254_final.RegistrationWindow;
    opens com.maximmus.cis254_final.RegistrationWindow to javafx.fxml;
}