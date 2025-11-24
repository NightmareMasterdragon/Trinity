package com.nightmare.trinity.content;

import com.nightmare.trinity.Trinity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SDItemTags {

    public static final TagKey<Item> SCULKED_DIAMOND_XP_TOOLS =
            TagKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(Trinity.MODID, "sculked_diamond_xp_tools")
            );
}