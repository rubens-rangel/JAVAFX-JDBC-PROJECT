package com.example.javafxjdbcproject.controller;


import com.example.javafxjdbcproject.db.DbException;
import com.example.javafxjdbcproject.listener.DataChangeListeners;
import com.example.javafxjdbcproject.model.entities.Department;
import com.example.javafxjdbcproject.model.services.DepartmentService;
import com.example.javafxjdbcproject.util.Alerts;
import com.example.javafxjdbcproject.util.Constraints;
import com.example.javafxjdbcproject.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DepartmentFormController implements Initializable {

    private Department entity;
    private DepartmentService service;
    private List<DataChangeListeners> dataChangeListeners = new ArrayList<>();

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
    public void onBtSaveAction(ActionEvent event) {
        if(entity == null){
            new IllegalStateException("Entity was null");
        }
        if(service == null){
            new IllegalStateException("Service was null");
        }
        try{
        entity = getFormData();
        service.saveOrUpdate(entity);
        notifyDataChangeListeners();
        Utils.currentStage(event).close();
    }catch (DbException e){
            Alerts.showAlert("Error saving object", null, e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void notifyDataChangeListeners() {
        for(DataChangeListeners listener : dataChangeListeners){
            listener.onDataChanged();
        }
    }

    @FXML
    public void onBtCancelAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    public  void setDepartment(Department entity){
        this.entity = entity;
    }

    public void setDepartmentService (DepartmentService service){
        this.service = service;
    }

    public void subscribeDataChangeListeners(DataChangeListeners listener){
        dataChangeListeners.add(listener);
    }

    private Department getFormData() {
        Department obj = new Department();

        obj.setId(Utils.tryParseToInt(txtId.getText()));
        obj.setName(txtName.getText());
        return obj;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }

    private void initializeNodes() {
        Constraints.setTextFieldInteger(txtId);
        Constraints.setTextFieldMaxLength(txtName, 30);
    }

    public void updateFormData(){
        txtId.setText(String.valueOf(entity.getId()));
        txtName.setText(entity.getName());
    }
 }
