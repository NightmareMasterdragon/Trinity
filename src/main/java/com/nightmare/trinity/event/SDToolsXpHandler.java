package com.nightmare.trinity.event;

import com.nightmare.trinity.Trinity;
import com.nightmare.trinity.content.SDItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;

@EventBusSubscriber(modid = Trinity.MODID) // GAME bus by default
public class SDToolsXpHandler {

    // Double XP from killing mobs with SD weapons/tools
    @SubscribeEvent
    public static void onLivingExperienceDrop(LivingExperienceDropEvent event) {
        Player player = event.getAttackingPlayer();
        if (player == null) return;

        ItemStack held = player.getMainHandItem();
        if (!held.is(SDItemTags.SCULKED_DIAMOND_XP_TOOLS)) return;

        int xp = event.getDroppedExperience();
        if (xp <= 0) return;

        event.setDroppedExperience(xp * 2);
    }
}
