package com.csit228.quiz_app_practice.controller;

import com.csit228.quiz_app_practice.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.Normalizer;

public class LoginController {

    @FXML private TextField textFieldUsername;
    @FXML private PasswordField passwordFieldPassword;
    @FXML private TextField visiblePasswordField;
    @FXML private CheckBox checkboxShowPassword;
    @FXML private VBox rootContainer;
    @FXML private Label labelUsernameError;
    @FXML private Label labelPasswordError;

    private boolean submitted = false;

    @FXML
    public void initialize() {
        setupValidation();
        FormValidator.addPasswordValidation(
                passwordFieldPassword,
                visiblePasswordField,
                labelPasswordError,
                () -> submitted
        );

        Animator.playEntryAnimation(rootContainer, 200);
    }

    @FXML
    public void onClickedLogin(ActionEvent event) {
        boolean filledAllFields = true;

        submitted = true;

        if (FormValidator.isEmpty(textFieldUsername)) {
            FormValidator.showError(labelUsernameError, textFieldUsername, "Please enter a username!");
            filledAllFields = false;
        }

        if (FieldUtils.getPasswordText(passwordFieldPassword, visiblePasswordField, checkboxShowPassword).isEmpty()) {
            FormValidator.showError(labelPasswordError, passwordFieldPassword, "Please enter a password!");
            FormValidator.showError(labelPasswordError, visiblePasswordField, "Please enter a password!");
            filledAllFields = false;
        }

        if (filledAllFields) {
            System.out.println("LOGIN SUCCESSFULLY!");
        }
    }

    @FXML
    public void onClickedCreateAcc(ActionEvent event) throws IOException {
        Navigator.switchScreen(event, "/com/csit228/quiz_app_practice/register-starting-view.fxml", "Register Account");
    }

    @FXML
    public void onClickedShowPassword() {
        FieldUtils.setPasswordFieldVisibility(checkboxShowPassword, visiblePasswordField, passwordFieldPassword);
    }

    @FXML
    public void setupValidation() {
        FormValidator.missingFieldUIListener(
                textFieldUsername, labelUsernameError, () -> submitted
        );
    }


}
