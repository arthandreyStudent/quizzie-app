module com.csit228.quizzie {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.sql;
    requires javafx.graphics;
    requires java.desktop;

    opens com.csit228.quizzie to javafx.fxml;
    exports com.csit228.quizzie.util;
    opens com.csit228.quizzie.util to javafx.fxml;
    exports com.csit228.quizzie.main;
    opens com.csit228.quizzie.main to javafx.fxml;
    exports com.csit228.quizzie.controller;
    opens com.csit228.quizzie.controller to javafx.fxml;
    exports com.csit228.quizzie.model;
    opens com.csit228.quizzie.model to javafx.fxml;
    exports com.csit228.quizzie.dao;
    opens com.csit228.quizzie.dao to javafx.fxml;
//    exports com.csit228.quizzie.service;
//    opens com.csit228.quizzie.service to javafx.fxml;
}