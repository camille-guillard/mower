package project.world.box;

import project.pawn.Pawn;
import project.pawn.Position;


public class Box {

    protected Position position;
    protected Pawn pawn = null;

    public Box(int x, int y) {
        this.position = new Position(x, y);
    }

    public Box(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public boolean isEmpty() {
        return pawn == null;
    }

    public Pawn getPawn() {
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
