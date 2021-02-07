package project.world.box;

import project.pawn.IPawn;
import project.pawn.IPosition;
import project.pawn.Position;


public class Box implements IBox {

    protected IPosition position;
    protected IPawn pawn = null;

    public Box(int x, int y) {
        this.position = new Position(x, y);
    }

    public Box(Position position) {
        this.position = position;
    }

    public IPosition getPosition() {
        return position;
    }

    public void setPawn(IPawn pawn) {
        this.pawn = pawn;
    }

    public boolean isEmpty() {
        return pawn == null;
    }

    public IPawn getPawn() {
        return pawn;
    }

    @Override
    public String toString() {
        if (pawn != null) {
            return pawn.getName();
        } else {
            return "__";
        }
    }

}
