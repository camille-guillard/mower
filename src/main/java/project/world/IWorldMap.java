package project.world;

import project.pawn.IPawn;
import project.world.box.IBox;

public interface IWorldMap extends Runnable {

    void init(int x, int y);

    boolean move(IPawn pawn);

    IBox getBox(int x, int y);

    void addPawn(IPawn pawn);

}
