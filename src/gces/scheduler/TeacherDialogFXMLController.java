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
import java.sql.ResultSet;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author नमस्ते
 */
public class TeacherDialogFXMLController implements Initializable {

    @FXML
    private Button teacherDone;
    @FXML
    private TextField tName;
    @FXML
    private ComboBox<?> tSTime;
    @FXML
    private ComboBox<?> tETime;
    @FXML
    private ComboBox<?> tSubject;
    @FXML
    private CheckBox tType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList tTime =  FXCollections.observableArrayList(
                 "6:00",
                 "6:30",
                 "7:00",
                 "7:30",
                 "8:00",
                 "8:30",
                 "9:00",
                 "10:00",
                 "10:30",
                 "11:00"       
            );
        tSTime.setItems(tTime);
        tETime.setItems(tTime);
        
        DatabaseHandleSQLite dh = new DatabaseHandleSQLite();
        Connection conn = dh.connect();
        //database entry  here
        PreparedStatement pstmt = null;
        String qry = "SELECT `NAME` FROM `subjects`;";
        ObservableList dataT =  FXCollections.observableArrayList();
        ResultSet rs =null;
        try {
            pstmt = conn.prepareStatement(qry);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                dataT.add(rs.getString("NAME"));
                tSubject.setItems(dataT);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDialogFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dh.disconnect();
        
    }    

    @FXML
    private void teacherDone(ActionEvent event) {
        String tName = this.tName.getCharacters().toString();
        Boolean ttype = this.tType.isSelected();
        String tSubjectString ="";
        String tendTimeString ="";
        String tStartTimeString="";
        try {
        tendTimeString = tETime.getSelectionModel().getSelectedItem().toString();
        } catch (NullPointerException e) {
            System.out.println("null pointer");
        }
        try {
        tStartTimeString =tSTime.getSelectionModel().getSelectedItem().toString();
        } catch (NullPointerException e) {
            System.out.println("null pointer");
        }
        try {
            tSubjectString = tSubject.getSelectionModel().getSelectedItem().toString();
        } catch (NullPointerException e) {
            System.out.println("Null Pointer");
        }
        try {
            DatabaseHandleSQLite dh = new DatabaseHandleSQLite();
            Connection conn = dh.connect();
            //database entry  here
            PreparedStatement pstmt = null;
            String qry = "INSERT INTO `teachers`(`NAME`, `FULLTIME`, `TSTART`, `TEND`, `SUBJECT`)"
                    + " VALUES('"+tName+"', '"+ttype+"', '"+tStartTimeString+"', '"+tendTimeString+"', '"+tSubjectString+"');";
            pstmt = conn.prepareStatement(qry);
            pstmt.executeUpdate();
            dh.disconnect();
            this.tName.clear();
            tSubject.setValue(null);
            tETime.setValue(null);
            tSTime.setValue(null);
        } catch (SQLException e) {
        }
    }
    
}
