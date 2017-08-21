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
            ObservableList data =  FXCollections.observableArrayList();
            pStmt = conn.prepareStatement(qry);
            rs = pStmt.executeQuery();
            
            while (rs.next()) {
                data.add(rs.getString("SEMESTER"));
                subClass.setItems(data);
            }
            dbhs.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDialogFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void subjectDone(ActionEvent event) {
        String name = subName.getCharacters().toString();
        Boolean lab = subLab.isSelected();
        System.out.println(lab);
        
    }
    
}
