package net.onidev.onilib.item;

import net.onidev.onilib.OniLib;
import net.onidev.onilib.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OniLib.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("oni_lib_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LAPIS_DUST.get()))
                    .title(Component.translatable("creativetab.onilib.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LAPIS_DUST);
                        output.accept(ModItems.SPIDER_EGGS);
                        output.accept(ModItems.CRUMB_RESHAPER);
                        output.accept(ModItems.CRUMB_SNACK);
                        output.accept(ModItems.CRUMB_DRINK);
                        output.accept(ModItems.ESSENCE_OF_CRUMB_DOUBTER);
                        output.accept(ModItems.LIGHT_OF_CRUMB);
                        output.accept(ModItems.RAW_CRUMBIUM);
                        output.accept(ModItems.CRUMBIUM);
                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB = CREATIVE_MODE_TAB.register("oni_lib_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRUMB_RADIO))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(OniLib.MOD_ID, "oni_lib_items_tab"))
                    .title(Component.translatable("creativetab.onilib.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CRUMB_RADIO);
                        output.accept(ModBlocks.EVIL_CRUMB_RADIO);
                        output.accept(ModBlocks.CRUMB_ANIMATOR);
                        output.accept(ModBlocks.CRUMB_ORE);
                        output.accept(ModBlocks.DEEPSLATE_CRUMB_ORE);
                        output.accept(ModBlocks.BLOCK_OF_CRUMBIUM);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}