/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author नमस्ते
 */
public class SubjectClassLink {
    Map<String, Integer> amap;

    public SubjectClassLink() {
        this.amap = new HashMap<>();
        amap.put("Eng. Maths I",1);
        amap.put("Physics",1);
        amap.put("Communication Tec",1);
        amap.put("PST",1);
        amap.put("FIT",1);
        amap.put("C",1);
        amap.put("Eng. math II",1);
        amap.put("LC",1);
        amap.put("MFC",1);
        amap.put("Drawing",1);
        amap.put("Cpp",1);
        amap.put("WT",1);
        
        amap.put("Eng. math III",2);
        amap.put("Java",2);
        amap.put("SEF",2);
        amap.put("MALP",2);
        amap.put("DSA",2);
        amap.put("PQT",2);
        amap.put("NM",2);
        amap.put("CG",2);
        amap.put("COA",2);
        amap.put("Database",2);
        amap.put("uml",2);
        
        amap.put("OM",3);
        amap.put("ADA",3);
        amap.put("SP",3);
        amap.put("AINN",3);
        amap.put("SM",3);
        amap.put("AOS",3);
        amap.put("Computer Network",3);
        amap.put("OOSD",3);
        amap.put("Economics",3);
        amap.put("Multimedia Sys",3);
        amap.put("popl",3);
        
        amap.put("RTS",4);
        amap.put("EAD",4);
        amap.put("IPPR",4);
        amap.put("DS",4);
        amap.put("SQA",4);
        amap.put("ELE I",4);
        amap.put("NP",4);
        amap.put("SPM",4);
        amap.put("ELE II",4);
 
    }

    /**
     *
     * @param s
     * @return integer value for class
     */
    public Integer getAmap(String s) {
        return amap.get(s);
    }
    
}
