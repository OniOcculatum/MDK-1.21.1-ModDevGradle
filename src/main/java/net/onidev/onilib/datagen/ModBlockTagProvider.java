package net.onidev.onilib.datagen;

import net.neoforged.fml.common.Mod;
import net.onidev.onilib.OniLib;
import net.onidev.onilib.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.onidev.onilib.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, OniLib.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//
//        // Use the tag function with BlockTags.<tag> to quickly and easily tag a large number of blocks.
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DEEPSLATE_CASING.get())
                .add(ModBlocks.DEEPSLATE_CASING_STAIRS.get())
                .add(ModBlocks.DEEPSLATE_CASING_SLAB.get())
                .add(ModBlocks.DEEPSLATE_CASING_PRESSURE_PLATE.get())
                .add(ModBlocks.DEEPSLATE_CASING_BUTTON.get())
                .add(ModBlocks.DEEPSLATE_CASING_FENCE.get())
                .add(ModBlocks.DEEPSLATE_CASING_FENCE_GATE.get())
                .add(ModBlocks.DEEPSLATE_CASING_DOOR.get())
                .add(ModBlocks.DEEPSLATE_CASING_TRAPDOOR.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_CASING.get())
                .add(ModBlocks.DEEPSLATE_CASING_STAIRS.get())
                .add(ModBlocks.DEEPSLATE_CASING_SLAB.get())
                .add(ModBlocks.DEEPSLATE_CASING_PRESSURE_PLATE.get())
                .add(ModBlocks.DEEPSLATE_CASING_BUTTON.get())
                .add(ModBlocks.DEEPSLATE_CASING_FENCE.get())
                .add(ModBlocks.DEEPSLATE_CASING_FENCE_GATE.get())
                .add(ModBlocks.DEEPSLATE_CASING_DOOR.get())
                .add(ModBlocks.DEEPSLATE_CASING_TRAPDOOR.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_LAMP.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.DEEPSLATE_CASING_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.DEEPSLATE_CASING_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.DEEPSLATE_CASING_WALL.get());

        tag(ModTags.Blocks.NEEDS_DEEPSLATE_ALLOY_TOOL)
                .add(ModBlocks.DEEPSLATE_LAMP.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_DEEPSLATE_ALLOY_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_DEEPSLATE_ALLOY_TOOL);
    }
}