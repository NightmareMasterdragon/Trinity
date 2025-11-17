package com.nightmare.trinity.content;

import com.nightmare.trinity.Trinity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemAttributeModifiers;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryObject;

public final class SDItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, Trinity.MODID);

    // ===== Base SD material =====
    public static final RegistryObject<Item> SCULKED_DIAMOND = ITEMS.register(
            "sculked_diamond",
            () -> new Item(new Item.Properties())
    );

    // Ore block item
    public static final RegistryObject<Item> SCULKED_DIAMOND_ORE_ITEM = ITEMS.register(
            "sculked_diamond_ore",
            () -> new BlockItem(SDBlocks.SCULKED_DIAMOND_ORE.get(), new Item.Properties())
    );

    // ===== Smithing upgrade template dropped by Warden =====
    public static final RegistryObject<Item> SCULKED_DIAMOND_UPGRADE_TEMPLATE = ITEMS.register(
            "sculked_diamond_upgrade_template",
            () -> new SmithingTemplateItem(
                    // You can tweak these descriptions later with proper translatable components;
                    // for now just placeholders.
                    SmithingTemplateItem.createNetheriteUpgradeTemplate(),
                    SmithingTemplateItem.createNetheriteUpgradeTemplate(),
                    Trinity.translatable("item.trinity.sculked_diamond_upgrade_template.applies_to"),
                    Trinity.translatable("item.trinity.sculked_diamond_upgrade_template.ingredients"),
                    Trinity.translatable("upgrade.trinity.sculked_diamond_upgrade"),
                    Trinity.translatable("item.trinity.sculked_diamond_upgrade_template.base_slot_description"),
                    Trinity.translatable("item.trinity.sculked_diamond_upgrade_template.additions_slot_description")
            )
    );

    // ===== SD TOOLS =====
    // NOTE: these use the NeoForge 1.21.1 pattern with createAttributes().

    public static final RegistryObject<SwordItem> SCULKED_DIAMOND_SWORD = ITEMS.register(
            "sculked_diamond_sword",
            () -> new SwordItem(
                    SDToolTiers.SCULKED_DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(
                                    SDToolTiers.SCULKED_DIAMOND,
                                    3,      // base sword damage part; we’ll fine-tune later if needed
                                    -2.4f   // same swing speed as diamond swords
                            )
                    )
            )
    );

    public static final RegistryObject<PickaxeItem> SCULKED_DIAMOND_PICKAXE = ITEMS.register(
            "sculked_diamond_pickaxe",
            () -> new PickaxeItem(
                    SDToolTiers.SCULKED_DIAMOND,
                    new Item.Properties().attributes(
                            net.minecraft.world.item.PickaxeItem.createAttributes(
                                    SDToolTiers.SCULKED_DIAMOND,
                                    1,      // base damage for pickaxes
                                    -2.8f
                            )
                    )
            )
    );

    public static final RegistryObject<AxeItem> SCULKED_DIAMOND_AXE = ITEMS.register(
            "sculked_diamond_axe",
            () -> new AxeItem(
                    SDToolTiers.SCULKED_DIAMOND,
                    new Item.Properties().attributes(
                            AxeItem.createAttributes(
                                    SDToolTiers.SCULKED_DIAMOND,
                                    5,      // axe base damage; adjust by feel
                                    -3.0f
                            )
                    )
            )
    );

    public static final RegistryObject<ShovelItem> SCULKED_DIAMOND_SHOVEL = ITEMS.register(
            "sculked_diamond_shovel",
            () -> new ShovelItem(
                    SDToolTiers.SCULKED_DIAMOND,
                    new Item.Properties().attributes(
                            ShovelItem.createAttributes(
                                    SDToolTiers.SCULKED_DIAMOND,
                                    1.5f,
                                    -3.0f
                            )
                    )
            )
    );

    public static final RegistryObject<HoeItem> SCULKED_DIAMOND_HOE = ITEMS.register(
            "sculked_diamond_hoe",
            () -> new HoeItem(
                    SDToolTiers.SCULKED_DIAMOND,
                    new Item.Properties().attributes(
                            HoeItem.createAttributes(
                                    SDToolTiers.SCULKED_DIAMOND,
                                    0,      // hoes usually don't add damage
                                    -3.0f
                            )
                    )
            )
    );

    // ===== SD ARMOR =====

    public static final RegistryObject<ArmorItem> SCULKED_DIAMOND_HELMET = ITEMS.register(
            "sculked_diamond_helmet",
            () -> new ArmorItem(
                    SDArmorMaterials.SCULKED_DIAMOND.get(),
                    ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33)) // 33 is netherite-ish; you can tweak
            )
    );

    public static final RegistryObject<ArmorItem> SCULKED_DIAMOND_CHESTPLATE = ITEMS.register(
            "sculked_diamond_chestplate",
            () -> new ArmorItem(
                    SDArmorMaterials.SCULKED_DIAMOND.get(),
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(33))
            )
    );

    public static final RegistryObject<ArmorItem> SCULKED_DIAMOND_LEGGINGS = ITEMS.register(
            "sculked_diamond_leggings",
            () -> new ArmorItem(
                    SDArmorMaterials.SCULKED_DIAMOND.get(),
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(33))
            )
    );

    public static final RegistryObject<ArmorItem> SCULKED_DIAMOND_BOOTS = ITEMS.register(
            "sculked_diamond_boots",
            () -> new ArmorItem(
                    SDArmorMaterials.SCULKED_DIAMOND.get(),
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(33))
            )
    );

    private SDItems() {}

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }
}
