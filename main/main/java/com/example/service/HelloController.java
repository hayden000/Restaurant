package com.example.service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * A controller class for the start page.
 */
public class HelloController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button btnHelp;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnLogin;


    @FXML
    void btnHelpClicked(ActionEvent event) {
        System.out.println("Help");
    }

    /**
     * Switches to a login page when the Staff login button is clicked.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void btnLoginClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Stage window = (Stage) btnLogin.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Switches to the Main Menu page when the Start Order button is clicked.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void btnStartClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Stage window = (Stage) btnLogin.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    void initialize() {
        btnHelp.setOnMouseMoved(m->{
            System.out.println("Button is being hovered");
        });
    }
}