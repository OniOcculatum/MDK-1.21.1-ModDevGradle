package net.onidev.onilib.datagen;

import net.onidev.onilib.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        // Add any number of NeoForeDataMaps here.
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.ESSENCE_OF_CRUMB_DOUBTER.getId(), new FurnaceFuel(1200), false)
                .add(ModItems.LIGHT_OF_CRUMB.getId(), new FurnaceFuel(2400), false);
    }
}