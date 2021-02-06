package project.pawn.mower;

import project.behavior.IDirection;
import project.behavior.enums.CommandEnum;
import project.pawn.Pawn;
import project.world.box.Box;
import project.world.box.GrassBox;
import project.world.WorldMap;

import java.util.List;

public class Mower extends Pawn implements Mowable {

    public Mower(String name, WorldMap worldMap, Box box, IDirection direction, List<CommandEnum> commands) {
        super(name, worldMap, box, direction, commands);
    }

    public Mower(String name, WorldMap worldMap, Box box, IDirection direction, String commands) {
        super(name, worldMap, box, direction, commands);
    }


    @Override
    public void action() {
        mow(box);
        super.action();
        mow(box);
    }

    public void mow(Box box) {
        if (getBox() instanceof GrassBox) {
            mow((GrassBox) box);
        }
    }

    private void mow(GrassBox grassBox) {
        grassBox.setMowed(true);
    }

}