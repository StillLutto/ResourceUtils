package me.lutto.resourceutils.config.screen;

import me.lutto.resourceutils.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import static me.lutto.resourceutils.ResourceUtils.MOD_ID;

public class QuickUtilitiesScreen extends ConfigSubScreen {

    public QuickUtilitiesScreen(Screen screen) {
        super(screen, Minecraft.getInstance().options, Component.translatable(MOD_ID + ".config.category.quick-utilities"));
    }

    @Override
    protected void addOptions() {
        this.list.addSmall(
                new OptionInstance<>(
                        MOD_ID + ".config.option.brightness",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.brightness.description")),
                        Options::genericValueLabel,
                        new OptionInstance.IntRange(100, 1500),
                        Config.brightness,
                        value -> Config.brightness = value
                ),
                new OptionInstance<>(
                        MOD_ID + ".config.option.pumpkin_opacity",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.pumpkin_opacity.description")),
                        Options::genericValueLabel,
                        new OptionInstance.IntRange(0, 100),
                        Config.pumpkin_opacity,
                        value -> Config.pumpkin_opacity = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.clearer_wither_hearts",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.clearer_wither_hearts.description")),
                        Config.clearer_wither_hearts,
                        value -> Config.clearer_wither_hearts = value
                ),
                new OptionInstance<>(
                        MOD_ID + ".config.option.low_fire",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.low_fire.description")),
                        Options::genericValueLabel,
                        new OptionInstance.IntRange(0, 50),
                        Config.low_fire,
                        value -> Config.low_fire = value
                ),
                new OptionInstance<>(
                        MOD_ID + ".config.option.low_held_up_shield",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.low_held_up_shield.description")),
                        Options::genericValueLabel,
                        new OptionInstance.IntRange(0, 50),
                        Config.low_held_up_shield,
                        value -> Config.low_held_up_shield = value
                ),
                new OptionInstance<>(
                        MOD_ID + ".config.option.shield_size",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.shield_size.description")),
                        Options::genericValueLabel,
                        new OptionInstance.IntRange(50, 100),
                        Config.shield_size,
                        value -> Config.shield_size = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.side_shield",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.side_shield.description")),
                        Config.side_shield,
                        value -> Config.side_shield = value
                ),
                new OptionInstance<>(
                        MOD_ID + ".config.option.small_totem",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.small_totem.description")),
                        Options::genericValueLabel,
                        new OptionInstance.IntRange(0, 80),
                        Config.small_totem,
                        value -> Config.small_totem = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.small_fire_model",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.small_fire_model.description")),
                        Config.small_fire_model,
                        value -> Config.small_fire_model = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_explosion_sounds",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_explosion_sounds.description")),
                        Config.no_explosion_sounds,
                        value -> Config.no_explosion_sounds = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_lava_fog",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_lava_fog.description")),
                        Config.no_lava_fog,
                        value -> Config.no_lava_fog = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_underwater_fog",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_underwater_fog.description")),
                        Config.no_underwater_fog,
                        value -> Config.no_underwater_fog = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_lava_fog",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_lava_fog.description")),
                        Config.no_lava_fog,
                        value -> Config.no_lava_fog = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_powder_snow_fog",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_lava_fog.description")),
                        Config.no_powder_snow_fog,
                        value -> Config.no_powder_snow_fog = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_overworld_fog",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_lava_fog.description")),
                        Config.no_overworld_fog,
                        value -> Config.no_overworld_fog = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_nether_fog",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_nether_fog.description")),
                        Config.no_nether_fog,
                        value -> Config.no_nether_fog = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_sky_fog",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_sky_fog.description")),
                        Config.no_sky_fog,
                        value -> Config.no_sky_fog = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_darkness_fog",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_darkness_fog.description")),
                        Config.no_darkness_fog,
                        value -> Config.no_darkness_fog = value
                ),
                OptionInstance.createBoolean(
                        MOD_ID + ".config.option.no_blindness_fog",
                        OptionInstance.cachedConstantTooltip(Component.translatable(MOD_ID + ".config.option.no_blindness_fog.description")),
                        Config.no_darkness_fog,
                        value -> Config.no_darkness_fog = value
                )
        );
    }
}