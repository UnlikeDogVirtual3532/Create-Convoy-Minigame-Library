package be.convoy.create.minigamelib;

import be.convoy.create.minigamelib.registry.MinigameRegistry;
import be.convoy.create.minigamelib.game.BaseMinigame;
import be.convoy.create.minigamelib.game.MinigameRuleSet;
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

        CreateConvoyMinigameLibrary.LOGGER.info("New Minigame Registered: " + identifier.toString());

        if (clazz != null) {
            MinigameType minigameType = new MinigameType(identifier, clazz);
            registry.register(identifier, minigameType);
            return new MinigameType(identifier, clazz);
        }

        MinigameType minigameType = new MinigameType(identifier, clazz);
        registry.register(identifier, minigameType);
        return new MinigameType(identifier, BaseMinigameType.class);
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

    private class BaseMinigameType extends BaseMinigame {

        @Override
        public MinigameRuleSet applyRuleSet() {
            MinigameRuleSet ruleSet = new MinigameRuleSet();

            return ruleSet;
        }
    }
}