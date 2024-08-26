package me.lutto.resourceutils.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import me.lutto.resourceutils.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenEffectRenderer.class)
public class LowFireMixin {

    @Inject(method = "renderFire", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V", shift = At.Shift.BEFORE))
    private static void renderFire(Minecraft client, PoseStack matrices, CallbackInfo ci) {
        if (Config.enabled)
            matrices.translate(0, -Config.low_fire / 100F, 0);
    }

}
