package project.behavior.impl;

import org.junit.Test;
import project.behavior.IDirection;
import project.pawn.Position;

import static org.junit.Assert.assertEquals;

public class WestDirectionTest {

    @Test
    public void testMovingForward(){
        Position position = new Position(1, 0);
        Position newPosition = new WestDirection().movingForward(position);

        assertEquals(position.getX() - 1, newPosition.getX().intValue());
        assertEquals(position.getY(), newPosition.getY());
    }

    @Test
    public void testTurnLeft(){
        IDirection direction = new WestDirection().turnLeft();
        assertEquals(new SouthDirection(), direction);
    }

    @Test
    public void testTurnRight(){
        IDirection direction = new WestDirection().turnRight();
        assertEquals(new NorthDirection(), direction);
    }

}
