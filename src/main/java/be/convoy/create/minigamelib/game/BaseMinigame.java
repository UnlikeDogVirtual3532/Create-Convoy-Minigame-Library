package be.convoy.create.minigamelib.game;

import be.convoy.create.minigamelib.MinigameType;
import be.convoy.create.minigamelib.game.MinigameRuleSet;

public abstract class BaseMinigame {
    public BaseMinigame() {
        MinigameType.register(null, this.getClass());
    }

    public abstract MinigameRuleSet applyRuleSet();
}
