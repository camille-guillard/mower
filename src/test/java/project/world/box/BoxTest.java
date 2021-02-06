package project.world.box;

import org.junit.Test;
import project.behavior.impl.SouthDirection;
import project.pawn.Pawn;
import project.pawn.mower.Mower;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BoxTest {

    @Test
    public void testInitBox(){
        int x = 5;
        int y = 6;
        Box box = new Box(x, y);

        assertEquals(x, box.getPosition().getX().intValue());
        assertEquals(y, box.getPosition().getY().intValue());
        assertEquals("__", box.toString());
        assertNull(box.getPawn());
    }

    @Test
    public void testSetPawn(){
        int x = 5;
        int y = 6;
        Box box = new Box(x, y);
        Pawn pawn = new Mower("M0", null, box, new SouthDirection(), "A");

        box.setPawn(pawn);

        assertEquals(pawn, box.getPawn());
        assertEquals(pawn.getName(), box.toString());
        assertEquals(box, pawn.getBox());
    }

}
