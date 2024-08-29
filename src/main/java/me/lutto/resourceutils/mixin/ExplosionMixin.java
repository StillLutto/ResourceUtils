package me.lutto.resourceutils.mixin;

import me.lutto.resourceutils.config.Config;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractSoundInstance.class)
public abstract class ExplosionMixin {

    @Shadow
    @Final
    protected ResourceLocation location;

    @Inject(method = "getVolume", at = @At("HEAD"), cancellable = true)
    private void inject(CallbackInfoReturnable<Float> info) {
        if (Config.no_explosion_sounds && location.getPath().equals("entity.generic.explode"))
            info.cancel();
    }

}
