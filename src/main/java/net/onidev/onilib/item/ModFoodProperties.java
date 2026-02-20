package net.onidev.onilib.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties PEPSI = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(2f)
            .alwaysEdible()
            .build();
}
