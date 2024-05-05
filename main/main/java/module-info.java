module com.example.service {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.service to javafx.fxml;
    exports com.example.service;

    requires java.sql;

}