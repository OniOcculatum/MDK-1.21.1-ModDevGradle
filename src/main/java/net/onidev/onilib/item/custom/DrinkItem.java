package net.onidev.onilib.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class DrinkItem extends Item {
    private final Supplier<Item> drinkItem;

    public DrinkItem(Properties properties, Supplier<Item> drinkItem) {
        super(properties);
        this.drinkItem = drinkItem;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        super.finishUsingItem(stack, level, entityLiving);
        if (entityLiving instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }
        if (stack.isEmpty()) {
            return new ItemStack(drinkItem.get());
        } else {
            if (entityLiving instanceof Player player && !player.hasInfiniteMaterials()) {
                ItemStack itemstack = new ItemStack(drinkItem.get());
                if (!player.getInventory().add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }
            return stack;
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
}