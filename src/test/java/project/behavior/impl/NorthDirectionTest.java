package project.behavior.impl;

import org.junit.Test;
import project.behavior.IDirection;
import project.pawn.Position;

import static org.junit.Assert.assertEquals;

public class NorthDirectionTest {

    @Test
    public void testMovingForward(){
        Position position = new Position(0, 0);
        Position newPosition = new NorthDirection().movingForward(position);

        assertEquals(position.getX(), newPosition.getX());
        assertEquals(position.getY() + 1, newPosition.getY().intValue());
    }

    @Test
    public void testTurnLeft(){
        IDirection direction = new NorthDirection().turnLeft();
        assertEquals(new WestDirection(), direction);
    }

    @Test
    public void testTurnRight(){
        IDirection direction = new NorthDirection().turnRight();
        assertEquals(new EastDirection(), direction);
    }

}
