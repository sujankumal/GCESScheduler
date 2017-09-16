/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author नमस्ते
 */
public final class DatabaseHandleSQLite {
    private static Connection conn =null;
    private static final String DB_URL = "jdbc:sqlite:sqliteDB/database.db";
    private static PreparedStatement pstmt = null;
    public DatabaseHandleSQLite(String s){
        connect();
        setUpTeachersTable();
        //deleted :D
      //  setUpClassTable();
      //  setUpSubjectTable();
    }
    public DatabaseHandleSQLite(){  
        
    }
    
    public Connection connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn =DriverManager.getConnection(DB_URL);
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHandleSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public void disconnect(){
         try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
     void setUpTeachersTable(){
       String TABLE_NAME = "teachers";
        try {
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables =dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if (tables.next()) {
                System.out.println("Table"+TABLE_NAME+" already exists.Ready to go !");
            }else{
                
                String qry = "CREATE TABLE "+TABLE_NAME+ "("
                        +"ID INTEGER not null primary key,\n" 
                        +"NAME VARCHAR(30) not null,\n" 
                        +"FULLTIME BOOLEAN,\n" 
                        +"FIRSTSUBJECT VARCHAR(30),\n" 
                        +"SECONDSUBJECT VARCHAR(30),\n" 
                        +"THIRDSUBJECT VARCHAR(30),\n" 
                        +"FIRSTPERIOD INTEGER,\n" 
                        +"SECONDPERIOD INTEGER,\n" 
                        +"THIRDPERIOD INTEGER,\n"
                        +"FIRSTSUBLAB BOOLEAN,\n" 
                        +"SECONDSUBLAB BOOLEAN,\n" 
                        +"THIRDSUBLAB BOOLEAN"
                        + ")";
                pstmt = conn.prepareStatement(qry);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage()+"...setUpDatabaseTableTeacher");
        }
    } 
}