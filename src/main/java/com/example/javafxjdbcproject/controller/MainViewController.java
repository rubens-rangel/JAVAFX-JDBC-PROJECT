package com.example.javafxjdbcproject.controller;

import com.example.javafxjdbcproject.ProjectApplication;
import com.example.javafxjdbcproject.model.services.DepartmentService;
import com.example.javafxjdbcproject.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem about;

    @FXML
    private void onMenuItemSellerAction(){

    }

    @FXML
    private void onMenuItemDepartmentAction(){
        loadView2("DepartmentList.fxml");
    }

    @FXML
    private void onMenuItemAboutAction(){
        loadView("About.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private synchronized void loadView(String absoluteName){
        try {
            FXMLLoader loader = new FXMLLoader(ProjectApplication.class.getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = ProjectApplication.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

        } catch (IOException e) {
            Alerts.showAlert("IOException", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    private synchronized void loadView2(String absoluteName){
        try {
            FXMLLoader loader = new FXMLLoader(ProjectApplication.class.getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = ProjectApplication.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

            DepartmentListController controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        } catch (IOException e) {
            Alerts.showAlert("IOException", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
