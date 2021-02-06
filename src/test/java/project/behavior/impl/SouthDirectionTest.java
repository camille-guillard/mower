package project.behavior.impl;

import org.junit.Test;
import project.behavior.IDirection;
import project.pawn.Position;

import static org.junit.Assert.assertEquals;

public class SouthDirectionTest {

    @Test
    public void testMovingForward(){
        Position position = new Position(0, 1);
        Position newPosition = new SouthDirection().movingForward(position);

        assertEquals(position.getX(), newPosition.getX());
        assertEquals(position.getY() - 1, newPosition.getY().intValue());
    }

    @Test
    public void testTurnLeft(){
        IDirection direction = new SouthDirection().turnLeft();
        assertEquals(new EastDirection(), direction);
    }

    @Test
    public void testTurnRight(){
        IDirection direction = new SouthDirection().turnRight();
        assertEquals(new WestDirection(), direction);
    }

}
