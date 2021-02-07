package project.behavior.impl;

import project.behavior.IDirection;
import project.pawn.IPosition;
import project.pawn.Position;

public class WestDirection implements IDirection {

    public IPosition movingForward(IPosition p) {
        return new Position(p.getX() - 1, p.getY());
    }

    public IDirection turnRight() {
        return new NorthDirection();
    }

    public IDirection turnLeft() {
        return new SouthDirection();
    }

    @Override
    public String toString() {
        return "OUEST";
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}