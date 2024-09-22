package be.convoy.create.minigamelib.registry;

import com.mojang.brigadier.CommandDispatcher;

import be.convoy.create.minigamelib.command.CCMLInfoCommand;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class CommandRegistry {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("ccml")
            .requires(source -> source.hasPermissionLevel(0))
            .then(CommandManager.literal("info")
                .requires(source -> source.hasPermissionLevel(0))
                .executes(new CCMLInfoCommand()))
            );
    }
}
