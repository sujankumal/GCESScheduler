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

/**
 *
 * @author नमस्ते
 */
public class MainScheduleTaskFrame {
    
    public SpreadsheetView initialize(){
        GridBase gridBase = new GridBase(25, 8);
        List < ObservableList< SpreadsheetCell>> rows = new ArrayList <>();
        
        for (int row = 0 ; row < gridBase .getRowCount(); ++ row ) {
            ObservableList< SpreadsheetCell>rowOfCells = FXCollections.observableArrayList ();
            for(int column = 0; column< gridBase.getColumnCount (); ++ column ) {
                rowOfCells.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1, "empty "));
            }
        rows.add ( rowOfCells );
        }
        
        gridBase .setRows (rows);
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
        SpreadsheetView spreadView = new SpreadsheetView( gridBase );
        spreadView.setShowRowHeader(true);
        spreadView.setShowColumnHeader(true);
        spreadView.setEditable (true);
        return spreadView;
    }
}
