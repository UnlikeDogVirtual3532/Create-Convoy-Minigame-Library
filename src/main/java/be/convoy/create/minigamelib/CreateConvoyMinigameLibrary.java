package be.convoy.create.minigamelib;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.convoy.create.minigamelib.registry.CommandRegistry;

public class CreateConvoyMinigameLibrary implements ModInitializer {
	public static final String MOD_ID = "ccml";
	public static final String MOD_NAME = "Create Convoy Minigame Library";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAcces, enviroment) -> {
			CommandRegistry.register(dispatcher);
		});

		MinigameType.register(new Identifier(MOD_ID, MOD_ID));
	}
}