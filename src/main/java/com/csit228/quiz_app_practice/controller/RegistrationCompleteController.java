package com.csit228.quiz_app_practice.controller;

import com.csit228.quiz_app_practice.util.Animator;
import com.csit228.quiz_app_practice.util.Navigator;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class RegistrationCompleteController {

    @FXML private VBox rootContainer;

    @FXML
    public void initialize() {
        Animator.playEntryAnimation(rootContainer, 200);
    }

    @FXML
    public void onClickedBackToLogin(ActionEvent event) {
        Navigator.switchScreen(event, "/com/csit228/quiz_app_practice/login-view.fxml", "Quizzie - Login");
    }
}
