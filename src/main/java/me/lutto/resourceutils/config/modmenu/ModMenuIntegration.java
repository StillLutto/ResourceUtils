package me.lutto.resourceutils.config.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.impl.controller.TickBoxControllerBuilderImpl;
import me.lutto.resourceutils.config.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.chat.Component;

import static me.lutto.resourceutils.ResourceUtils.MOD_ID;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> YetAnotherConfigLib.createBuilder()
                .title(Component.translatable(MOD_ID + ".config.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable(MOD_ID + ".config.category.general"))
                        .tooltip(Component.translatable(MOD_ID + ".config.category.general.tooltip"))
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.enabled"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.enabled.description"))
                                        .build())
                                .binding(true, () -> Config.enabled, value -> Config.enabled = value)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<Integer>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.brightness"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.brightness.description"))
                                        .build())
                                .binding(100, () -> Config.brightness, value -> Config.brightness = value)
                                .controller(option -> IntegerSliderControllerBuilder.create(option).range(100, 15000).step(10))
                                .build())
                        .option(Option.<Integer>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.pumpkin_opacity"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.pumpkin_opacity.description"))
                                        .build())
                                .binding(0, () -> Config.pumpkin_opacity, value -> Config.pumpkin_opacity = value)
                                .controller(option -> IntegerSliderControllerBuilder.create(option).range(0, 100).step(1))
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.clearer_wither_hearts"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.clearer_wither_hearts.description"))
                                        .build())
                                .binding(true, () -> Config.clearer_wither_hearts, value -> Config.clearer_wither_hearts = value)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<Integer>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.low_fire"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.low_fire.description"))
                                        .build())
                                .binding(20, () -> Config.low_fire, value -> Config.low_fire = value)
                                .controller(option -> IntegerSliderControllerBuilder.create(option).range(0, 50).step(1))
                                .build())
                        .option(Option.<Integer>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.low_held_up_shield"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.low_held_up_shield.description"))
                                        .build())
                                .binding(20, () -> Config.low_held_up_shield, value -> Config.low_held_up_shield = value)
                                .controller(option -> IntegerSliderControllerBuilder.create(option).range(0, 50).step(1))
                                .build())
                        .option(Option.<Integer>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.low_side_shield"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.low_side_shield.description"))
                                        .build())
                                .binding(20, () -> Config.low_side_shield, value -> Config.low_side_shield = value)
                                .controller(option -> IntegerSliderControllerBuilder.create(option).range(0, 50).step(1))
                                .build())
                        .option(Option.<Integer>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.shield_size"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.shield_size.description"))
                                        .build())
                                .binding(100, () -> Config.shield_size, value -> Config.shield_size = value)
                                .controller(option -> IntegerSliderControllerBuilder.create(option).range(50, 100).step(1))
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.side_shield"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.side_shield.description"))
                                        .build())
                                .binding(false, () -> Config.side_shield, value -> Config.side_shield = value)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<Integer>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.small_totem"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.small_totem.description"))
                                        .build())
                                .binding(40, () -> Config.small_totem, value -> Config.small_totem = value)
                                .controller(option -> IntegerSliderControllerBuilder.create(option).range(0, 80).step(1))
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.small_fire_model"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.small_fire_model.description"))
                                        .build())
                                .binding(true, () -> Config.small_flame, value -> Config.small_flame = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.no_explosion_sounds"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.no_explosion_sounds.description"))
                                        .build())
                                .binding(false, () -> Config.no_explosion_sounds, value -> Config.no_explosion_sounds = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.no_lava_fog"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.no_lava_fog.description"))
                                        .build())
                                .binding(false, () -> Config.no_lava_fog, value -> Config.no_lava_fog = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.no_underwater_fog"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.no_underwater_fog.description"))
                                        .build())
                                .binding(false, () -> Config.no_underwater_fog, value -> Config.no_underwater_fog = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.no_powder_snow_fog"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.no_powder_snow_fog.description"))
                                        .build())
                                .binding(false, () -> Config.no_powder_snow_fog, value -> Config.no_powder_snow_fog = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.no_overworld_fog"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.no_overworld_fog.description"))
                                        .build())
                                .binding(false, () -> Config.no_overworld_fog, value -> Config.no_overworld_fog  = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.no_nether_fog"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.no_nether_fog.description"))
                                        .build())
                                .binding(false, () -> Config.no_nether_fog, value -> Config.no_nether_fog = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.no_sky_fog"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.no_sky_fog.description"))
                                        .build())
                                .binding(false, () -> Config.no_sky_fog, value -> Config.no_sky_fog = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.no_darkness_fog"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.no_darkness_fog.description"))
                                        .build())
                                .binding(false, () -> Config.no_darkness_fog, value -> Config.no_darkness_fog = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.no_blindness_fog"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.no_blindness_fog.description"))
                                        .build())
                                .binding(false, () -> Config.no_blindness_fog, value -> Config.no_blindness_fog = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .build())
                .save(Config::save)
                .build()
                .generateScreen(parent);
    }

}
