module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxjdbcproject to javafx.fxml;
    opens com.example.javafxjdbcproject.model.entities to javafx.fxml;

    exports com.example.javafxjdbcproject;
    exports com.example.javafxjdbcproject.model.entities;

    exports com.example.javafxjdbcproject.controller;
    opens com.example.javafxjdbcproject.controller to javafx.fxml;
}