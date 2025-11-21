package com.nightmare.trinity.content;

import com.nightmare.trinity.Trinity;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class SDBlocks {

    // Classic DeferredRegister<T> style (no RegistryObject)
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, Trinity.MODID);

    // Sculked Diamond ore – deep dark ore, drops XP like diamond
    public static final Supplier<Block> SCULKED_DIAMOND_ORE =
            BLOCKS.register("sculked_diamond_ore",
                    () -> new DropExperienceBlock(
                            // XP range (same style as vanilla ores)
                            UniformInt.of(3, 7),
                            BlockBehaviour.Properties.of()
                                    .strength(3.0F, 3.0F)
                                    .sound(SoundType.STONE)
                                    .requiresCorrectToolForDrops()
                    ));

    private SDBlocks() {}
}
