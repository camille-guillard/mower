package project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project.behavior.IDirectionTest;
import project.behavior.enums.CommandEnumTest;
import project.behavior.impl.*;
import project.pawn.PawnTest;
import project.pawn.PositionTest;
import project.world.WorldMapTest;
import project.world.box.BoxTest;
import project.world.box.GrassBoxTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WorldMapTest.class,
        PawnTest.class,
        CommandEnumTest.class,
        IDirectionTest.class,
        EastDirectionTest.class,
        WestDirectionTest.class,
        NorthDirectionTest.class,
        SouthDirectionTest.class,
        PositionTest.class,
        BoxTest.class,
        GrassBoxTest.class
})

public class TestSuite {

}
