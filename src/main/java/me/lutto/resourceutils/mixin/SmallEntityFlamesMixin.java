package me.lutto.resourceutils.mixin;

import me.lutto.resourceutils.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(EntityRenderDispatcher.class)
public class SmallEntityFlamesMixin {

    @ModifyVariable(method = "renderFlame", at = @At(value = "LOAD", ordinal = 0), ordinal = 0)
    private TextureAtlasSprite injectedFire0(TextureAtlasSprite value) {
        if (!Config.enabled || !Config.small_flame) return value;
        return Minecraft.getInstance().getTextureAtlas(ModelBakery.FIRE_0.atlasLocation()).apply(ResourceLocation.fromNamespaceAndPath("resource-utils", "block/fire_0"));
    }

    @ModifyVariable(method = "renderFlame", at = @At(value = "LOAD", ordinal = 0), ordinal = 1)
    private TextureAtlasSprite injectedFire1(TextureAtlasSprite value) {
        if (!Config.enabled || !Config.small_flame) return value;
        return Minecraft.getInstance().getTextureAtlas(ModelBakery.FIRE_1.atlasLocation()).apply(ResourceLocation.fromNamespaceAndPath("resource-utils", "block/fire_1"));
    }
}
