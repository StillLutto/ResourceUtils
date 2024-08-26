package me.lutto.resourceutils.config.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
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
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable(MOD_ID + ".config.option.side_shield"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable(MOD_ID + ".config.option.side_shield.description"))
                                        .build())
                                .binding(true, () -> Config.side_shield, value -> Config.side_shield = value)
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
                        .build())
                .save(Config::save)
                .build()
                .generateScreen(parent);
    }

}
