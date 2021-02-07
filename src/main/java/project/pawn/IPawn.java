package project.pawn;

import project.behavior.IDirection;
import project.world.box.IBox;

public interface IPawn extends Movable, Actionable, Runnable {

    IDirection getDirection();

    void setBox(IBox box);

    IBox getBox();

    String getName();
}
