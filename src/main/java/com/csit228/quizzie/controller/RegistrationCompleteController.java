package com.csit228.quizzie.controller;

import com.csit228.quizzie.util.Animator;
import com.csit228.quizzie.util.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class RegistrationCompleteController {

    @FXML private VBox rootContainer;

    @FXML
    public void initialize() {
        Animator.playEntryAnimation(rootContainer, 200);
    }

    @FXML
    public void onClickedBackToLogin(ActionEvent event) {
        Navigator.switchScreen(event, "/com/csit228/quizzie/login-view.fxml", "Quizzie - Login");
    }
}
