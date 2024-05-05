package com.example.service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A controller class for the Login page.
 */
public class LoginController {

    @FXML
    private Button btnAuth;

    @FXML
    private Button btnBack;

    @FXML
    private TextField fldLogin;

    @FXML
    private PasswordField fldPass;

    /**
     * Switches back to a start page when the Back button is clicked.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void btnBackClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        Stage window = (Stage) btnBack.getScene().getWindow();
        window.setScene(new Scene(root));

    }

}
