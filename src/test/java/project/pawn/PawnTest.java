package project.pawn;

import org.junit.Test;
import project.behavior.impl.EastDirection;
import project.behavior.impl.NorthDirection;
import project.behavior.impl.SouthDirection;
import project.behavior.impl.WestDirection;
import project.pawn.mower.Mower;


import static org.junit.Assert.assertEquals;

public class PawnTest {

    @Test
    public void testInitCommand(){
        Pawn pawn = new Mower("M0", null, null, new NorthDirection(), "AGD");
        assertEquals(new NorthDirection(), pawn.getDirection());
        assertEquals("M0", pawn.getName());
    }

    @Test
    public void testNorthTurnLeft(){
        Pawn pawn = new Mower("M0", null, null, new NorthDirection(), "G");
        pawn.run();
        assertEquals(new WestDirection(), pawn.getDirection());
    }

    @Test
    public void testNorthTurnRight(){
        Pawn pawn = new Mower("M0", null, null, new NorthDirection(), "D");
        pawn.run();
        assertEquals(new EastDirection(), pawn.getDirection());
    }

    @Test
    public void testSouthTurnLeft(){
        Pawn pawn = new Mower("M0", null, null, new SouthDirection(), "G");
        pawn.run();
        assertEquals(new EastDirection(), pawn.getDirection());
    }

    @Test
    public void testSouthTurnRight(){
        Pawn pawn = new Mower("M0", null, null, new SouthDirection(), "D");
        pawn.run();
        assertEquals(new WestDirection(), pawn.getDirection());
    }

    @Test
    public void testEastTurnLeft(){
        Pawn pawn = new Mower("M0", null, null, new EastDirection(), "G");
        pawn.run();
        assertEquals(new NorthDirection(), pawn.getDirection());
    }

    @Test
    public void testEastTurnRight(){
        Pawn pawn = new Mower("M0", null, null, new EastDirection(), "D");
        pawn.run();
        assertEquals(new SouthDirection(), pawn.getDirection());
    }

    @Test
    public void testWestTurnLeft(){
        Pawn pawn = new Mower("M0", null, null, new WestDirection(), "G");
        pawn.run();
        assertEquals(new SouthDirection(), pawn.getDirection());
    }

    @Test
    public void testWestTurnRight(){
        Pawn pawn = new Mower("M0", null, null, new WestDirection(), "D");
        pawn.run();
        assertEquals(new NorthDirection(), pawn.getDirection());
    }

}
