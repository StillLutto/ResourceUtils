package me.lutto.resourceutils.config.screen;

import me.lutto.resourceutils.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import static me.lutto.resourceutils.ResourceUtils.MOD_ID;

public class GeneralOptionsScreen extends ConfigSubScreen {

    public GeneralOptionsScreen(Screen screen) {
        super(screen, Minecraft.getInstance().options, Component.translatable(MOD_ID + ".config.category.general"));
    }

    @Override
    protected void addOptions() {
        this.list.addSmall(
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.enabled",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.enabled.description")),
                        Config.enabled,
                        value -> Config.enabled = value
                )
        );
    }
}
