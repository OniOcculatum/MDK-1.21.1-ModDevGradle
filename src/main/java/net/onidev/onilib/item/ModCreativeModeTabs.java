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

    public static final Supplier<CreativeModeTab> ONI_LIB_ITEM_TAB = CREATIVE_MODE_TAB.register("oni_lib_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LAPIS_DUST.get()))
                    .title(Component.translatable("creativetab.onilib.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LAPIS_DUST);
                        output.accept(ModItems.SPIDER_EGGS);
                        output.accept(ModItems.PEPSI);
                        output.accept(ModItems.DEEPSLATE_ALLOY);
                    }).build());

    public static final Supplier<CreativeModeTab> ONI_LIB_BLOCK_TAB = CREATIVE_MODE_TAB.register("oni_lib_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.DEEPSLATE_CASING))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(OniLib.MOD_ID, "oni_lib_items_tab"))
                    .title(Component.translatable("creativetab.onilib.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.DEEPSLATE_CASING);

                        output.accept(ModBlocks.DEEPSLATE_CASING_SLAB);
                        output.accept(ModBlocks.DEEPSLATE_CASING_STAIRS);

                        output.accept(ModBlocks.DEEPSLATE_CASING_FENCE);
                        output.accept(ModBlocks.DEEPSLATE_CASING_FENCE_GATE);

                        output.accept(ModBlocks.DEEPSLATE_CASING_WALL);

                        output.accept(ModBlocks.DEEPSLATE_CASING_BUTTON);
                        output.accept(ModBlocks.DEEPSLATE_CASING_PRESSURE_PLATE);

                        output.accept(ModBlocks.DEEPSLATE_CASING_DOOR);
                        output.accept(ModBlocks.DEEPSLATE_CASING_TRAPDOOR);

                        output.accept(ModBlocks.RECONSIDER_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}