package net.onidev.onilib.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CRUMB_SNACK = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(.5f)
            .alwaysEdible()
            .build();

    public static final FoodProperties CRUMB_DRINK = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(2f)
            .alwaysEdible()
            .build();
}
