package net.onidev.onilib.datagen;

import net.neoforged.fml.common.Mod;
import net.onidev.onilib.OniLib;
import net.onidev.onilib.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
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

        tag(BlockTags.FENCES)
                .add(ModBlocks.DEEPSLATE_CASING_FENCE.get())
                .add(ModBlocks.DEEPSLATE_CASING_FENCE_GATE.get())
                .add(ModBlocks.DEEPSLATE_CASING_TRAPDOOR.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.DEEPSLATE_CASING_WALL.get());
    }
}