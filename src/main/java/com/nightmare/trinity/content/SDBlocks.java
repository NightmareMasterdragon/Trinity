package com.nightmare.trinity.content;

import com.nightmare.trinity.Trinity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.Registry;

public class SDBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, Trinity.MODID);

    public static final RegistryObject<Block> SCULKED_DIAMOND_ORE =
            BLOCKS.register("sculked_diamond_ore", () ->
                    new DropExperienceBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_BLACK)
                                    .strength(4.5F, 3.0F)
                                    .sound(SoundType.SCULK)
                                    .requiresCorrectToolForDrops()
                    )
            );

    private SDBlocks() {}

    public static void register(IEventBus modBus) {
        BLOCKS.register(modBus);
    }
}
