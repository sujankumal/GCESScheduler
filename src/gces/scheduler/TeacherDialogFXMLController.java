/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;

import java.net.URL;
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
    }    

    @FXML
    private void teacherDone(ActionEvent event) {
        String tName = this.tName.getCharacters().toString();
        Boolean ttype = this.tType.isSelected();
        
        System.out.println(tName);
        System.out.println(ttype);
    }
    
}
