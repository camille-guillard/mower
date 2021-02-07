package project.world;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import project.behavior.impl.EastDirection;
import project.behavior.impl.NorthDirection;
import project.behavior.impl.SouthDirection;
import project.behavior.impl.WestDirection;
import project.pawn.IPawn;
import project.pawn.mower.Mower;
import project.world.box.GrassBox;

import static org.junit.Assert.*;

public class WorldMapTest {

    static {
        BasicConfigurator.configure();
    }


    @Test
    public void testInitWorldMap(){

        int mapX = 50;
        int mapY = 55;

        WorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);

        assertEquals(worldMap.getGrid().length, mapX + 1);
        assertEquals((worldMap.getGrid()[0]).length, mapY + 1);
    }

    @Test
    public void testInitPawns(){

        int mapX = 0;
        int mapY = 1;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new NorthDirection(), "");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertEquals(pawn.getBox().getPosition().getX().intValue(), pawnX);
        assertEquals(pawn.getBox().getPosition().getY().intValue(), pawnY);
    }

    @Test
    public void testNorthDirectionMove(){

        int mapX = 0;
        int mapY = 1;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new NorthDirection(), "A");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertEquals(pawn.getBox().getPosition().getX().intValue(), pawnX);
        assertEquals(pawn.getBox().getPosition().getY().intValue(), pawnY + 1);
    }

    @Test
    public void testSouthDirectionMove(){

        int mapX = 0;
        int mapY = 1;
        int pawnX = 0;
        int pawnY = 1;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new SouthDirection(), "A");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertEquals(pawnX, pawn.getBox().getPosition().getX().intValue());
        assertEquals(pawnY - 1, pawn.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testEastDirectionMove(){

        int mapX = 1;
        int mapY = 0;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new EastDirection(), "A");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertEquals(pawnX + 1, pawn.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testWestDirectionMove(){

        int mapX = 1;
        int mapY = 0;
        int pawnX = 1;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new WestDirection(), "A");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertEquals(pawnX - 1, pawn.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testNorthDirectionMoveOOB(){

        int mapX = 0;
        int mapY = 0;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new NorthDirection(), "A");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertEquals(pawnX, pawn.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testSouthDirectionMoveOOB(){

        int mapX = 0;
        int mapY = 0;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new SouthDirection(), "A");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertEquals(pawnX, pawn.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testEastDirectionMoveOOB(){

        int mapX = 0;
        int mapY = 0;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new EastDirection(), "A");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertEquals(pawnX, pawn.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testWestDirectionMoveOOB(){

        int mapX = 0;
        int mapY = 0;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new WestDirection(), "A");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertEquals(pawnX, pawn.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testNorthDirectionMoveBlocked(){

        int mapX = 0;
        int mapY = 1;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);

        IPawn pawn0 = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new NorthDirection(), "A");
        worldMap.addPawn(pawn0);

        IPawn pawn1 = new Mower("M1", worldMap, worldMap.getBox(pawnX, pawnY + 1), new NorthDirection(), "");
        worldMap.addPawn(pawn1);

        worldMap.run();

        assertEquals(pawnX, pawn0.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn0.getBox().getPosition().getY().intValue());
        assertEquals(pawnX, pawn1.getBox().getPosition().getX().intValue());
        assertEquals(pawnY + 1, pawn1.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testSouthDirectionMoveBlocked(){

        int mapX = 0;
        int mapY = 1;
        int pawnX = 0;
        int pawnY = 1;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);

        IPawn pawn0 = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new SouthDirection(), "A");
        worldMap.addPawn(pawn0);

        IPawn pawn1 = new Mower("M1", worldMap, worldMap.getBox(pawnX, pawnY - 1), new NorthDirection(), "");
        worldMap.addPawn(pawn1);

        worldMap.run();

        assertEquals(pawnX, pawn0.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn0.getBox().getPosition().getY().intValue());
        assertEquals(pawnX, pawn1.getBox().getPosition().getX().intValue());
        assertEquals(pawnY - 1, pawn1.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testEastDirectionMoveBlocked(){

        int mapX = 1;
        int mapY = 0;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);

        IPawn pawn0 = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new EastDirection(), "A");
        worldMap.addPawn(pawn0);

        IPawn pawn1 = new Mower("M1", worldMap, worldMap.getBox(pawnX + 1, pawnY), new NorthDirection(), "");
        worldMap.addPawn(pawn1);

        worldMap.run();

        assertEquals(pawnX, pawn0.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn0.getBox().getPosition().getY().intValue());
        assertEquals(pawnX + 1, pawn1.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn1.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testWestDirectionMoveBlocked(){

        int mapX = 1;
        int mapY = 0;
        int pawnX = 1;
        int pawnY = 0;

        IWorldMap worldMap = new WorldMap();
        worldMap.init(mapX, mapY);

        IPawn pawn0 = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new WestDirection(), "A");
        worldMap.addPawn(pawn0);

        IPawn pawn1 = new Mower("M1", worldMap, worldMap.getBox(pawnX - 1, pawnY), new NorthDirection(), "");
        worldMap.addPawn(pawn1);

        worldMap.run();

        assertEquals(pawnX, pawn0.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn0.getBox().getPosition().getY().intValue());
        assertEquals(pawnX - 1, pawn1.getBox().getPosition().getX().intValue());
        assertEquals(pawnY, pawn1.getBox().getPosition().getY().intValue());
    }

    @Test
    public void testMow(){

        int mapX = 0;
        int mapY = 1;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new GrassWorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new NorthDirection(), "G");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertTrue(((GrassBox)worldMap.getBox(0,0)).isMowed());
        assertFalse(((GrassBox)worldMap.getBox(0,1)).isMowed());
    }

    @Test
    public void testMow2(){

        int mapX = 0;
        int mapY = 1;
        int pawnX = 0;
        int pawnY = 0;

        IWorldMap worldMap = new GrassWorldMap();
        worldMap.init(mapX, mapY);
        IPawn pawn = new Mower("M0", worldMap, worldMap.getBox(pawnX, pawnY), new NorthDirection(), "A");
        worldMap.addPawn(pawn);
        worldMap.run();

        assertTrue(((GrassBox)worldMap.getBox(0,0)).isMowed());
        assertTrue(((GrassBox)worldMap.getBox(0,1)).isMowed());
    }

}
