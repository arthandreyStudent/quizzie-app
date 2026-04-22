package com.csit228.quizzie.util;

import javafx.fxml.FXMLLoader;

public class ViewLoader {
    public static FXMLLoader load(String path) {
        return new FXMLLoader(ViewLoader.class.getResource(path));
    }
}
