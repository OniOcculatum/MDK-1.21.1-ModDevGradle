package net.onidev.onilib.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.onidev.onilib.util.ModTags;

public class ModToolTiers {
    public static final Tier DEEPSLATE_ALLOY = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DEEPSLATE_ALLOY_TOOL,
            1400, 4f, 3f, 10, () -> Ingredient.of(ModItems.DEEPSLATE_ALLOY.get()));
}
