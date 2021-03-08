package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Arrays;


public class TrainTachograph {
    Table<String, Integer, Double> tachograph = HashBasedTable.create();

    public void put(String time, Integer joyPos, Double refSpeed){
        tachograph.put(time, joyPos, refSpeed);
    }

    public void print(){
        System.out.println(Arrays.asList(tachograph));
    }

}
