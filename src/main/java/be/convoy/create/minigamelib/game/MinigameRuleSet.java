package be.convoy.create.minigamelib.game;

import java.util.HashMap;

import be.convoy.create.minigamelib.CreateConvoyMinigameLibrary;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;

public class MinigameRuleSet {
    private GameMode gameMode = GameMode.SURVIVAL;
    private LobbyMode lobbyMode = LobbyMode.NONE;
    private HashMap<DamageTypes, Object> damageTypes = new HashMap<DamageTypes, Object>();

    public enum GameMode {
        CREATIVE,
        SURVIVAL,
        ADVENTURE,
        SPECTATOR
    }

    public enum LobbyMode {
        PARTY_INNER,
        PARTY_OUTER,
        REQUIREMENT,
        NONE
    }

    public enum DamageTypes {
        PLAYER,
        ENTITY,
        LIGHTNING,
        FALL_DAMAGE,
        FALLING_BLOCK,
        THORNS_ENCHANTMENT,
        SUFFOCATION,
        DROWNING,
        STARVATION,
        CACTUS,
        BERRY_BUSH,
        FIRE,
        LAVA,
        BURNING,
        MAGMA_BLOCK,
        CAMPFIRE,
        STATUS_EFFECTS,
        INSTANT_DAMAGE,
        POISON,
        WITHER,
        VOID,
        EXPLOSIONS,
        FIREWORK_ROCKET_EXPLOSION,
        FREEZING
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setLobbyMode(LobbyMode lobbyMode) {
        this.lobbyMode = lobbyMode;
    }

    public void setDamage(DamageTypes damageType, Object object) {
        this.damageTypes.put(damageType, object);
    }

    public void setGameRule(GameRules.Key<GameRules.BooleanRule> rule, Boolean value) {
        MinecraftServer server = CreateConvoyMinigameLibrary.MINECRAFT_SERVER;

        if (server == null) {
            throw new IllegalStateException("Server is not available");
        }

        server.getGameRules().get(rule).set((Boolean) value, server);
    }

    public void setGameRule(GameRules.Key<GameRules.IntRule> rule, Integer value) {
        MinecraftServer server = CreateConvoyMinigameLibrary.MINECRAFT_SERVER;

        if (server == null) {
            throw new IllegalStateException("Server is not available");
        }

        server.getGameRules().get(rule).set((Integer) value, server);
    }
}
