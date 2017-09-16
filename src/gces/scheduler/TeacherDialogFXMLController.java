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
    private ComboBox<?> tSubject;
    @FXML
    private CheckBox tType;
    @FXML
    private ComboBox<?> tSubject1;
    @FXML
    private ComboBox<?> tSubject2;
    
       private Integer period1=0;
       private Integer period2=0;
       private Integer period3=0;
       private Boolean ttype;
       private Boolean tSubLab11;
       private Boolean tSubLab22;
       private Boolean tSubLab33;
    @FXML
    private ComboBox<?> teacherPeriod1;
    @FXML
    private ComboBox<?> teacherPeriod11;
    @FXML
    private ComboBox<?> teacherPeriod12;
    @FXML
    private CheckBox tSubLab1;
    @FXML
    private CheckBox tSubLab2;
    @FXML
    private CheckBox tSubLab3;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        // this is for choosing which which period
        ObservableList teacherPeriodObservableList = (ObservableList<Integer>) FXCollections.observableArrayList(1,2,3,4,5,6);
        
        ObservableList subjects = FXCollections.observableArrayList(
        "Eng. Maths I",
        "Physics",
        "Communication Tec",
        "PST",
        "FIT",
        "C",
        "Eng. math II",
        "LC",
        "MFC",
        "Drawing",
        "Cpp",
        "WT",
        "Eng. math III",
        "Java",
        "SEF",
        "MALP",
        "DSA",
        "PQT",
        "NM",
        "CG",
        "COA",
        "Database",
        "uml",
        "OM",
        "ADA",
        "SP",
        "AINN",
        "SM",
        "AOS",
        "Computer Network",
        "OOSD",
        "Economics",
        "Multimedia Sys",
        "popl",
        "RTS",
        "EAD",
        "IPPR",
        "DS",
        "SQA",
        "ELE I",
        "NP",
        "SPM",
        "ELE II");
        tSubject.setItems(subjects);
        tSubject1.setItems(subjects);
        tSubject2.setItems(subjects);
        teacherPeriod1.setItems(teacherPeriodObservableList);
        teacherPeriod11.setItems(teacherPeriodObservableList);
        teacherPeriod12.setItems(teacherPeriodObservableList);
        
    }    

    @FXML
    private void teacherDone(ActionEvent event) {
        System.out.println("teacher done");
        String tName = this.tName.getCharacters().toString();
        String tSubjectString = "";
        String tSubjectString1= "";
        String tSubjectString2= "";
        
        ttype = this.tType.isSelected();
        tSubLab11 = this.tSubLab1.isSelected();
        tSubLab22 = this.tSubLab2.isSelected();
        tSubLab33 = this.tSubLab3.isSelected();
        
        
        try {
            tSubjectString = tSubject.getSelectionModel().getSelectedItem().toString();
        } catch (NullPointerException e) {
            System.out.println("Null Pointer");
        }try {
            tSubjectString1 = tSubject1.getSelectionModel().getSelectedItem().toString();
        } catch (NullPointerException e) {
            System.out.println("Null Pointer");
        }try {
            tSubjectString2 = tSubject2.getSelectionModel().getSelectedItem().toString();
        } catch (NullPointerException e) {
            System.out.println("Null Pointer");
        }
        
        
        try {
            period1= (Integer) teacherPeriod1.getSelectionModel().getSelectedItem();
        } catch (Exception e) {
            System.out.println("error in period set 1st...."+e.getMessage());
        }try {
            period2= (Integer) teacherPeriod11.getSelectionModel().getSelectedItem();
        } catch (Exception e) {
            System.out.println("error in period set 2nd...."+e.getMessage());
        }try {
            period3= (Integer) teacherPeriod12.getSelectionModel().getSelectedItem();
        } catch (Exception e) {
            System.out.println("error in period set 3rd...."+e.getMessage());
        }
        
        
        try {
            
            DatabaseHandleSQLite dh = new DatabaseHandleSQLite();
            Connection conn = dh.connect();
            
            PreparedStatement pstmt = null;
            String qry = "INSERT INTO `teachers`("
                    + "`NAME`,"
                    + "`FULLTIME`,"
                    + "`FIRSTSUBJECT`,"
                    + "`SECONDSUBJECT`,"
                    + "`THIRDSUBJECT`,"
                    + "`FIRSTPERIOD`,"
                    + "`SECONDPERIOD`,"
                    + "`THIRDPERIOD`,"
                    + "`FIRSTSUBLAB`,"
                    + "`SECONDSUBLAB`,"
                    + "`THIRDSUBLAB`"
                    + ")"
                    + " VALUES("
                    + " '"+tName+"',"
                    + " '"+ttype+"',"
                    + " '"+tSubjectString+"',"
                    + " '"+tSubjectString1+"',"
                    + " '"+tSubjectString2+"',"
                    + " '"+period1+"',"
                    + " '"+period2+"',"
                    + " '"+period3+"',"
                    + " '"+tSubLab11+"',"
                    + " '"+tSubLab22+"',"
                    + " '"+tSubLab33+"'"
                    + ")";
            
            pstmt = conn.prepareStatement(qry);
            System.out.println("check");
            pstmt.executeUpdate();
            dh.disconnect();
            
            this.tName.clear();
            tSubject.setValue(null);
            tSubject1.setValue(null);
            tSubject2.setValue(null);
            teacherPeriod1.setValue(null);
            teacherPeriod11.setValue(null);
            teacherPeriod12.setValue(null);
            
            tType.setIndeterminate(true);
            tSubLab1.setIndeterminate(true);
            tSubLab2.setIndeterminate(true);
            tSubLab3.setIndeterminate(true);
        } catch (SQLException e) {
        }
    }
    
}
