package me.lutto.resourceutils.config.screen;

import me.lutto.resourceutils.config.Config;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;

public abstract class ConfigSubScreen extends OptionsSubScreen {

    public ConfigSubScreen(Screen screen, Options options, Component component) {
        super(screen, options, component);
    }

    @Override
    public void onClose() {
        super.onClose();
        Config.save();
    }

}
