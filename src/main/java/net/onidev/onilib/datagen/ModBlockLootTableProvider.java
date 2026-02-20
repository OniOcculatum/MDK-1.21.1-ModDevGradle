package net.onidev.onilib.datagen;

import net.neoforged.fml.common.Mod;
import net.onidev.onilib.block.ModBlocks;
import net.onidev.onilib.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // dropSelf is going to be used in 90% of cases.

        // createOreDrop takes one item as the ore block, and one item as the ore item.
//        add(ModBlocks.CRUMB_ORE.get(),
//                block -> createOreDrop(ModBlocks.CRUMB_ORE.get(), ModItems.RAW_CRUMBIUM.get()));
//
//        // createMultipleOreDrops is a custom method for copper-ore-like behavior.
//        add(ModBlocks.DEEPSLATE_CRUMB_ORE.get(),
//                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_CRUMB_ORE.get(), ModItems.RAW_CRUMBIUM.get(), 2, 5));

        dropSelf(ModBlocks.DEEPSLATE_CASING.get());
        dropSelf(ModBlocks.DEEPSLATE_CASING_STAIRS.get());

        dropSelf(ModBlocks.DEEPSLATE_CASING_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.DEEPSLATE_CASING_BUTTON.get());

        dropSelf(ModBlocks.DEEPSLATE_CASING_FENCE.get());
        dropSelf(ModBlocks.DEEPSLATE_CASING_FENCE_GATE.get());
        dropSelf(ModBlocks.DEEPSLATE_CASING_WALL.get());

        dropSelf(ModBlocks.DEEPSLATE_CASING_TRAPDOOR.get());

        dropSelf(ModBlocks.RECONSIDER_BLOCK.get());

        dropSelf(ModBlocks.DEEPSLATE_LAMP.get());

        add(ModBlocks.DEEPSLATE_CASING_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DEEPSLATE_CASING_SLAB.get())
        );

        add(ModBlocks.DEEPSLATE_CASING_DOOR.get(),
                block -> createDoorTable(ModBlocks.DEEPSLATE_CASING_DOOR.get())
        );
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}