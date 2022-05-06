import org.junit.Test;

import static org.junit.Assert.*;

public class ModuleTest {

    @Test
    public void createModuleWithCharAtConstructor() {
        Module module = new Module('B');
    }

    @Test
    public void checkModulHParameters() {
        Module moduleH = new Module('H');
        assertEquals(ModuleType.H,moduleH.type);
        assertEquals(0.5,moduleH.getDriveThruSpeed(),0);
        assertEquals(10.0,moduleH.getPickUpTime(2),0);
    }

    @Test
    public void checkModulBParameters() {
        Module moduleB = new Module('B');
        assertEquals(ModuleType.B,moduleB.type);
        assertEquals(1.0,moduleB.getDriveThruSpeed(),0);
        assertEquals(6.0,moduleB.getPickUpTime(2),0);
    }

    @Test
    public void checkModulSParameters() {
        Module moduleH = new Module('S');
        assertEquals(ModuleType.S,moduleH.type);
        assertEquals(2.0,moduleH.getDriveThruSpeed(),0);
        assertEquals(3.0,moduleH.getPickUpTime(2),0);
    }

    @Test
    public void checkModulOParameters() {
        Module moduleH = new Module('O');
        assertEquals(ModuleType.O,moduleH.type);
        assertEquals(0,moduleH.getDriveThruSpeed(),0);
        assertEquals(0,moduleH.getPickUpTime(2),0);
    }

}