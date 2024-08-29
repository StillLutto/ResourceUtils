package me.lutto.resourceutils.mixin;

import me.lutto.resourceutils.model.SmallFireModel;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockRenderDispatcher.class)
public abstract class SmallFlamesBlock {

    @Inject(method = "getBlockModel", at = @At("TAIL"), cancellable = true)
    private void inject(BlockState blockState, CallbackInfoReturnable<BakedModel> info) {
        if (blockState.is(Blocks.FIRE)) info.setReturnValue(new SmallFireModel(info.getReturnValue()));
    }

}
