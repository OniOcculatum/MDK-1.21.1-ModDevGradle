package net.onidev.onilib.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.onidev.onilib.OniLib;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_DEEPSLATE_ALLOY_TOOL = createTag("needs_deepslate_alloy_tool");
        public static final TagKey<Block> INCORRECT_FOR_DEEPSLATE_ALLOY_TOOL = createTag("incorrect_for_deepslate_alloy_tool");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(OniLib.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DEEPSLATE_ALLOY_TOOL = createTag("deepslate_alloy_tool");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(OniLib.MOD_ID, name));
        }
    }
}
