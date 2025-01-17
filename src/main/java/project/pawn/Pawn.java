package project.pawn;

import project.behavior.IDirection;
import project.behavior.enums.CommandEnum;
import project.world.IWorldMap;
import project.world.box.IBox;

import java.util.ArrayList;
import java.util.List;

public abstract class Pawn implements IPawn {

    protected String name;
    protected IWorldMap worldMap;
    protected IBox box;
    protected IDirection direction;
    protected List<CommandEnum> commands;

    public Pawn(String name, IWorldMap worldMap, IBox box, IDirection direction, List<CommandEnum> commands) {
        this.name = name;
        this.worldMap = worldMap;
        this.box = box;
        this.direction = direction;
        this.commands = commands;
    }

    public Pawn(String name, IWorldMap worldMap, IBox box, IDirection direction, String stringCommands) {
        this.name = name;
        this.worldMap = worldMap;
        this.box = box;
        this.direction = direction;
        initCommands(stringCommands);

        if (box != null) {
            box.setPawn(this);
        }
    }

    private void initCommands(String stringCommands) {
        this.commands = new ArrayList<>();
        String [] stringCommandsList = stringCommands.split("");
        for (String s: stringCommandsList) {
            CommandEnum commandEnum = CommandEnum.getEnumByCommand(s);
            if (commandEnum != null) {
                this.commands.add(commandEnum);
            }
        }
    }

    public void run() {
        while(!this.commands.isEmpty()) {
            action();
        }
    }

    public void action() {
        CommandEnum command = this.commands.remove(0);
        move(command);
    }

    public void move(CommandEnum command) {
        switch (command) {
            case AVANCER :
                if (this.worldMap != null) {
                    this.worldMap.move(this);
                }
                break;
            case TOURNER_DROITE : turnRight(); break;
            case TOURNER_GAUCHE : turnLeft(); break;
            default : break;
        }
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void setBox(IBox box) {
        this.box.setPawn(null);
        this.box = box;
        this.box.setPawn(this);
    }

    public String getName() {
        return name;
    }

    public IBox getBox() {
        return box;
    }

    public IDirection getDirection() {
        return direction;
    }


    @Override
    public String toString() {
        return name + " " + box.getPosition().toString() + " " + direction.toString();
    }

}
