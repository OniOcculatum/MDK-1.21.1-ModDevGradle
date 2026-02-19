package net.onidev.onilib.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.onidev.onilib.OniLib;
import net.onidev.onilib.block.ModBlocks;
import net.onidev.onilib.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OniLib.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Add items here to give them a simple model, *assuming* a texture exists with the same name.
        basicItem(ModItems.LAPIS_DUST.get());
        basicItem(ModItems.SPIDER_EGGS.get());
        basicItem(ModItems.PEPSI.get());
        basicItem(ModItems.DEEPSLATE_ALLOY.get());

        buttonItem(ModBlocks.DEEPSLATE_CASING_BUTTON, ModBlocks.DEEPSLATE_CASING);
        fenceItem(ModBlocks.DEEPSLATE_CASING_FENCE, ModBlocks.DEEPSLATE_CASING);
        wallItem(ModBlocks.DEEPSLATE_CASING_WALL, ModBlocks.DEEPSLATE_CASING);

        basicItem(ModBlocks.DEEPSLATE_CASING_DOOR.asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(OniLib.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(OniLib.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(OniLib.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}