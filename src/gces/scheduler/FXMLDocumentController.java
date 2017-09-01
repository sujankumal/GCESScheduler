/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;


import gces.scheduler.database.DatabaseHandleSQLite;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
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
    @FXML
    private Menu schedule;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       DatabaseHandleSQLite dbsqlite = new DatabaseHandleSQLite("initialize table"); 
       System.out.println(dbsqlite.toString());
       dbsqlite.disconnect();
    }    
    @FXML
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
       Parent root = FXMLLoader.load(getClass().getResource("gui/teacherDialogFXML.fxml"));
       Scene dialogScene = new Scene(root, 500, 400);
       dialogScene.getStylesheets().add(getClass().getResource("cascadeSS/teacherdialogfxml.css").toExternalForm());
       dialog.setScene(dialogScene);
       dialog.show();
        
    }

    @FXML
    private void addClass(ActionEvent event) throws IOException {
       
       final Stage dialog = new Stage();
       dialog.setTitle("class dialog");
       Parent root = FXMLLoader.load(getClass().getResource("gui/ClassDialogFXML.fxml"));
       Scene dialogScene = new Scene(root, 500, 400);
       dialogScene.getStylesheets().add(getClass().getResource("cascadeSS/classdialogfxml.css").toExternalForm());
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
       Parent root = FXMLLoader.load(getClass().getResource("gui/subjectDialogFXML.fxml"));
       Scene dialogScene = new Scene(root, 500, 400);
       dialogScene.getStylesheets().add(getClass().getResource("cascadeSS/subjectdialogfxml.css").toExternalForm());
       dialog.setScene(dialogScene);
       dialog.show();
    }

    @FXML
    private void generate(ActionEvent event) throws IOException {
        MainScheduleTaskFrame schedule = new MainScheduleTaskFrame();
        
        stackpane.getChildren().add(schedule.generate());
    
    }
}
