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
        basicItem(ModItems.CRUMB_DRINK.get());
        basicItem(ModItems.CRUMB_RESHAPER.get());
        basicItem(ModItems.CRUMB_SNACK.get());
        basicItem(ModItems.CRUMBIUM.get());
        basicItem(ModItems.ESSENCE_OF_CRUMB_DOUBTER.get());
        basicItem(ModItems.LAPIS_DUST.get());
        basicItem(ModItems.LIGHT_OF_CRUMB.get());
        basicItem(ModItems.RAW_CRUMBIUM.get());
        basicItem(ModItems.SPIDER_EGGS.get());
    }
}