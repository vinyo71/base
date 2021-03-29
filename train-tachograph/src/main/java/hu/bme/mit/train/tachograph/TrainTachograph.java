package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;

import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;




public class TrainTachograph {
    private TrainUser user = new TrainUserImpl(controller);
    private TrainController controller = new TrainControllerImpl();
    private Table<String, Integer, Double> tachograph;

    public TrainTachograph() {
        tachograph = HashBasedTable.create();
        table.put(java.time.LocalTime.now(), user.getJoystickPosition(), controller.getReferenceSpeed());
    }
    
    public void put(String time, Integer joyPos, Double refSpeed){
        tachograph.put(time, joyPos, refSpeed);
    }

    public void print(){
        System.out.println(Arrays.asList(tachograph));
    }

}
