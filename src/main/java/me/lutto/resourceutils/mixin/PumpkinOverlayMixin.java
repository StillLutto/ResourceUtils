package me.lutto.resourceutils.mixin;

import me.lutto.resourceutils.config.Config;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Gui.class)
public class PumpkinOverlayMixin {

    @ModifyArgs(method = "renderTextureOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;setColor(FFFF)V", ordinal = 0))
    private void inject(Args args) {
        args.set(3, (float) Config.pumpkin_opacity / 100);
    }

}
