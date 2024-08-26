package me.lutto.resourceutils.mixin;

import me.lutto.resourceutils.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

//@Mixin(ClientPacketListener.class)
//public class SmallTotemMixin {
//
//    @Unique
//    @Final
//    private Minecraft minecraft;
//
//    @Inject(method = "handleEntityEvent", at = @At(value = "INVOKE",
//            target = "Lnet/minecraft/client/renderer/GameRenderer;displayItemActivation(Lnet/minecraft/world/item/ItemStack;)V",
//            shift = At.Shift.BEFORE))
//    private void injectHandleEntityEvent(ClientboundEntityEventPacket packet, CallbackInfo info) {
//        ClientPacketListener.findTotem(this.minecraft.player);
//        this.minecraft.gameRenderer.displayItemActivation(ClientPacketListener.findTotem(this.minecraft.player));
//    }
//
//}

@Mixin(GameRenderer.class)
public class SmallTotemMixin {

    @Shadow
    @Mutable
    private ItemStack itemActivationItem;

    @ModifyArgs(method = "renderItemActivationAnimation", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V"))
    private void injectRenderItemActivationAnimation(Args args) {
        float argument0 = args.get(0);
        float argument1 = args.get(1);
        float argument2 = args.get(2);
        if (itemActivationItem.is(Items.TOTEM_OF_UNDYING) && Config.small_totem != 0) {
            args.set(0, argument0 / ((float) Config.small_totem / 10));
            args.set(1, argument1 / ((float) Config.small_totem / 10));
            args.set(2, argument2 / ((float) Config.small_totem / 10));
        }
    }

}
