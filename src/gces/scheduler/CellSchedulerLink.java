/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gces.scheduler;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author नमस्ते
 */
public class CellSchedulerLink {
    Map<Integer, Double> cellSchedulerMap;
   
    public CellSchedulerLink(){
        this.cellSchedulerMap = new HashMap<>();
        //  sunday           dcp, RR.CC 
        cellSchedulerMap.put(111, 01.02);
        cellSchedulerMap.put(112, 02.02);
        cellSchedulerMap.put(113, 03.02);
        cellSchedulerMap.put(114, 04.02);
        cellSchedulerMap.put(115, 05.02);
        cellSchedulerMap.put(116, 06.02);
        cellSchedulerMap.put(121, 07.02);
        cellSchedulerMap.put(122, 08.02);
        cellSchedulerMap.put(123, 09.02);
        cellSchedulerMap.put(124, 10.02);
        cellSchedulerMap.put(125, 11.02);
        cellSchedulerMap.put(126, 12.02);
        cellSchedulerMap.put(131, 13.02);
        cellSchedulerMap.put(132, 14.02);
        cellSchedulerMap.put(133, 15.02);
        cellSchedulerMap.put(134, 16.02);
        cellSchedulerMap.put(135, 17.02);
        cellSchedulerMap.put(136, 18.02);
        cellSchedulerMap.put(141, 19.02);
        cellSchedulerMap.put(142, 20.02);
        cellSchedulerMap.put(143, 21.02);
        cellSchedulerMap.put(144, 22.02);
        cellSchedulerMap.put(145, 23.02);
        cellSchedulerMap.put(146, 24.02);
        //  monday           dcp, RR.CC 
        cellSchedulerMap.put(211, 01.03);
        cellSchedulerMap.put(212, 02.03);
        cellSchedulerMap.put(213, 03.03);
        cellSchedulerMap.put(214, 04.03);
        cellSchedulerMap.put(215, 05.03);
        cellSchedulerMap.put(216, 06.03);
        cellSchedulerMap.put(221, 07.03);
        cellSchedulerMap.put(222, 08.03);
        cellSchedulerMap.put(223, 09.03);
        cellSchedulerMap.put(224, 10.03);
        cellSchedulerMap.put(225, 11.03);
        cellSchedulerMap.put(226, 12.03);
        cellSchedulerMap.put(231, 13.03);
        cellSchedulerMap.put(232, 14.03);
        cellSchedulerMap.put(233, 15.03);
        cellSchedulerMap.put(234, 16.03);
        cellSchedulerMap.put(235, 17.03);
        cellSchedulerMap.put(236, 18.03);
        cellSchedulerMap.put(241, 19.03);
        cellSchedulerMap.put(242, 20.03);
        cellSchedulerMap.put(243, 21.03);
        cellSchedulerMap.put(244, 22.03);
        cellSchedulerMap.put(245, 23.03);
        cellSchedulerMap.put(246, 24.03);
        //  tuesday          dcp, RR.CC 
        cellSchedulerMap.put(311, 01.04);
        cellSchedulerMap.put(312, 02.04);
        cellSchedulerMap.put(313, 03.04);
        cellSchedulerMap.put(314, 04.04);
        cellSchedulerMap.put(315, 05.04);
        cellSchedulerMap.put(316, 06.04);
        cellSchedulerMap.put(321, 07.04);
        cellSchedulerMap.put(322, 08.04);
        cellSchedulerMap.put(323, 09.04);
        cellSchedulerMap.put(324, 10.04);
        cellSchedulerMap.put(325, 11.04);
        cellSchedulerMap.put(326, 12.04);
        cellSchedulerMap.put(331, 13.04);
        cellSchedulerMap.put(332, 14.04);
        cellSchedulerMap.put(333, 15.04);
        cellSchedulerMap.put(334, 16.04);
        cellSchedulerMap.put(335, 17.04);
        cellSchedulerMap.put(336, 18.04);
        cellSchedulerMap.put(341, 19.04);
        cellSchedulerMap.put(342, 20.04);
        cellSchedulerMap.put(343, 21.04);
        cellSchedulerMap.put(344, 22.04);
        cellSchedulerMap.put(345, 23.04);
        cellSchedulerMap.put(346, 24.04);
    }
    public int getRow(int day, int i, int j){
      
       return (int)Math.floor(cellSchedulerMap.get(
                Integer.valueOf(String.format("%d%d%d", day,i,j))));
    }
    public int getColumn(int day,int i, int j){
        String number = String.valueOf(cellSchedulerMap.get(
                Integer.valueOf(String.format("%d%d%d", day,i,j))));
        int indexOfDecimal = number.indexOf(".");
        number = number.substring(indexOfDecimal+1, indexOfDecimal+3);
        return Integer.valueOf(number);
             
    }
}
