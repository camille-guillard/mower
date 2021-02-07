package project.world;

import project.world.box.Box;
import project.world.box.GrassBox;


public class GrassWorldMap extends WorldMap {

     protected GrassWorldMap() { }

     public void init(int x, int y) {
          this.grid = new Box[x + 1][y + 1];
          for(int i = 0; i <= x; i++) {
               for(int j = 0; j <= y; j++) {
                    grid[i][j] = new GrassBox(i, j);
               }
          }
     }


}
