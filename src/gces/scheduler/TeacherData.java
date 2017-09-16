/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author नमस्ते
 */
public class TeacherData {
     String name;
     Boolean type;
     List<String> subjects;
     List<Integer> periods;
     List<Boolean> labs;

    /**
     *
     * @param name
     * @param type
     * @param subjects
     * @param periods
     * @param labs
     */
    
     TeacherData(String name, Boolean type, List<String> subjects, List<Integer> periods, List<Boolean> labs ){
        this.name = name;
        this.type = type;
        this.subjects = subjects;
        this.periods = periods;
        this.labs = labs;
    }

    public String getName() {
        return name;
    }
  
     public Boolean getType() {
        return type;
    }
     
    public List<Boolean> getLabs() {
        return labs;
    }

    public List<Integer> getPeriods() {
        return periods;
    }

    public List<String> getSubjects() {
        return subjects;
    }

   
    
    
}
