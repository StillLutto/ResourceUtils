package me.lutto.resourceutils;

import me.lutto.resourceutils.config.Config;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceUtils implements ClientModInitializer {

    public static String MOD_ID = "resource-utils";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        Config.load();

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            var main = ClientCommandManager.literal("resourceutils");
            dispatcher.register(main);
        });
    }

}
