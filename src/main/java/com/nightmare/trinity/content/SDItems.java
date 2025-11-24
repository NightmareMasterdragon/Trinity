package com.nightmare.trinity.content;

import com.nightmare.trinity.Trinity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
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
            ITEMS.register("sculked_diamond_upgrade_template",
                    SmithingTemplateItem::createNetheriteUpgradeTemplate);

    // === SD TOOLS (TEMP: diamond tier, abilities handled via events) ===

    // Sword
    public static final DeferredHolder<Item, SwordItem> SCULKED_DIAMOND_SWORD = ITEMS.register(
            "sculked_diamond_sword",
            () -> new SwordItem(SDToolTiers.SCULKED_DIAMOND, new Item.Properties())
    );

    // Pickaxe
    public static final DeferredHolder<Item, PickaxeItem> SCULKED_DIAMOND_PICKAXE = ITEMS.register(
            "sculked_diamond_pickaxe",
            () -> new PickaxeItem(SDToolTiers.SCULKED_DIAMOND, new Item.Properties())
    );

    // Axe
    public static final DeferredHolder<Item, AxeItem> SCULKED_DIAMOND_AXE = ITEMS.register(
            "sculked_diamond_axe",
            () -> new AxeItem(SDToolTiers.SCULKED_DIAMOND, new Item.Properties())
    );

    // Shovel
    public static final DeferredHolder<Item, ShovelItem> SCULKED_DIAMOND_SHOVEL = ITEMS.register(
            "sculked_diamond_shovel",
            () -> new ShovelItem(SDToolTiers.SCULKED_DIAMOND, new Item.Properties())
    );

    // Hoe
    public static final DeferredHolder<Item, HoeItem> SCULKED_DIAMOND_HOE = ITEMS.register(
            "sculked_diamond_hoe",
            () -> new HoeItem(SDToolTiers.SCULKED_DIAMOND, new Item.Properties())
    );

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
