package be.convoy.create.minigamelib.game;

public class RuleSet {
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
}
