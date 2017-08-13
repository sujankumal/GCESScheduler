/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


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
    private MenuItem mClose;
    
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
    private void teacherAdd(ActionEvent event) {
        Dialog dialog =new Dialog();
        ButtonType buttonTypeCancel = new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setHeaderText("hello");
        dialog.setHeight(100);
        dialog.setWidth(100);
        dialog.show();
        
        
    }

    @FXML
    private void addClass(ActionEvent event) {
        Dialog dialog =new Dialog();
        dialog.setHeaderText("hello");
        dialog.setHeight(100);
        dialog.setWidth(100);
        dialog.showAndWait();
        
    }

    @FXML
    private void menuClose(ActionEvent event) {
        System.exit(0);
    } 
}
