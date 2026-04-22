package com.csit228.quizzie.controller;

import com.csit228.quizzie.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class StudentRegistrationController {
    @FXML private Label labelPasswordError;
    @FXML private Label labelUsernameError;
    @FXML private Label labelLastNameError;
    @FXML private Label labelFirstNameError;
    @FXML private TextField textFieldFirstName;
    @FXML private TextField textFieldLastName;
    @FXML private TextField textFieldUsername;
    @FXML private PasswordField passwordFieldPassword;
    @FXML private TextField visiblePasswordField;
    @FXML private CheckBox checkboxShowPassword;
    @FXML private VBox rootContainer;

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
    public void onClickedShowPassword(ActionEvent event) {
        FieldUtils.setPasswordFieldVisibility(checkboxShowPassword, visiblePasswordField, passwordFieldPassword);
    }

    @FXML
    public void onClickedSignIn(ActionEvent event) {
        boolean filledAllFields = true;
        submitted = true;

        if (FormValidator.isEmpty(textFieldFirstName)) {
            FormValidator.showError(labelFirstNameError, textFieldFirstName, "This field cannot be empty!");
            filledAllFields = false;
        }

        if (FormValidator.isEmpty(textFieldLastName)) {
            FormValidator.showError(labelLastNameError, textFieldLastName, "This field cannot be empty!");
            filledAllFields = false;
        }

        if (FormValidator.isEmpty(textFieldUsername)) {
            FormValidator.showError(labelUsernameError, textFieldUsername, "This field cannot be empty!");
            filledAllFields = false;
        }

        if (FieldUtils.getPasswordText(passwordFieldPassword, visiblePasswordField, checkboxShowPassword).isEmpty()) {
            FormValidator.showError(labelPasswordError, passwordFieldPassword, "This field cannot be empty!");
            FormValidator.showError(labelPasswordError, visiblePasswordField, "This field cannot be empty!");
            filledAllFields = false;
        }

        if (filledAllFields) {
            Navigator.switchScreen(event, "/com/csit228/quizzie/registration-complete-view.fxml", "Registration Complete!");
        }
    }

    @FXML
    public void onClickedBack(ActionEvent event) throws IOException {
        Navigator.switchScreen(event, "/com/csit228/quizzie/register-starting-view.fxml", "Register Account");
    }

    private void setupValidation() {
        FormValidator.missingFieldUIListener(
                textFieldFirstName, labelFirstNameError, () -> submitted
        );

        FormValidator.missingFieldUIListener(
                textFieldLastName, labelLastNameError, () -> submitted
        );

        FormValidator.missingFieldUIListener(
                textFieldUsername, labelUsernameError, () -> submitted
        );
    }
}
