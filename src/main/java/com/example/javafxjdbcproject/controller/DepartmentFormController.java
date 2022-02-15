package com.example.javafxjdbcproject.controller;


import com.example.javafxjdbcproject.ProjectApplication;
import com.example.javafxjdbcproject.model.entities.Department;
import com.example.javafxjdbcproject.model.services.DepartmentService;
import com.example.javafxjdbcproject.util.Alerts;
import com.example.javafxjdbcproject.util.Constraints;
import com.example.javafxjdbcproject.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DepartmentFormController implements Initializable {

    private DepartmentService service;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private Label labelErrorName;

    @FXML
    private Button btSave;

    @FXML
    private Button btCancel;


    @FXML
    public void onBtSaveAction() {
        System.out.println("aa");
    }
    @FXML
    public void onBtCancelAction() {
        System.out.println("bb");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }

    private void initializeNodes() {
        Constraints.setTextFieldInteger(txtId);
        Constraints.setTextFieldMaxLength(txtName, 30);
    }
 }
