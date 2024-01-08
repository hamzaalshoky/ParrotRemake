package net.itshamza.pr.entity;

import net.itshamza.pr.ParrotRemake;
import net.itshamza.pr.entity.client.ParrotModel;
import net.itshamza.pr.entity.client.ParrotRenderer;
import net.itshamza.pr.entity.custom.ParrotEntity;
import net.itshamza.pr.entity.layer.ModModelLayers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ParrotRemake.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityCreator {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ParrotRemake.MOD_ID);

    //REGISTRIES

    public static final RegistryObject<EntityType<ParrotEntity>> PARROT =
            ENTITY_TYPES.register("parrot", () -> EntityType.Builder.of(ParrotEntity::new, MobCategory.CREATURE)
                    .sized(0.4f, 0.7f).build("parrot"));

    //RENDERERS

    @SubscribeEvent
    public static void registerEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityCreator.PARROT.get(), ParrotRenderer::new);
    }

    //LAYERS

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.PARROT_LAYER, ParrotModel::createBodyLayer);
    }

    //ATTRIBUTES

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityCreator.PARROT.get(), ParrotEntity.createAttributes().build());
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
