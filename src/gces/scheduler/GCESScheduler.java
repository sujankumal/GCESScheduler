/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author à¤¨à¤®à¤¸à¥�à¤¤à¥‡
 */
public class GCESScheduler extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("cascadeSS/GCESStyle.css").toExternalForm());
        stage.setTitle("GCES Scheduler");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}//College.Sujan.98468
