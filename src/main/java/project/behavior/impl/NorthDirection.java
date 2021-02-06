package project.behavior.impl;

import project.behavior.IDirection;
import project.pawn.Position;

public class NorthDirection implements IDirection {

    public Position movingForward(Position p) {
        return new Position(p.getX(), p.getY() + 1);
    }

    public IDirection turnRight() {
        return new EastDirection();
    }

    public IDirection turnLeft() {
        return new WestDirection();
    }

    @Override
    public String toString() {
        return "NORD";
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}