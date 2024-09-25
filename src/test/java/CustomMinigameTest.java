import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.convoy.create.minigamelib.MinigameType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import static org.junit.Assert.*;

import org.junit.Before;

public class CustomMinigameTest {
    public static final String MOD_ID = "ccml-test";
	public static final String MOD_NAME = "Create Convoy Minigame Library Test";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private MinigameType minigame;
    private ServerPlayerEntity mockPlayer;

    @Before
    public void setup() {
        MinigameType minigame = MinigameType.register(new Identifier(MOD_ID, "custom-minigame"), CustomMinigame.class);

        mockPlayer = Mockito.mock(ServerPlayerEntity.class);
    }

    @Test
    public void testPlayerJoiningMinigame() {
        LOGGER.info(minigame.getIdentifier().toString());
    }
}