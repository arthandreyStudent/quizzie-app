package com.csit228.quiz_app_practice.util;

import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FieldUtils {

    public static void setPasswordFieldVisibility(
            CheckBox checkbox,
            TextField visibleField,
            PasswordField hiddenField) {
        if (checkbox.isSelected()) {
            visibleField.setText(hiddenField.getText());

            visibleField.setVisible(true);
            visibleField.setManaged(true);

            hiddenField.setVisible(false);
            hiddenField.setManaged(false);

            visibleField.getStyleClass().setAll(hiddenField.getStyleClass());
        } else {
            hiddenField.setText(visibleField.getText());

            hiddenField.setVisible(true);
            hiddenField.setManaged(true);

            visibleField.setVisible(false);
            visibleField.setManaged(false);

            hiddenField.getStyleClass().setAll(visibleField.getStyleClass());
        }
    }

    public static String getPasswordText(
            PasswordField hiddenField,
            TextField visibleField,
            CheckBox checkbox
    ) {
        if (checkbox.isSelected()) {
            return visibleField.getText();
        }
        return hiddenField.getText();
    }
}
