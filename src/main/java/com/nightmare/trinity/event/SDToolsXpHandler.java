package com.nightmare.trinity.event;

import com.nightmare.trinity.Trinity;
import com.nightmare.trinity.content.SDItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;

@EventBusSubscriber(modid = Trinity.MODID) // GAME bus
public class SDToolsXpHandler {

    private static boolean isSculkedDiamondTool(ItemStack stack) {
        if (stack.isEmpty()) return false;

        Item item = stack.getItem();
        return item == SDItems.SCULKED_DIAMOND_SWORD.get()
                || item == SDItems.SCULKED_DIAMOND_PICKAXE.get()
                || item == SDItems.SCULKED_DIAMOND_AXE.get()
                || item == SDItems.SCULKED_DIAMOND_SHOVEL.get()
                || item == SDItems.SCULKED_DIAMOND_HOE.get();
    }

    // 1) Double XP from killing mobs with SD tools
    @SubscribeEvent
    public static void onLivingExperienceDrop(LivingExperienceDropEvent event) {
        Player player = event.getAttackingPlayer();
        if (player == null) return;

        ItemStack held = player.getMainHandItem();
        if (!isSculkedDiamondTool(held)) return;

        int xp = event.getDroppedExperience();
        if (xp <= 0) return;

        event.setDroppedExperience(xp * 2);
    }

    // 2) 1.5× damage when hitting with SD
}
