package net.onidev.onilib.datagen;

import net.onidev.onilib.OniLib;
import net.onidev.onilib.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OniLib.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLOCK_OF_CRUMBIUM);
        blockWithItem(ModBlocks.CRUMB_ANIMATOR);
        blockWithItem(ModBlocks.CRUMB_ORE);
        blockWithItem(ModBlocks.CRUMB_RADIO);
        blockWithItem(ModBlocks.DEEPSLATE_CRUMB_ORE);
        blockWithItem(ModBlocks.EVIL_CRUMB_RADIO);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}