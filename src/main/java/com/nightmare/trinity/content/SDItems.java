package com.nightmare.trinity.content;

import com.nightmare.trinity.Trinity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class SDItems {

    // Item registry (no RegistryObject, just Supplier)
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, Trinity.MODID);

    // Base SD gem
    public static final Supplier<Item> SCULKED_DIAMOND =
            ITEMS.register("sculked_diamond",
                    () -> new Item(new Item.Properties()));

    // Block item for the ore
    public static final Supplier<BlockItem> SCULKED_DIAMOND_ORE_ITEM =
            ITEMS.register("sculked_diamond_ore",
                    () -> new BlockItem(SDBlocks.SCULKED_DIAMOND_ORE.get(), new Item.Properties()));

    // Upgrade template dropped by the Warden
    // For now, we just reuse the netherite template behaviour;
    // later we can swap to a fully custom template & JSON assets.
    public static final Supplier<SmithingTemplateItem> SCULKED_DIAMOND_UPGRADE_TEMPLATE =
            ITEMS.register("sculked_diamond_upgrade_template.json",
                    SmithingTemplateItem::createNetheriteUpgradeTemplate);

    // === SD TOOLS (TEMP: diamond tier, abilities handled via events) ===

    public static final Supplier<SwordItem> SCULKED_DIAMOND_SWORD =
            ITEMS.register("sculked_diamond_sword",
                    () -> new SwordItem(Tiers.DIAMOND, new Item.Properties()));

    public static final Supplier<PickaxeItem> SCULKED_DIAMOND_PICKAXE =
            ITEMS.register("sculked_diamond_pickaxe",
                    () -> new PickaxeItem(Tiers.DIAMOND, new Item.Properties()));

    public static final Supplier<AxeItem> SCULKED_DIAMOND_AXE =
            ITEMS.register("sculked_diamond_axe",
                    () -> new AxeItem(Tiers.DIAMOND, new Item.Properties()));

    public static final Supplier<ShovelItem> SCULKED_DIAMOND_SHOVEL =
            ITEMS.register("sculked_diamond_shovel",
                    () -> new ShovelItem(Tiers.DIAMOND, new Item.Properties()));

    public static final Supplier<HoeItem> SCULKED_DIAMOND_HOE =
            ITEMS.register("sculked_diamond_hoe",
                    () -> new HoeItem(Tiers.DIAMOND, new Item.Properties()));

    // === SD ARMOR ===
    // For now, we piggyback DIAMOND armor material (stats ≈ diamond).
    // We'll upgrade to true 1.5× stats in a separate pass once everything compiles cleanly.

    public static final Supplier<ArmorItem> SCULKED_DIAMOND_HELMET =
            ITEMS.register("sculked_diamond_helmet",
                    () -> new ArmorItem(SDArmorMaterials.SCULKED_DIAMOND,
                            ArmorItem.Type.HELMET,
                            new Item.Properties()));

    public static final Supplier<ArmorItem> SCULKED_DIAMOND_CHESTPLATE =
            ITEMS.register("sculked_diamond_chestplate",
                    () -> new ArmorItem(SDArmorMaterials.SCULKED_DIAMOND,
                            ArmorItem.Type.CHESTPLATE,
                            new Item.Properties()));

    public static final Supplier<ArmorItem> SCULKED_DIAMOND_LEGGINGS =
            ITEMS.register("sculked_diamond_leggings",
                    () -> new ArmorItem(SDArmorMaterials.SCULKED_DIAMOND,
                            ArmorItem.Type.LEGGINGS,
                            new Item.Properties()));

    public static final Supplier<ArmorItem> SCULKED_DIAMOND_BOOTS =
            ITEMS.register("sculked_diamond_boots",
                    () -> new ArmorItem(SDArmorMaterials.SCULKED_DIAMOND,
                            ArmorItem.Type.BOOTS,
                            new Item.Properties()));

    private SDItems() {}
}
