package net.onidev.onilib.datagen;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.common.Mod;
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
import com.simibubi.create.content.materials.ExperienceNuggetItem;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // Tagging items for auto-recipes later.
//        List<ItemLike> CRUMB_SMELTABLES = List.of(
//                ModItems.RAW_CRUMBIUM,
//                ModBlocks.CRUMB_ORE,
//                ModBlocks.DEEPSLATE_CRUMB_ORE);

        // An example shaped recipe.
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEEPSLATE_CASING.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.DEEPSLATE_ALLOY.get())
                .unlockedBy("has_deepslate_alloy", has(ModItems.DEEPSLATE_ALLOY.get()))
                .save(recipeOutput, OniLib.MOD_ID + ":deepslate_casing_from_deepslate_alloy");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DEEPSLATE_ALLOY.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Blocks.DEEPSLATE)
                .unlockedBy("has_deepslate", has(Blocks.DEEPSLATE))
                .save(recipeOutput, OniLib.MOD_ID + ":deepslate_alloy_from_deepslate");

        // An example shapeless recipe.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DEEPSLATE_ALLOY.get(), 9)
                .requires(ModBlocks.DEEPSLATE_CASING.get())
                .unlockedBy("has_deepslate_casing", has(ModBlocks.DEEPSLATE_CASING))
                .save(recipeOutput, OniLib.MOD_ID + ":deepslate_alloy_from_deepslate_casing");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.DEEPSLATE, 9)
                .requires(ModItems.DEEPSLATE_ALLOY.get())
                .unlockedBy("has_deepslate_alloy", has(ModItems.DEEPSLATE_ALLOY))
                .save(recipeOutput, OniLib.MOD_ID + ":deepslate_from_deepslate_alloy");

        // An example shapeless custom recipe.
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CRUMBIUM.get(), 18)
//                .requires(ModBlocks.CRUMB_ANIMATOR.get())
//                .unlockedBy("has_crumb_animator", has(ModBlocks.CRUMB_ANIMATOR))
//                .save(recipeOutput, "onilib:crumbium_from_crumb_animator");

//        oreSmelting(recipeOutput, CRUMB_SMELTABLES, RecipeCategory.MISC, ModItems.CRUMBIUM.get(), 0.25f, 200, "bismuth");
//        oreBlasting(recipeOutput, CRUMB_SMELTABLES, RecipeCategory.MISC, ModItems.CRUMBIUM.get(), 0.25f, 100, "bismuth");

        stairBuilder(ModBlocks.DEEPSLATE_CASING_STAIRS.get(), Ingredient.of(ModItems.DEEPSLATE_ALLOY))
                .group("deepslate_casing")
                .unlockedBy("has_deepslate_alloy", has(ModItems.DEEPSLATE_ALLOY))
                .save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_CASING.get(), ModItems.DEEPSLATE_ALLOY.get());

        buttonBuilder(ModBlocks.DEEPSLATE_CASING_BUTTON.get(), Ingredient.of(ModItems.DEEPSLATE_ALLOY))
                .group("deepslate_casing")
                .unlockedBy("has_deepslate_alloy", has(ModItems.DEEPSLATE_ALLOY))
                .save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.DEEPSLATE_CASING_PRESSURE_PLATE.get(), ModItems.DEEPSLATE_ALLOY.get());

        fenceBuilder(ModBlocks.DEEPSLATE_CASING_FENCE.get(), Ingredient.of(ModItems.DEEPSLATE_ALLOY))
                .group("deepslate_alloy")
                .unlockedBy("has_deepslate_alloy", has(ModItems.DEEPSLATE_ALLOY))
                .save(recipeOutput);

        fenceGateBuilder(ModBlocks.DEEPSLATE_CASING_FENCE_GATE.get(), Ingredient.of(ModItems.DEEPSLATE_ALLOY))
                .group("deepslate_alloy")
                .unlockedBy("has_deepslate_alloy", has(ModItems.DEEPSLATE_ALLOY))
                .save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_CASING_WALL.get(), ModItems.DEEPSLATE_ALLOY.get());

        doorBuilder(ModBlocks.DEEPSLATE_CASING_DOOR.get(), Ingredient.of(ModItems.DEEPSLATE_ALLOY))
                .group("deepslate_alloy")
                .unlockedBy("has_deepslate_alloy", has(ModItems.DEEPSLATE_ALLOY))
                .save(recipeOutput);

        trapdoorBuilder(ModBlocks.DEEPSLATE_CASING_TRAPDOOR.get(), Ingredient.of(ModItems.DEEPSLATE_ALLOY))
                .group("deepslate_alloy")
                .unlockedBy("has_deepslate_alloy", has(ModItems.DEEPSLATE_ALLOY))
                .save(recipeOutput);
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