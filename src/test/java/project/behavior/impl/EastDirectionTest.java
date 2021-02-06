package project.behavior.impl;

import org.junit.Test;
import project.behavior.IDirection;
import project.pawn.Position;

import static org.junit.Assert.assertEquals;

public class EastDirectionTest {

    @Test
    public void testMovingForward(){
        Position position = new Position(0, 0);
        Position newPosition = new EastDirection().movingForward(position);

        assertEquals(position.getX() + 1, newPosition.getX().intValue());
        assertEquals(position.getY(), newPosition.getY());
    }

    @Test
    public void testTurnLeft(){
        IDirection direction = new EastDirection().turnLeft();
        assertEquals(new NorthDirection(), direction);
    }

    @Test
    public void testTurnRight(){
        IDirection direction = new EastDirection().turnRight();
        assertEquals(new SouthDirection(), direction);
    }

}
