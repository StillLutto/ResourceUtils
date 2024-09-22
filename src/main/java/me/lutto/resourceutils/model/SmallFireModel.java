package me.lutto.resourceutils.model;

import me.lutto.resourceutils.config.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.fabricmc.fabric.impl.renderer.VanillaModelEncoder;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class SmallFireModel implements BakedModel, FabricBakedModel {

    private static final TextureAtlasSprite FIRE_SPRITE = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.fromNamespaceAndPath("resource-utils", "block/fire_0")).sprite();

    private BakedModel model;

    public SmallFireModel(BakedModel model) {
        this.model = model;
    }

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, RandomSource random) {
        List<BakedQuad> beforeTempList = model.getQuads(state, face, random);
        List<BakedQuad> tempList = new ArrayList<>();
        for(int g = 0; g < beforeTempList.size(); g++) {
            tempList.add(g, beforeTempList.get(g));
        }

        for (int n = 0; n < tempList.size(); n++) {
            int[] verticesOriginal = tempList.get(n).getVertices();
            int[] verticesNew = new int[32];

            for (int cornerIndex = 0; cornerIndex < 4; ++cornerIndex) {
                int i = cornerIndex * 8;
                float min1U = tempList.get(n).getSprite().getU0();
                float max1U = tempList.get(n).getSprite().getU1();
                float min2U = FIRE_SPRITE.getU0();
                float max2U = FIRE_SPRITE.getU1();
                float min1V = tempList.get(n).getSprite().getV0();
                float max1V = tempList.get(n).getSprite().getV1();
                float min2V = FIRE_SPRITE.getV0();
                float max2V = FIRE_SPRITE.getV1();

                verticesNew[i] = verticesOriginal[i];
                verticesNew[i + 1] = verticesOriginal[i + 1];
                verticesNew[i + 2] = verticesOriginal[i + 2];
                verticesNew[i + 3] = verticesOriginal[i + 3];
                verticesNew[i + 4] = Float.floatToRawIntBits((Float.intBitsToFloat(verticesOriginal[i + 4]) - min1U) * (max2U - min2U) / (max1U - min1U) + min2U);
                verticesNew[i + 4 + 1] = Float.floatToRawIntBits((Float.intBitsToFloat(verticesOriginal[i + 4 + 1]) - min1V) * (max2V - min2V) / (max1V - min1V) + min2V);
            }
            BakedQuad bakedQuad = new BakedQuad(verticesNew, 0, tempList.get(n).getDirection(), FIRE_SPRITE, tempList.get(n).isShade());
            tempList.set(n, bakedQuad);
        }
        return tempList;
    }

    @Override
    public boolean useAmbientOcclusion() {
        return model.useAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return model.isGui3d();
    }

    @Override
    public boolean usesBlockLight() {
        return model.usesBlockLight();
    }

    @Override
    public boolean isCustomRenderer() {
        return model.isCustomRenderer();
    }

    @Override
    public @NotNull TextureAtlasSprite getParticleIcon() {
        return model.getParticleIcon();
    }

    @Override
    public ItemTransforms getTransforms() {
        return model.getTransforms();
    }

    @Override
    public ItemOverrides getOverrides() {
        return model.getOverrides();
    }

    @Override
    public void emitBlockQuads(BlockAndTintGetter blockView, BlockState state, BlockPos pos, Supplier<RandomSource> randomSupplier, RenderContext context) {
        if (!Config.small_fire_model)
            model.emitBlockQuads(blockView, state, pos, randomSupplier, context);
        VanillaModelEncoder.emitBlockQuads(this, state, randomSupplier, context);
    }

}
