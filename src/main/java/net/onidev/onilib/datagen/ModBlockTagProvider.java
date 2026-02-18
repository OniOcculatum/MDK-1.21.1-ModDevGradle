package net.onidev.onilib.datagen;

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

        // Use the tag function with BlockTags.<tag> to quickly and easily tag a large number of blocks.
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOCK_OF_CRUMBIUM.get())
                .add(ModBlocks.CRUMB_ORE.get())
                .add(ModBlocks.DEEPSLATE_CRUMB_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
            .add(ModBlocks.BLOCK_OF_CRUMBIUM.get())
            .add(ModBlocks.CRUMB_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_CRUMB_ORE.get());

    }
}