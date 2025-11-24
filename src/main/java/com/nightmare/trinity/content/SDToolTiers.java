package com.nightmare.trinity.content;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum SDToolTiers implements Tier {

    SCULKED_DIAMOND(
            (int) (Tiers.DIAMOND.getUses() * 1.5f),                // durability
            Tiers.DIAMOND.getSpeed() * 1.5f,                       // mining speed
            Tiers.DIAMOND.getAttackDamageBonus() * 1.5f,           // damage bonus
            Tiers.DIAMOND.getIncorrectBlocksForDrops(),            // same harvest tag as diamond
            (int) Math.round(Tiers.DIAMOND.getEnchantmentValue() * 1.5f) // enchantability
    );

    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final TagKey<Block> incorrectBlocksForDrops;
    private final int enchantmentValue;

    SDToolTiers(int uses,
                float speed,
                float attackDamageBonus,
                TagKey<Block> incorrectBlocksForDrops,
                int enchantmentValue) {
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.enchantmentValue = enchantmentValue;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(SDItems.SCULKED_DIAMOND.get());
    }
}