package net.onidev.onilib.datagen;

import net.onidev.onilib.OniLib;
import net.onidev.onilib.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OniLib.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DEEPSLATE_CASING);
        blockWithItem(ModBlocks.RECONSIDER_BLOCK);

        stairsBlock(ModBlocks.DEEPSLATE_CASING_STAIRS.get(), blockTexture(ModBlocks.DEEPSLATE_CASING.get()));
        slabBlock(ModBlocks.DEEPSLATE_CASING_SLAB.get(), blockTexture(ModBlocks.DEEPSLATE_CASING.get()), blockTexture(ModBlocks.DEEPSLATE_CASING.get()));

        buttonBlock(ModBlocks.DEEPSLATE_CASING_BUTTON.get(), blockTexture(ModBlocks.DEEPSLATE_CASING.get()));
        pressurePlateBlock(ModBlocks.DEEPSLATE_CASING_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DEEPSLATE_CASING.get()));

        fenceBlock(ModBlocks.DEEPSLATE_CASING_FENCE.get(), blockTexture(ModBlocks.DEEPSLATE_CASING.get()));
        fenceGateBlock(ModBlocks.DEEPSLATE_CASING_FENCE_GATE.get(), blockTexture(ModBlocks.DEEPSLATE_CASING.get()));
        wallBlock(ModBlocks.DEEPSLATE_CASING_WALL.get(), blockTexture(ModBlocks.DEEPSLATE_CASING.get()));

        doorBlockWithRenderType(ModBlocks.DEEPSLATE_CASING_DOOR.get(), modLoc("block/deepslate_casing_door_bottom"), modLoc("block/deepslate_casing_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.DEEPSLATE_CASING_TRAPDOOR.get(), modLoc("block/deepslate_casing_trapdoor"), true, "cutout");

        blockItem(ModBlocks.DEEPSLATE_CASING_STAIRS);
        blockItem(ModBlocks.DEEPSLATE_CASING_SLAB);
        blockItem(ModBlocks.DEEPSLATE_CASING_PRESSURE_PLATE);
        blockItem(ModBlocks.DEEPSLATE_CASING_FENCE_GATE);
        blockItem(ModBlocks.DEEPSLATE_CASING_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("onilib:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("onilib:block/" + deferredBlock.getId().getPath() + appendix));
    }
}