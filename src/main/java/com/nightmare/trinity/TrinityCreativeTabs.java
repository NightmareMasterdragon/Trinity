package com.nightmare.trinity;

import com.nightmare.trinity.content.SDItems;
import com.nightmare.trinity.content.SDBlocks;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = Trinity.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class TrinityCreativeTabs {

    private TrinityCreativeTabs() {}

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Ingredients tab: gems + template
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(SDItems.SCULKED_DIAMOND.get());
            event.accept(SDItems.SCULKED_DIAMOND_UPGRADE_TEMPLATE.get());
        }

        // Natural blocks: ore
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(SDBlocks.SCULKED_DIAMOND_ORE.get());
        }

        // Tools
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(SDItems.SCULKED_DIAMOND_PICKAXE.get());
            event.accept(SDItems.SCULKED_DIAMOND_AXE.get());
            event.accept(SDItems.SCULKED_DIAMOND_SHOVEL.get());
            event.accept(SDItems.SCULKED_DIAMOND_HOE.get());
        }

        // Combat: sword + armor
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(SDItems.SCULKED_DIAMOND_SWORD.get());
            event.accept(SDItems.SCULKED_DIAMOND_HELMET.get());
            event.accept(SDItems.SCULKED_DIAMOND_CHESTPLATE.get());
            event.accept(SDItems.SCULKED_DIAMOND_LEGGINGS.get());
            event.accept(SDItems.SCULKED_DIAMOND_BOOTS.get());
        }
    }
}