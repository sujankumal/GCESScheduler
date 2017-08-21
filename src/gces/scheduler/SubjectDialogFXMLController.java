/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import gces.scheduler.database.DatabaseHandleSQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * FXML Controller class
 *
 * @author नमस्ते
 */
public class SubjectDialogFXMLController implements Initializable {

    @FXML
    private TextField subName;
    @FXML
    private Button subjectDone;
    @FXML
    private ComboBox<?> subClass;
    @FXML
    private ComboBox<?> subTeacher;
    @FXML
    private CheckBox subLab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            subLab.setIndeterminate(false);
            DatabaseHandleSQLite dbhs = new DatabaseHandleSQLite();
            Connection conn = dbhs.connect();
            ResultSet rs=null;
            PreparedStatement pStmt = null;
            String qry ="SELECT `SEMESTER` FROM `class`";
            String qryT = "SELECT `NAME` FROM `teachers`";
            ObservableList data =  FXCollections.observableArrayList();
            ObservableList dataT =  FXCollections.observableArrayList();
            pStmt = conn.prepareStatement(qry);
            rs = pStmt.executeQuery();
            while (rs.next()) {
                data.add(rs.getString("SEMESTER"));
                subClass.setItems(data);
            }
            pStmt = conn.prepareStatement(qryT);
            rs = pStmt.executeQuery();
            while(rs.next()){
                dataT.add(rs.getString("NAME"));
                subTeacher.setItems(dataT);
            }
            dbhs.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDialogFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void subjectDone(ActionEvent event) {      
            String name = subName.getCharacters().toString();
            String subClassString = "";
            String subTeacherString = "";
            try {
            subTeacherString = subTeacher.getSelectionModel().getSelectedItem().toString();
            } catch (NullPointerException e) {
                    System.out.println("Null pointer subTeacher"+e.getMessage());
            }
            try {
            subClassString = subClass.getSelectionModel().getSelectedItem().toString();
            } catch (NullPointerException e) {
                System.out.println("Null pinter SubClass"+e.getMessage());
            }
            Boolean lab = subLab.isSelected();
            //add to database subject table
        try {    
            DatabaseHandleSQLite dh = new DatabaseHandleSQLite();
            Connection conn = dh.connect();
            //database entry  here
            PreparedStatement pstmt = null;
            String qry = "INSERT INTO `subjects`(`NAME`, `TEACHER`, `ISLABREQ`, `CLASS`)"
                    + " VALUES('"+name+"', '"+subTeacherString+"', '"+lab+"', '"+subClassString+"');";
            pstmt = conn.prepareStatement(qry);
            pstmt.executeUpdate();
            dh.disconnect();
            
            subTeacher.setValue(null);
            subClass.setValue(null);
            subName.clear();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDialogFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
