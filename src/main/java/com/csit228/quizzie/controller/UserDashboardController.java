package com.csit228.quizzie.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserDashboardController {

    @FXML private Label usernameLabel;
    @FXML private Label lastLoginLabel;
    @FXML private Label fullNameLabel;
    @FXML private Label userIdLabel;
    @FXML private Button logoutButton;

    @FXML
    private void onClickedLogout(ActionEvent event) {

    }
}
