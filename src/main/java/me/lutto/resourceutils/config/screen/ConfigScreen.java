package me.lutto.resourceutils.config.screen;

import me.lutto.resourceutils.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.layouts.HeaderAndFooterLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static me.lutto.resourceutils.ResourceUtils.MOD_ID;

public class ConfigScreen extends OptionsSubScreen {

    private List<Category> categories = new ArrayList<>();

    public ConfigScreen(Screen parent) {
        super(parent, Minecraft.getInstance().options, Component.translatable(MOD_ID + ".config.title"));

        addCategory(new GeneralOptionsScreen(this), "general");
        addCategory(new QuickUtilitiesScreen(this), "quick-utilities");
    }

    @Override
    protected void addOptions() {
        this.list.addSmall(categories.stream().map(category ->
                Button.builder(Component.translatable(category.name),
                        button -> Minecraft.getInstance().setScreen(category.screen))
                .tooltip(Tooltip.create(Component.translatable(category.description)))
                .build()
            ).collect(Collectors.toList())
        );
    }

    private void addCategory(Screen screen, String name) {
        categories.add(new Category(
                screen,
                MOD_ID + ".config.category." + name,
                MOD_ID + ".config.category." + name + ".description"
        ));
    }

    @Override
    public void onClose() {
        super.onClose();
        Config.save();
    }

    private record Category(Screen screen, String name, String description) {}
}
