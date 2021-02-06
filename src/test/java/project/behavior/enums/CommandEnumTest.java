package project.behavior.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandEnumTest {

    @Test
    public void testGetEnumByCommandA(){
        CommandEnum commandEnum = CommandEnum.getEnumByCommand("A");
        assertEquals(CommandEnum.AVANCER, commandEnum);
    }

    @Test
    public void testGetEnumByCommandG(){
        CommandEnum commandEnum = CommandEnum.getEnumByCommand("G");
        assertEquals(CommandEnum.TOURNER_GAUCHE, commandEnum);
    }

    @Test
    public void testGetEnumByCommandD(){
        CommandEnum commandEnum = CommandEnum.getEnumByCommand("D");
        assertEquals(CommandEnum.TOURNER_DROITE, commandEnum);
    }

}
