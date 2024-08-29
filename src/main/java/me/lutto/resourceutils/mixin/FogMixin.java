package me.lutto.resourceutils.mixin;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import me.lutto.resourceutils.config.Config;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
public class FogMixin {

    @Inject(method = "setupFog", at = @At("RETURN"))
    private static void setupFog(Camera camera, FogRenderer.FogMode fogMode, float f, boolean thickFog, float g, CallbackInfo info) {
        FogType fogType = camera.getFluidInCamera();
        Entity entity = camera.getEntity();
        LivingEntity livingEntity = entity instanceof LivingEntity ? (LivingEntity) entity : null;
        if (livingEntity == null) return;

        if (fogType == FogType.LAVA && Config.no_lava_fog) {
            RenderSystem.setShaderFogStart(-8F);
            RenderSystem.setShaderFogEnd(1e6F);
            RenderSystem.setShaderFogShape(FogShape.CYLINDER);
        }
    }

}
