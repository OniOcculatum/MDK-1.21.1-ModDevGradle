package net.onidev.onilib.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.onidev.onilib.OniLib;
import net.onidev.onilib.item.custom.DeepslateFenceChisel;
import net.onidev.onilib.item.custom.DrinkItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OniLib.MOD_ID);

    // Register Here
    public static final DeferredItem<Item> LAPIS_DUST = ITEMS.register(
            "lapis_dust",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> SPIDER_EGGS = ITEMS.register(
            "spider_eggs",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> PEPSI = ITEMS.register(
            "pepsi",
            () -> new DrinkItem(new Item.Properties().food(ModFoodProperties.PEPSI), ModItems.EMPTY_CAN)
    );

    public static final DeferredItem<Item> DEEPSLATE_ALLOY = ITEMS.register(
            "deepslate_alloy",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> DEEPSLATE_FENCE_CHISEL = ITEMS.register(
            "deepslate_fence_chisel",
            () -> new DeepslateFenceChisel(new Item.Properties().durability(32))
    );

    public static final DeferredItem<PickaxeItem> DEEPSLATE_ALLOY_PICKAXE = ITEMS.register(
            "deepslate_alloy_pickaxe",
            () -> new PickaxeItem(ModToolTiers.DEEPSLATE_ALLOY, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.DEEPSLATE_ALLOY, 1.5f, -1.5f)))
    );

    public static final DeferredItem<Item> DEEPSLATE_ALLOY_HAMMER = ITEMS.register(
            "deepslate_alloy_hammer",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> EMPTY_CAN = ITEMS.register(
            "empty_can",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
