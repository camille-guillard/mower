package project.world;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import project.Main;
import project.behavior.IDirection;
import project.pawn.IPawn;
import project.pawn.mower.Mower;

import java.io.*;
import java.util.function.Supplier;

public class WorldMapFactory {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String SEPARATOR = " ";
    private static int numero = 0;

    public static IWorldMap getDefaultWorldMap(String path) {
        return initWorldMap(path, WorldMap::new);
    }

    public static IWorldMap getGrassWorldMap(String path) {
        return initWorldMap(path, GrassWorldMap::new);
    }

    private static IWorldMap initWorldMap(String path, Supplier<? extends WorldMap> worldMapSupplier) {
        IWorldMap worldMap = null;
        try{
            InputStream flux=new FileInputStream(path);
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);

            String ligne = buff.readLine();
            String[] params = ligne.split(SEPARATOR);

            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);

            worldMap = worldMapSupplier.get();
            worldMap.init(x, y);

            while ((ligne = buff.readLine()) != null) {
                params = ligne.split(SEPARATOR);

                String name = "M" + numero++;
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                IDirection direction = IDirection.getDirection(params[2].charAt(0));
                String commands = buff.readLine();

                IPawn mower = new Mower(name, worldMap, worldMap.getBox(x, y), direction, commands);
                worldMap.addPawn(mower);
            }


        } catch (NullPointerException  e) {
            logger.error("Error while reading file parameters: %s", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("The pawn may be out of the bound!: %s", e);
        } catch (IOException e) {
            logger.error("File not found!: %s", e);
        } catch (Exception e) {
            logger.error(e);
        }

        return worldMap;
    }
}
