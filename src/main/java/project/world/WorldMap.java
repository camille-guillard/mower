package project.world;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import project.pawn.IPawn;
import project.pawn.IPosition;
import project.world.box.Box;
import project.world.box.IBox;

import java.util.ArrayList;
import java.util.List;

public class WorldMap implements IWorldMap {

     private static final Logger logger = LogManager.getLogger(WorldMap.class);

     protected IBox[][] grid;
     List<IPawn> pawns = new ArrayList<>();

     protected WorldMap() { }

     public void init(int x, int y) {
          this.grid = new Box[x + 1][y + 1];
          for(int i = 0; i <= x; i++) {
               for(int j = 0; j <= y; j++) {
                    grid[i][j] = new Box(i, j);
               }
          }
     }

     protected IBox[][] getGrid() {
          return grid;
     }

     public IBox getBox(int x, int y) throws ArrayIndexOutOfBoundsException {
          return this.grid[x][y];
     }

     public void run() {
          for (IPawn pawn: pawns) {
               logger.info("start - " + pawn.toString());
               pawn.run();
               logger.info("end - " + pawn.toString()+ "\n");
          }
     }

     public boolean move(IPawn pawn) {
          boolean result = false;
          IPosition newPosition;

          try {
               newPosition = pawn.getDirection().movingForward(pawn.getBox().getPosition());
               IBox newBox = getBox(newPosition.getX(), newPosition.getY());

               if (newBox.isEmpty()) {
                    pawn.setBox(newBox);
                    result = true;
               }

          } catch (ArrayIndexOutOfBoundsException e) {
               logger.error("ArrayIndexOutOfBoundsException " + pawn.toString());
          }

          return result;
     }

     public void addPawn(IPawn pawn) {
          this.pawns.add(pawn);
     }

     public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append("print world map\n\n");

          for(int j = grid[0].length - 1; j >= 0 ; j--) {
               for(int i=0; i < grid.length; i++) {
                    sb.append("    " + grid[i][j].toString() + "    ");

               }
               sb.append("\n");
          }


          return sb.toString();
     }

}
