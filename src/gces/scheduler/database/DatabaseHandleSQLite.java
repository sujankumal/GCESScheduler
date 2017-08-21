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
        setUpClassTable();
        setUpSubjectTable();
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
                String qry = "CREATE TABLE " +TABLE_NAME+ "("
                +   "	ID INTEGER not null primary key,\n" 
                +   "	NAME VARCHAR(30) not null,\n"
                +   "	FULLTIME BOOLEAN,\n"
                +   "	TSTART VARCHAR(10),\n"
                +   "	TEND VARCHAR(10),\n"
                +   "	SUBJECT VARCHAR(40)\n"
                +   ")";
                pstmt = conn.prepareStatement(qry);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage()+"...setUpDatabaseTableTeacher");
        }
    }
    void setUpClassTable(){
         String TABLE_NAME = "class";
        try {
           //stmt = conn.prepareStatement();
            
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if (tables.next()) {
                System.out.println("Table "+TABLE_NAME+" already exists. Ready to go!");
            }else{
                
               String qry="CREATE TABLE " +TABLE_NAME+ "("
                        +   "	ID INTEGER not null primary key,\n" 
                        +   "	SEMESTER VARCHAR(20) UNIQUE,\n"
                        +   "	PERIODNO INTEGER not null\n"
                        +   ")";
                pstmt = conn.prepareStatement(qry);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage()+"....setUpDatabaseTableClass");
        }
    }
    void setUpSubjectTable(){
        String TABLE_NAME = "subjects";
        try {
           // stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables =dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if (tables.next()) {
                System.out.println("Table"+TABLE_NAME+" already exists.Ready to go !");
            }else{
                String qry = "CREATE TABLE "+TABLE_NAME+"("
                +   "	ID INTEGER not null primary key,\n"
                +   "	NAME VARCHAR(40) not null,\n"
                +   "	TEACHER VARCHAR(30),\n"
                +   "	ISLABREQ BOOLEAN,\n"
                +   "	CLASS INTEGER\n"
                +   ")";
                
                pstmt = conn.prepareStatement(qry);
                pstmt.executeUpdate();
            } 
        } catch (SQLException e) {
            System.err.println(e.getMessage()+"...setUpDatabaseTableSubjects");
        }
    }
    
}
