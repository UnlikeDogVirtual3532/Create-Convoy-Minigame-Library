package be.convoy.create.minigamelib;

import be.convoy.create.minigamelib.registry.MinigameRegistry;
import be.convoy.create.minigamelib.game.BaseMinigame;
import net.minecraft.util.Identifier;

public final class MinigameType {
    private static final MinigameRegistry<MinigameType> registry = MinigameRegistry.create();

    private final Identifier identifier;
    private final Class<? extends BaseMinigame> representer;

    private MinigameType(Identifier identifier, Class<? extends BaseMinigame> representer) {
        this.identifier = identifier;
        this.representer = representer;
    }

    public static MinigameType register(Identifier identifier, Class<? extends BaseMinigame> clazz) {
        MinigameType minigameType = new MinigameType(identifier, clazz);
        
        CreateConvoyMinigameLibrary.LOGGER.info("New Minigame Registered: " + minigameType.getIdentifier().toString());

        return minigameType;
    }

    public static MinigameRegistry<MinigameType> getRegistry() {
        return registry;
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public Class<? extends BaseMinigame> getRepresenter() {
        return this.representer;
    }
}