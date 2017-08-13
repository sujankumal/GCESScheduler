/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author नमस्ते
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Menu teachers;
    @FXML
    private MenuItem teacherAdd;
    @FXML
    private Menu classes;
    @FXML
    private Menu subjects;
    @FXML
    private MenuItem addClass;
    @FXML
    private StackPane stackPane;
    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem menuClose;
    @FXML
    private MenuItem addSubject;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private StackPane stackpane;

    @FXML
    private void teacherAdd(ActionEvent event) throws IOException {
       /* Dialog dialog =new Dialog();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setHeaderText("hello");
        dialog.setHeight(100);
        dialog.setWidth(100);
        dialog.show();
        */
       final Stage dialog = new Stage();
       dialog.setTitle("teacher dialog");
       Parent root = FXMLLoader.load(getClass().getResource("teacherDialogFXML.fxml"));
       Scene dialogScene = new Scene(root, 500, 400);
       dialogScene.getStylesheets().add(getClass().getResource("teacherdialogfxml.css").toExternalForm());
       dialog.setScene(dialogScene);
       dialog.show();
        
    }

    @FXML
    private void addClass(ActionEvent event) throws IOException {
       
       final Stage dialog = new Stage();
       dialog.setTitle("class dialog");
       Parent root = FXMLLoader.load(getClass().getResource("ClassDialogFXML.fxml"));
       Scene dialogScene = new Scene(root, 500, 400);
       dialogScene.getStylesheets().add(getClass().getResource("classdialogfxml.css").toExternalForm());
       dialog.setScene(dialogScene);
       dialog.show();
    }

    @FXML
    private void menuClose(ActionEvent event) {
        System.exit(0);
    } 

    @FXML
    private void addSubject(ActionEvent event) throws IOException {
       final Stage dialog = new Stage();
       dialog.setTitle("Subject dialog");
       Parent root = FXMLLoader.load(getClass().getResource("subjectDialogFXML.fxml"));
       Scene dialogScene = new Scene(root, 500, 400);
       dialogScene.getStylesheets().add(getClass().getResource("subjectdialogfxml.css").toExternalForm());
       dialog.setScene(dialogScene);
       dialog.show();
    }
}
