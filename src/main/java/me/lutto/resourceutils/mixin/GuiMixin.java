package me.lutto.resourceutils.mixin;

import me.lutto.resourceutils.config.Config;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Gui.class)
public class GuiMixin {

    @ModifyArgs(method = "renderTextureOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;setColor(FFFF)V", ordinal = 0))
    private void injectRenderTextureOverlay(Args args) {
        args.set(3, (float) Config.pumpkin_opacity / 100);
    }

    @ModifyArgs(method = "renderHeart", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V"))
    private void injectRenderHeart(Args args) {
        String path = ((ResourceLocation) args.get(0)).getPath();
        if (path.contains("withered")) args.set(0, ResourceLocation.fromNamespaceAndPath("resource-utils", path));
    }

}
