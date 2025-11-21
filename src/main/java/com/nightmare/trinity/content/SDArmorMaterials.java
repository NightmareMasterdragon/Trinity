package com.nightmare.trinity.content;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;

/**
 * Temporary armor material wiring for Sculked Diamond.
 *
 * Right now this just reuses DIAMOND's base armor material so we can get the
 * set working and wire abilities (warden friendliness, darkness immunity, etc.).
 *
 * We'll swap this to a true custom ArmorMaterial with 1.5x stats after the
 * basic SD pipeline is compiling and tested.
 */
public final class SDArmorMaterials {

    // In modern Minecraft/NeoForge, ArmorMaterials.DIAMOND is a Holder<ArmorMaterial>
    public static final Holder<ArmorMaterial> SCULKED_DIAMOND = ArmorMaterials.DIAMOND;

    private SDArmorMaterials() {}
}
