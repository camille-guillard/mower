package project.behavior.impl;

import project.behavior.IDirection;
import project.pawn.Position;

public class SouthDirection implements IDirection {

    public Position movingForward(Position p) {
        return new Position(p.getX(), p.getY() - 1);
    }

    public IDirection turnRight() {
        return new WestDirection();
    }

    public IDirection turnLeft() {
        return new EastDirection();
    }

    @Override
    public String toString() {
        return "SUD";
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}