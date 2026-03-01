package net.onidev.onilib;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.onidev.onilib.block.ModBlocks;
//import net.onidev.onilib.item.ModItems;

@Mod(OniLib.MOD_ID)
public class OniLib {
    public static final String MOD_ID = "onilib";
    public static final NonNullSupplier<Registrate> REGISTRATE = NonNullSupplier.lazy(() -> Registrate.create(MOD_ID));

    public static final ResourceKey<CreativeModeTab> ITEMS_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "items_tab"));

    // The "Safety Catch"
    private static boolean hasRegistered = false;

    public OniLib(IEventBus modEventBus) {
//        ModItems.load();
        ModBlocks.load();
    }
}