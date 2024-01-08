package net.itshamza.pr.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.itshamza.pr.ParrotRemake;
import net.itshamza.pr.entity.custom.ParrotEntity;
import net.itshamza.pr.entity.layer.ModModelLayers;
import net.itshamza.pr.entity.variant.ParrotVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class ParrotRenderer extends MobRenderer<ParrotEntity, ParrotModel<ParrotEntity>> {
    private static final Map<ParrotVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ParrotVariant.class), map -> {
                map.put(ParrotVariant.RED_MACAW,
                        new ResourceLocation(ParrotRemake.MOD_ID, "textures/entity/parrot.png"));
                map.put(ParrotVariant.BLUE_MACAW,
                        new ResourceLocation(ParrotRemake.MOD_ID, "textures/entity/parrot_macaw_blue.png"));
                map.put(ParrotVariant.AFRICAN_GREY,
                        new ResourceLocation(ParrotRemake.MOD_ID, "textures/entity/parrot_african_grey.png"));
                map.put(ParrotVariant.LOVEBIRD,
                        new ResourceLocation(ParrotRemake.MOD_ID, "textures/entity/parrot_lovebird.png"));
                map.put(ParrotVariant.COCKATOO,
                        new ResourceLocation(ParrotRemake.MOD_ID, "textures/entity/parrot_cockatoo.png"));
            });

    public ParrotRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ParrotModel<>(pContext.bakeLayer(ModModelLayers.PARROT_LAYER)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(ParrotEntity pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }


    @Override
    public void render(ParrotEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
