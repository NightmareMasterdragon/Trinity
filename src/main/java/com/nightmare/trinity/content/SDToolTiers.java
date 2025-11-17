package com.nightmare.trinity.content;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public final class SDToolTiers {

    // Sculked Diamond tools: strictly better than diamond (≈1.5x main stats).
    public static final Tier SCULKED_DIAMOND = new SimpleTier(
            // Use the same "incorrect" tag as diamond tools (you can make your own later).
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            (int) (Tiers.DIAMOND.getUses() * 1.5f),        // durability
            Tiers.DIAMOND.getSpeed() * 1.5f,               // mining speed
            Tiers.DIAMOND.getAttackDamageBonus() * 1.5f,   // tier damage bonus
            (int) (Tiers.DIAMOND.getEnchantmentValue() * 1.5f), // enchantability
            () -> Ingredient.of(SDItems.SCULKED_DIAMOND.get())
    );

    private SDToolTiers() {}
}