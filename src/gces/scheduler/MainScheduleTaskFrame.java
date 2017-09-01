/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;
import gces.scheduler.database.DatabaseHandleSQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author नमस्ते
 */
public class MainScheduleTaskFrame {
    
        static SpreadsheetView spreadView;
        static GridBase gridBase;
        static List < ObservableList< SpreadsheetCell>> rows;
        private List<String> teachers, classes, subjects;

    public MainScheduleTaskFrame() {
            try {
                dataInitialize();
            } catch (SQLException ex) {
                Logger.getLogger(MainScheduleTaskFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        gridBase = new GridBase(25, 8);
        rows = new ArrayList <>();
        for (int row = 0 ; row < gridBase .getRowCount(); ++ row ) {
            ObservableList< SpreadsheetCell>rowOfCells = FXCollections.observableArrayList ();
            for(int column = 0; column< gridBase.getColumnCount (); ++ column ) {
                rowOfCells.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1, ""));
            }
        rows.add ( rowOfCells );
        }
        
        gridBase.setRows (rows);
        gridBase.spanColumn(2, 0, 0);
        gridBase.spanRow(6, 1, 0);
        gridBase.spanRow(6, 7, 0);
        gridBase.spanRow(6, 13, 0);
        gridBase.spanRow(6, 19, 0);
        gridBase.setCellValue(0, 0, "S/N");
        gridBase.setCellValue(2, 0, "1st year");
        gridBase.setCellValue(8, 0, "2nd year");
        gridBase.setCellValue(15, 0, "3rd year");
        gridBase.setCellValue(21, 0, "4th year");
        gridBase.setCellValue(0, 2, "Sunday");
        gridBase.setCellValue(0, 3, "Monday");
        gridBase.setCellValue(0, 4, "Tuesday");
        gridBase.setCellValue(0, 5, "Wednesday");
        gridBase.setCellValue(0, 6, "Thursday");
        gridBase.setCellValue(0, 7, "Friday");
        
        for (int i = 0; i < 4; i++) {
            int j=0;
            switch (i){
                case 1:
                    j=6;break;
                case 2:
                    j=12;break;
                case 3:
                    j=18;break;
            }
           gridBase.setCellValue((j+1), 1, "1st period");
           gridBase.setCellValue((j+2), 1, "2nd period");
           gridBase.setCellValue((j+3), 1, "3rd period");
           gridBase.setCellValue((j+4), 1, "4th period");
           gridBase.setCellValue((j+5), 1, "5th period");
           gridBase.setCellValue((j+6), 1, "6th period");            
        }
        spreadView = new SpreadsheetView( gridBase );
        spreadView.setShowRowHeader(true);
        spreadView.setShowColumnHeader(true);
        spreadView.setEditable (true);
    }
    
    public void dataInitialize() throws SQLException{
        DatabaseHandleSQLite databaseHandleSQLite = new DatabaseHandleSQLite();
        Connection conn = databaseHandleSQLite.connect();
        ResultSet rs=null;
        PreparedStatement pStmt = null;
        String qry = "SELECT `NAME` FROM `teachers`"; 
        pStmt = conn.prepareStatement(qry);
        rs = pStmt.executeQuery();
        teachers = new ArrayList<String>();
        while (rs.next()) {
            teachers.add(rs.getString("NAME"));
        }
       
        qry = "SELECT `NAME` FROM `subjects`";
        pStmt = conn.prepareStatement(qry);
        rs = pStmt.executeQuery();
        subjects = new ArrayList<String>();
        while (rs.next()) {
            subjects.add(rs.getString("NAME"));
        }
        
        qry = "SELECT `SEMESTER` FROM `class`";
        pStmt = conn.prepareStatement(qry);
        rs = pStmt.executeQuery();
        classes = new ArrayList<String>();
        while (rs.next()) {
            classes.add(rs.getString("SEMESTER"));
        }
        
        System.out.println(teachers.get(0));    
        System.out.println(subjects.get(0));
        System.out.println(classes.get(0));
        
        databaseHandleSQLite.disconnect();
    }
    
    public SpreadsheetView generate(){
          gridBase.setCellValue(5, 5, "hero");
          return spreadView;
    }   
    
}