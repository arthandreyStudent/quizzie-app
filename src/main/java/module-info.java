module com.csit228.quiz_app_practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.sql;
    requires javafx.graphics;
    requires java.desktop;

    opens com.csit228.quiz_app_practice to javafx.fxml;
    exports com.csit228.quiz_app_practice.util;
    opens com.csit228.quiz_app_practice.util to javafx.fxml;
    exports com.csit228.quiz_app_practice.main;
    opens com.csit228.quiz_app_practice.main to javafx.fxml;
    exports com.csit228.quiz_app_practice.controller;
    opens com.csit228.quiz_app_practice.controller to javafx.fxml;
    exports com.csit228.quiz_app_practice.model;
    opens com.csit228.quiz_app_practice.model to javafx.fxml;
    exports com.csit228.quiz_app_practice.dao;
    opens com.csit228.quiz_app_practice.dao to javafx.fxml;
//    exports com.csit228.quiz_app_practice.service;
//    opens com.csit228.quiz_app_practice.service to javafx.fxml;
}