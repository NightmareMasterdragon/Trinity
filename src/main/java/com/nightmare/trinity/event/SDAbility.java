package com.nightmare.trinity.event;

import com.nightmare.trinity.Trinity;
import com.nightmare.trinity.content.SDItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = Trinity.MODID, bus = EventBusSubscriber.Bus.GAME)
public final class SDAbility {

    private SDAbility() {}

    private static boolean hasFullSculkedDiamondArmor(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).is(SDItems.SCULKED_DIAMOND_HELMET.get())
                && player.getItemBySlot(EquipmentSlot.CHEST).is(SDItems.SCULKED_DIAMOND_CHESTPLATE.get())
                && player.getItemBySlot(EquipmentSlot.LEGS).is(SDItems.SCULKED_DIAMOND_LEGGINGS.get())
                && player.getItemBySlot(EquipmentSlot.FEET).is(SDItems.SCULKED_DIAMOND_BOOTS.get());
    }

    /**
     * Handles:
     *  - Darkness immunity
     *  - Night vision while wearing full SD armor
     */
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        // Only run on server side for logic; client will get effect sync.
        if (player.level().isClientSide) {
            return;
        }

        if (!hasFullSculkedDiamondArmor(player)) {
            // If the player takes the set off, we simply stop reapplying effects.
            return;
        }

        // 1) Immunity to DARKNESS – clear it if present
        if (player.hasEffect(MobEffects.DARKNESS)) {
            player.removeEffect(MobEffects.DARKNESS);
        }

        // 2) Night vision – keep reapplying with a buffer to avoid flicker
        int durationTicks = 220; // 11s buffer, re-applied every tick while armor is worn
        player.addEffect(new MobEffectInstance(
                MobEffects.NIGHT_VISION,
                durationTicks,
                0,
                true,   // ambient
                false,  // showParticles
                false   // showIcon
        ));
    }
}
