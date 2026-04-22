package com.csit228.quiz_app_practice.controller;

import com.csit228.quiz_app_practice.util.Animator;
import com.csit228.quiz_app_practice.util.Navigator;
import com.csit228.quiz_app_practice.util.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class RegisterStartingController {

    @FXML private VBox studentCard;
    @FXML private VBox teacherCard;
    @FXML private Button buttonContinue;
    @FXML private VBox rootContainer;

    private int selectedCard;   // 1 for Student, 2 for Teacher

    @FXML
    public void initialize() {
        buttonContinue.setDisable(true);
        Animator.playEntryAnimation(rootContainer, 200);
    }

    @FXML
    public void onStudentClicked() {
//        System.out.println("Student Clicked");
        selectedCard = 1;
        selectCard(studentCard, teacherCard);
    }

    @FXML
    public void onTeacherClicked() {
//        System.out.println("Teacher Clicked");
        selectedCard = 2;
        selectCard(teacherCard, studentCard);
    }

    @FXML
    public void onClickedContinue(ActionEvent event) throws IOException {
        if (selectedCard == 1) {
            Navigator.switchScreen(event, "/com/csit228/quiz_app_practice/student-registration-view.fxml", "Student Registration");
        } else {
            Navigator.switchScreen(event, "/com/csit228/quiz_app_practice/teacher-registration-view.fxml", "Teacher Registration");
        }
    }

    @FXML
    public void onClickedBack(ActionEvent event) throws IOException {
        Navigator.switchScreen(event, "/com/csit228/quiz_app_practice/login-view.fxml", "Login");
    }

    private void selectCard(VBox selected, VBox other) {
        selected.getStyleClass().remove("selected");
        other.getStyleClass().remove("selected");

        selected.getStyleClass().add("selected");
        buttonContinue.setDisable(false);
    }
}
