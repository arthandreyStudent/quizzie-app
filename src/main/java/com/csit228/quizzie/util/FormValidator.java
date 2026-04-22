package com.csit228.quizzie.util;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

import java.util.function.BooleanSupplier;

public class FormValidator {

    public static void showError(Label label, TextInputControl field, String message) {
        label.setText(message);
        label.setVisible(true);
        label.setManaged(true);

        if (!field.getStyleClass().contains("registration-error-field")) {
            field.getStyleClass().add("registration-error-field");
        }
    }

    public static void clearError(Label label, TextInputControl field) {
        label.setVisible(false);
        label.setManaged(false);

        field.getStyleClass().remove("registration-error-field");
    }

    public static boolean isEmpty(TextInputControl field) {
        return field.getText().trim().isEmpty();
    }

    public static void missingFieldUIListener(
            TextInputControl field,
            Label errorLabel,
            BooleanSupplier isSubmitted
    ) {
        field.textProperty().addListener((obs, oldVal, newVal) -> {
            if (isSubmitted.getAsBoolean() && !newVal.trim().isEmpty()) {
                clearError(errorLabel, field);
            }
        });
    }

    public static void addPasswordValidation(
            PasswordField hiddenField,
            TextField visibleField,
            Label errorLabel,
            BooleanSupplier isSubmitted
    ) {
        Runnable clear = () -> {
            clearError(errorLabel, hiddenField);
            clearError(errorLabel, visibleField);
        };

        hiddenField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (isSubmitted.getAsBoolean() && !newVal.trim().isEmpty()) {
                clear.run();
            }
        });

        visibleField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (isSubmitted.getAsBoolean() && !newVal.trim().isEmpty()) {
                clear.run();
            }
        });

    }
}
