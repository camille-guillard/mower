package project.behavior;

import org.junit.Test;
import project.behavior.impl.EastDirection;
import project.behavior.impl.NorthDirection;
import project.behavior.impl.SouthDirection;
import project.behavior.impl.WestDirection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IDirectionTest {

    @Test
    public void testGetNorthDirection(){
        IDirection direction = IDirection.getDirection('N');
        assertEquals(new NorthDirection(), direction);
    }

    @Test
    public void testGetSouthDirection(){
        IDirection direction = IDirection.getDirection('S');
        assertEquals(new SouthDirection(), direction);
    }

    @Test
    public void testGetEastDirection(){
        IDirection direction = IDirection.getDirection('E');
        assertEquals(new EastDirection(), direction);
    }

    @Test
    public void testGetWestDirection(){
        IDirection direction = IDirection.getDirection('W');
        assertEquals(new WestDirection(), direction);
    }

    @Test
    public void testGetNullDirection(){
        IDirection direction = IDirection.getDirection('?');
        assertNull(direction);
    }

}
