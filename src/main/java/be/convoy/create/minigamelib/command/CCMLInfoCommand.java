package be.convoy.create.minigamelib.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import be.convoy.create.minigamelib.CreateConvoyMinigameLibrary;
import be.convoy.create.minigamelib.MinigameType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import java.util.Collection;

public class CCMLInfoCommand implements Command<ServerCommandSource> {

    public String minigameRegistryArrayToString(Collection<MinigameType> array) {
        String convertedArray = "";

        int lengthIndex = 0;
        for (@SuppressWarnings("unused") MinigameType arrayLength : array) {
            lengthIndex++;
        }

        int index = 0;
        for (MinigameType item : array) {
            index++;
            if (index == lengthIndex)  {
                convertedArray = convertedArray + item.getIdentifier().toString();
            } else {
                convertedArray =  convertedArray + item.getIdentifier().toString() + ", ";
            }
        }

        return convertedArray;
    }

    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        if (getClass().getPackage().getImplementationVersion() == null) {
            context.getSource().sendFeedback(() -> Text.literal(CreateConvoyMinigameLibrary.MOD_NAME + ": \nID " + CreateConvoyMinigameLibrary.MOD_ID + " \nVersion DEVELOPMENT" + "\nAuthorized Packages " + minigameRegistryArrayToString(MinigameType.getRegistry().values())), false);
        } else {
            context.getSource().sendFeedback(() -> Text.literal(CreateConvoyMinigameLibrary.MOD_NAME + ": \nID " + CreateConvoyMinigameLibrary.MOD_ID + " \nVersion " + getClass().getPackage().getImplementationVersion() + "\nAuthorized Packages " + minigameRegistryArrayToString(MinigameType.getRegistry().values())), false);
        }

        return 1;
    }
}
