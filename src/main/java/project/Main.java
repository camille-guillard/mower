package project;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import project.world.WorldMap;
import project.world.WorldMapFactory;

public class Main {

    static {
        BasicConfigurator.configure();
    }

    private static final String path = "src/main/resources/input/config.properties";

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String ...args) {

        try {
            WorldMap worldMap = WorldMapFactory.getGrassWorldMap(path);

            logger.info(worldMap.toString());
            worldMap.run();
            logger.info(worldMap.toString());

        } catch (NullPointerException e) {
            logger.error("The world map is null!");
        }



    }
}
