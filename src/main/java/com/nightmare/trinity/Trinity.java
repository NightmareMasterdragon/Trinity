package com.nightmare.trinity;

import com.nightmare.trinity.content.SDBlocks;
import com.nightmare.trinity.content.SDItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Trinity.MODID)
public class Trinity {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "trinity";

    public Trinity(IEventBus modEventBus) {
        // Register content registries
        SDBlocks.BLOCKS.register(modEventBus);
        SDItems.ITEMS.register(modEventBus);

        // SD armor abilities are registered via @EventBusSubscriber(SDAbility),
        // so we don't need to manually register SDAbility here.
        // Just make sure NeoForge.EVENT_BUS is actually used if you ever
        // decide to register non-@EventBusSubscriber handlers.
       // optional if you have instance event handlers
    }
}
