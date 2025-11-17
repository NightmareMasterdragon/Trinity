package com.nightmare.trinity.content;

import com.nightmare.trinity.Trinity;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryObject;

import java.util.EnumMap;
import java.util.List;

public final class SDArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, Trinity.MODID);

    // 1.5x-ish diamond armor values; rounded up where needed.
    public static final RegistryObject<ArmorMaterial> SCULKED_DIAMOND = ARMOR_MATERIALS.register(
            "sculked_diamond",
            () -> new ArmorMaterial(
                    // Defense map per armor type
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        // Diamond: 3 / 6 / 8 / 3. Here we do ~1.5x: 5 / 9 / 12 / 5
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 9);
                        map.put(ArmorItem.Type.CHESTPLATE, 12);
                        map.put(ArmorItem.Type.HELMET, 5);
                        // BODY slot for non-player entities (won't be used but required).
                        map.put(ArmorItem.Type.BODY, 12);
                    }),
                    // Enchantability (diamond is 10) -> 15
                    15,
                    // Equip sound
                    SoundEvents.ARMOR_EQUIP_DIAMOND,
                    // Repair ingredient
                    () -> Ingredient.of(SDItems.SCULKED_DIAMOND.get()),
                    // Armor texture layers
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(
                                    Trinity.MODID, "sculked_diamond"
                            ))
                    ),
                    // Toughness: diamond has 2.0f -> 3.0f
                    3.0f,
                    // Knockback resistance (diamond 0.0, netherite 0.1). We give a small bonus.
                    0.05f
            )
    );

    private SDArmorMaterials() {}

    public static void register(net.neoforged.bus.api.IEventBus modBus) {
        ARMOR_MATERIALS.register(modBus);
    }
}
