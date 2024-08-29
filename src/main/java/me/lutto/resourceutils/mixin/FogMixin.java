package me.lutto.resourceutils.mixin;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import me.lutto.resourceutils.config.Config;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(FogRenderer.class)
public class FogMixin {

    @Inject(method = "setupFog", at = @At("RETURN"))
    private static void setupFog(Camera camera, FogRenderer.FogMode fogMode, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo info) {
        if (!(camera.getEntity() instanceof LivingEntity)) return;
        LivingEntity entity = ((LivingEntity) camera.getEntity());
        FogType fluidFogType = camera.getFluidInCamera();

        boolean isFogLavaAndIsEnabled = fluidFogType == FogType.LAVA && Config.no_lava_fog;
        boolean isFogWaterAndIsEnabled = fluidFogType == FogType.WATER && Config.no_underwater_fog;
        boolean isFogPowderSnowAndIsEnabled = fluidFogType == FogType.POWDER_SNOW && Config.no_powder_snow_fog;
        boolean isFogBlindnessAndIsEnabled = entity.hasEffect(MobEffects.BLINDNESS) && Config.no_blindness_fog;
        boolean isFogDarknessAndIsEnabled = entity.hasEffect(MobEffects.DARKNESS) && Config.no_darkness_fog;
        boolean isFogNetherAndIsEnabled = thickFog && Config.no_nether_fog;
        boolean isFogSkyAndIsEnabled = fogMode == FogRenderer.FogMode.FOG_SKY && Config.no_sky_fog;
        boolean isFogOverworldAndIsEnabled = (
                fluidFogType != FogType.LAVA &&
                fluidFogType != FogType.WATER &&
                fluidFogType != FogType.POWDER_SNOW &&
                !entity.hasEffect(MobEffects.BLINDNESS) &&
                !entity.hasEffect(MobEffects.DARKNESS) &&
                !thickFog &&
                fogMode != FogRenderer.FogMode.FOG_SKY
        ) && Config.no_overworld_fog;

        if (isFogLavaAndIsEnabled ||
            isFogWaterAndIsEnabled ||
            isFogPowderSnowAndIsEnabled ||
            isFogBlindnessAndIsEnabled ||
            isFogDarknessAndIsEnabled ||
            isFogNetherAndIsEnabled ||
            isFogSkyAndIsEnabled ||
            isFogOverworldAndIsEnabled
        ) {
            RenderSystem.setShaderFogStart(-8F);
            RenderSystem.setShaderFogEnd(1e6F);
            RenderSystem.setShaderFogShape(FogShape.CYLINDER);
        }
    }

}
