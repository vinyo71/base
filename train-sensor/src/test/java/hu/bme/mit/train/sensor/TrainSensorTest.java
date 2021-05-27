package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller_mock;
    TrainUser user_mock;
    TrainSensor sensor_mock;

    @Before
    public void before() {
        // linking mocks
        controller_mock = mock(TrainController.class);
        user_mock = mock(TrainUser.class);
        sensor_mock = new TrainSensorImpl(controller_mock, user_mock);
        when(controller_mock.getReferenceSpeed()).thenReturn(100);
    }

    @Test
    @DisplayName("Speed limit test when it is set to negative")
    public void overrideSpeedLimitToNegative() {
        sensor_mock.overrideSpeedLimit(-100);
        verify(user_mock, times(1)).setAlarmState(true);
    }

    @Test
    @DisplayName("Speed limit test when it is set higher than limit")
    public void overrideSpeedLimitHigherThanLimit() {
        sensor_mock.overrideSpeedLimit(1000);
        verify(user_mock, times(1)).setAlarmState(true);
    }

    @Test
    @DisplayName("Speed limit test when it is set iunder half")
    public void overrideSpeedLimitLessThenHalf() {
        sensor_mock.overrideSpeedLimit(20);
        verify(user_mock, times(1)).setAlarmState(true);
    }

    @Test
    @DisplayName("Speed limit test when valid value is set")
    public void OverrideSpeedLimitWithNormalValue() {
        sensor_mock.overrideSpeedLimit(250);
        verify(user_mock, times(0)).setAlarmState(true);
    }
}
