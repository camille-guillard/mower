package project.world.box;

import org.junit.Test;
import project.behavior.impl.SouthDirection;
import project.pawn.IPawn;
import project.pawn.mower.Mower;

import static org.junit.Assert.*;

public class GrassBoxTest {

    @Test
    public void testInitBox(){
        int x = 5;
        int y = 6;
        GrassBox box = new GrassBox(x, y);

        assertEquals(x, box.getPosition().getX().intValue());
        assertEquals(y, box.getPosition().getY().intValue());
        assertFalse(box.isMowed());
        assertEquals("||", box.toString());
        assertNull(box.getPawn());
    }

    @Test
    public void testSetPawn(){
        int x = 5;
        int y = 6;
        GrassBox box = new GrassBox(x, y);
        IPawn pawn = new Mower("M0", null, box, new SouthDirection(), "G");

        box.setPawn(pawn);

        pawn.action();

        assertEquals(pawn, box.getPawn());
        assertTrue(box.isMowed());
        assertEquals(pawn.getName(), box.toString());
        assertEquals(box, pawn.getBox());
    }

    @Test
    public void testToString(){
        int x = 5;
        int y = 6;
        String name = "M0";
        GrassBox box = new GrassBox(x, y);

        // Test 1
        assertEquals("||", box.toString());

        IPawn pawn = new Mower(name, null, box, new SouthDirection(), "G");
        box.setPawn(pawn);

        // Test 2
        assertEquals(name, box.toString());

        pawn.action();
        box.setPawn(null);

        // Test 3
        assertEquals("__", box.toString());

    }

}
