package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;

import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import java.time.LocalTime;

public class TrainTachograph {
    private TrainController controller = new TrainControllerImpl();
    private TrainUser user = new TrainUserImpl(controller);
    private Table<LocalTime, int, int> tachograph;

    public TrainTachograph() {
        tachograph = HashBasedTable.create();
        tachograph.put(java.time.LocalTime.now(), user.getJoystickPosition(), controller.getReferenceSpeed());
    }
    
    public void put(LocalTime time, int joyPos, int refSpeed){
        tachograph.put(time, joyPos, refSpeed);
    }

    public void print(){
        System.out.println(Arrays.asList(tachograph));
    }

}
