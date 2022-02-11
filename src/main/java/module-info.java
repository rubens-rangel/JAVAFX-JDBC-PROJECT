module com.example.javafxjdbcproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxjdbcproject to javafx.fxml;
    exports com.example.javafxjdbcproject;
    exports com.example.javafxjdbcproject.controller;
    opens com.example.javafxjdbcproject.controller to javafx.fxml;
}