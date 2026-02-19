package net.onidev.onilib.datagen;

import net.onidev.onilib.OniLib;
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
    }
}