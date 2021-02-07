package project.behavior;

import project.behavior.impl.EastDirection;
import project.behavior.impl.NorthDirection;
import project.behavior.impl.SouthDirection;
import project.behavior.impl.WestDirection;
import project.pawn.IPosition;

public interface IDirection {

    /** Avance d'une case */
    IPosition movingForward(IPosition p);

    /** Se tourne à 90 degr vers la droite */
    IDirection turnRight();

    /** Se tourne à 90 degr vers la gauche */
    IDirection turnLeft();

    public static IDirection getDirection(char c) {
        switch (c) {
            case 'N':
                return new NorthDirection();
            case 'S':
                return new SouthDirection();
            case 'E':
                return new EastDirection();
            case 'W':
                return new WestDirection();
            default:
                return null;
        }
    }
}