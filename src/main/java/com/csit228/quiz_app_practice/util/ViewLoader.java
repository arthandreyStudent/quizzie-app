package com.csit228.quiz_app_practice.util;

import javafx.fxml.FXMLLoader;

public class ViewLoader {
    public static FXMLLoader load(String path) {
        return new FXMLLoader(ViewLoader.class.getResource(path));
    }
}
