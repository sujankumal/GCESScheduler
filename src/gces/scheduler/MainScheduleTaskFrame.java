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
import java.util.Iterator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.GridView;

/**
 *
 * @author नमस्ते
 */
public class MainScheduleTaskFrame {
    
        static SpreadsheetView spreadView;
        GridView<Object> gridView;
        GridBase gridBase;
        GridPane gridPane = new GridPane();
        List < ObservableList< SpreadsheetCell>> rows;
        List<TeacherData> fullTimeTeacherList;
        List<TeacherData> partTimeTeacherList;
        Iterator<TeacherData> pTTiterator; //part time teacher iterator
        Iterator<TeacherData> fTTiterator;//full time teacher iterator
        StackPane stackPane;
        DatabaseHandleSQLite dh = new DatabaseHandleSQLite();
        Connection conn = dh.connect();
        PreparedStatement pstmt = null;
        String localString;
        String qry; 
        ResultSet rs =null;
        List<Object> teachers = new ArrayList<Object>();
        TeacherData td;
        CellSchedulerLink csl = new CellSchedulerLink();
        //
    /**
     *
     * @param stackPane
     */
    public MainScheduleTaskFrame(StackPane stackPane) {
         
        this.stackPane = stackPane;
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
        qry = "SELECT * FROM `teachers`"; 
        pstmt = conn.prepareStatement(qry);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String teacherName = "";
            String type = "";
            
            String subject1 = "";
            String subject2 = "";
            String subject3 = "";
            
            Integer period1 = 0;
            Integer period2 = 0;
            Integer period3 = 0;
            
            String lab1 = "";
            String lab2 = "";
            String lab3 = "";
            
            List<String> subjects;
            List<Integer> periods;
            List<String> labs;
            
            subjects = new ArrayList<>();
            periods = new ArrayList<>();
            labs = new ArrayList<>();
            
            teacherName = rs.getString("NAME");
            type = rs.getString("FULLTIME");
            
            
            subject1 = rs.getString("FIRSTSUBJECT");
            subject2 = rs.getString("SECONDSUBJECT");
            subject3 = rs.getString("THIRDSUBJECT");
            period1 = rs.getInt("FIRSTPERIOD");
            period2 = rs.getInt("SECONDPERIOD");
            period3 = rs.getInt("THIRDPERIOD");
            lab1 = rs.getString("FIRSTSUBLAB");
            lab2 = rs.getString("SECONDSUBLAB");
            lab3 = rs.getString("THIRDSUBLAB");
            
            
            subjects.add(subject1);
            subjects.add(subject2);
            subjects.add(subject3);
            
            periods.add(period1);
            periods.add(period2);
            periods.add(period3);
            
            labs.add(lab1);
            labs.add(lab2);
            labs.add(lab3);
            
            td = new TeacherData(teacherName, type, subjects, periods, labs);
            teachers.add(td);
        }
    }
    
    public SpreadsheetView generate() throws SQLException{
            fullTimeTeacherList = new ArrayList<TeacherData>();
            partTimeTeacherList = new ArrayList<TeacherData>();
        SubjectClassLink scl = new SubjectClassLink(); 
        gridBase.setCellValue(4, 5, "hero");
        dataInitialize();
        //seperating part time and full time  
        for (Iterator<Object> iterator = teachers.iterator(); iterator.hasNext();) {
            TeacherData next = (TeacherData) iterator.next();
            /*    System.out.println(next.getName());System.out.println(next.getType());System.out.println(next.getLabs().get(1));System.out.println(next.getPeriods().get(1));System.out.println(next.getSubjects().get(0));
            */
            if(next.getType().equals("true") ){
                fullTimeTeacherList.add(next);
            }else{
                partTimeTeacherList.add(next);
            }
            System.out.println("subject class "+scl.getAmap(next.getSubjects().get(0)));
        }
        int controlX = 0,controlY = 0;
        //cellX for sunday, y for monday, z for tuesday and [i][j] i for class j for period
        String cellX[][] = new String[4][6];
        String cellY[][] = new String[4][6];
        String cellZ[][] = new String[4][6];
        
        int i=0,j=0, day=0;
        pTTiterator = partTimeTeacherList.iterator();
        fTTiterator = fullTimeTeacherList.iterator();
        
        scheduling(controlX, controlY,
                cellX,cellY,cellZ,
                i,j,day,
                scl);
       
        stackPane.getChildren().add(spreadView);
        dh.disconnect();
       return spreadView;
    }
    
//--------------------------------------------------------------------------------
    int hello = 0;
   void scheduling(int controlX, int controlY,
            String[][] cellX, String[][] cellY, String[][] cellZ,
            int i, int j,int day,
            SubjectClassLink scl){
        //check if place is full
        //if(i>=3&&j>=6){
        //    return;
        //}
        //check if teachers list empty
        hello++;
        
        if (pTTiterator.hasNext()==false && fTTiterator.hasNext()==false) {
            return;
        }
        System.out.println("Counting: "+ hello + " i: "+ i+ " j : "+j);
       
        day = 1;
        for (; pTTiterator.hasNext(); ) {
            TeacherData next = pTTiterator.next();
            System.out.println("p teacher name : " + next.name);
              scheduling(controlX, controlY,cellX,cellY,cellZ,i,j,day,scl);
        }
        for (; fTTiterator.hasNext(); ) {
            TeacherData next = fTTiterator.next();
             System.out.println("f teacher name : " + next.name);
           
              scheduling(controlX, controlY,cellX,cellY,cellZ,i,j,day,scl); 
        }
        gridBase.setCellValue(csl.getRow(day, i+1, j+1), csl.getColumn(day, i+1, j+1), "i "+i+" j "+j);
        System.out.println(cellX[0][0]+i+j);
        //return;
       // if(!(i>=3)){
       //  i++;
       // }
       // j++;
       
       // scheduling(fullTimeTeacherList,partTimeTeacherList,controlX, controlY,cellX,cellY,cellZ,i,j,day,scl);
    }
 //------------------------------------------------------------------------------------------   
}

//CP problem take variaable, domain, and constrain
