package net.onidev.onilib.datagen;

import net.onidev.onilib.OniLib;
import net.onidev.onilib.block.ModBlocks;
import net.onidev.onilib.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // Tagging items for auto-recipes later.
        List<ItemLike> CRUMB_SMELTABLES = List.of(
                ModItems.RAW_CRUMBIUM,
                ModBlocks.CRUMB_ORE,
                ModBlocks.DEEPSLATE_CRUMB_ORE);

        // An example shaped recipe.
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_CRUMBIUM.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.CRUMBIUM.get())
                .unlockedBy("has_crumbium", has(ModItems.CRUMBIUM))
                .save(recipeOutput);

        // An example shapeless recipe.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CRUMBIUM.get(), 9)
                .requires(ModBlocks.BLOCK_OF_CRUMBIUM.get())
                .unlockedBy("has_crumbium_block", has(ModBlocks.BLOCK_OF_CRUMBIUM))
                .save(recipeOutput);

        // An example shapeless custom recipe.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CRUMBIUM.get(), 18)
                .requires(ModBlocks.CRUMB_ANIMATOR.get())
                .unlockedBy("has_crumb_animator", has(ModBlocks.CRUMB_ANIMATOR))
                .save(recipeOutput, "onilib:crumbium_from_crumb_animator");

        oreSmelting(recipeOutput, CRUMB_SMELTABLES, RecipeCategory.MISC, ModItems.CRUMBIUM.get(), 0.25f, 200, "bismuth");
        oreBlasting(recipeOutput, CRUMB_SMELTABLES, RecipeCategory.MISC, ModItems.CRUMBIUM.get(), 0.25f, 100, "bismuth");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, OniLib.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}