package project.world.box;

import project.pawn.IPawn;
import project.pawn.IPosition;

public interface IBox {
    IPawn getPawn();

    void setPawn(IPawn pawn);

    IPosition getPosition();

    boolean isEmpty();
}
