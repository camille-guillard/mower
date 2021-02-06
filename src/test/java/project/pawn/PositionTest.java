package project.pawn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void testInitPosition(){
        int x = 50;
        int y = 70;

        Position position = new Position(x, y);
        assertEquals(x, position.getX().intValue());
        assertEquals(y, position.getY().intValue());
    }

}
