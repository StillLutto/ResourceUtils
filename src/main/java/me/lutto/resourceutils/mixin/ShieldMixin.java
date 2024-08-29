package me.lutto.resourceutils.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import me.lutto.resourceutils.config.Config;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public class ShieldMixin {

    @Inject(method = "renderItem", at = @At("HEAD"))
    private void renderItem(LivingEntity livingEntity, ItemStack itemStack, ItemDisplayContext itemDisplayContext, boolean bl, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo info) {
        handleShield(livingEntity, itemStack, itemDisplayContext, poseStack);
    }

    private void handleShield(LivingEntity livingEntity, ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack) {
        if (!Config.enabled) return;
        if (!itemDisplayContext.firstPerson()) return;

        if (itemStack.is(Items.SHIELD) && livingEntity.getUseItem().is(Items.SHIELD)) {
            poseStack.translate(0f, -Config.low_held_up_shield / 100f, 0f);
            return;
        }
        if (itemStack.is(Items.SHIELD)) {
            if (Config.side_shield)
                poseStack.mulPose(Axis.YP.rotation(2f));

            poseStack.translate(0f, -Config.low_side_shield / 100f, 0f);
        }
    }

}
