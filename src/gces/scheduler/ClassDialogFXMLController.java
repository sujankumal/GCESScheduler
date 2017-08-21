/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;

import gces.scheduler.database.DatabaseHandleSQLite;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;

/**
 * FXML Controller class
 *
 * @author नमस्ते
 */
public class ClassDialogFXMLController implements Initializable {

    @FXML
    private Button classDone;
    @FXML
    private ComboBox<?> semesterCBox;
    @FXML
    private ComboBox<?> semPeriod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList osemitem =  FXCollections.observableArrayList(
            "1st sem",
            "2nd sem",
            "3rd sem",
            "4th sem",
            "5th sem",
            "6th sem",
            "7th sem",
            "8th sem"
            );
        ObservableList semPeriodNo =  FXCollections.observableArrayList(
            1,2,3,4,5,6
            );
        semesterCBox.setItems(osemitem);  
        semPeriod.setItems(semPeriodNo);
    }    

    @FXML
    private void classDone(ActionEvent event) {
        String semester = semesterCBox.getSelectionModel().getSelectedItem().toString();
        String periodn = semPeriod.getSelectionModel().getSelectedItem().toString();
        DatabaseHandleSQLite dh = new DatabaseHandleSQLite();
        Connection conn = dh.connect();
        //database entry  here
        PreparedStatement pstmt = null;
        String qry = "INSERT INTO `class`(`SEMESTER`, `PERIODNO`) VALUES('"+semester+"', '"+periodn+"')";
        try {
            pstmt = conn.prepareStatement(qry);
        } catch (SQLException ex) {
            Logger.getLogger(ClassDialogFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDialogFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dh.disconnect();
        semPeriod.setValue(null);
        semesterCBox.setValue(null);
    }
    
}
