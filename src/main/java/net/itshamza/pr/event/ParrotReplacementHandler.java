package net.itshamza.pr.event;

import net.itshamza.pr.ParrotRemake;
import net.itshamza.pr.entity.ModEntityCreator;
import net.itshamza.pr.entity.custom.ParrotEntity;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ParrotRemake.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ParrotReplacementHandler {

    @SubscribeEvent
    public static void onEntityJoinWorld(MobSpawnEvent event) {
        if (event.getEntity() instanceof Parrot) {
            Parrot wolf = (Parrot) event.getEntity();
            event.setCanceled(true);// Prevent the wolf from spawning

            // Spawn your custom mob entity in place of the wolf
            ParrotEntity customMob = new ParrotEntity(ModEntityCreator.PARROT.get(), wolf.level());
            customMob.setPos(wolf.position().x, wolf.position().y, wolf.position().z);
            wolf.level().addFreshEntity(customMob);
            wolf.setSpawnCancelled(true);
        }
    }
}
