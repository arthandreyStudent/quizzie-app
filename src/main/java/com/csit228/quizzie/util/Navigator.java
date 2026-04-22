package com.csit228.quizzie.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {

    public static FXMLLoader switchScreen(ActionEvent event, String path, String title) {
        try {
            FXMLLoader loader = ViewLoader.load(path);
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(scene);

            return loader;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
