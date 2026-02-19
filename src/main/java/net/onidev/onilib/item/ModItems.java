package net.onidev.onilib.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.onidev.onilib.OniLib;
//import net.onidev.onilib.item.custom.DrinkItem;
//import net.onidev.onilib.item.custom.CrumbReshaper;
//import net.onidev.onilib.item.custom.FuelItem;

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
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> DEEPSLATE_ALLOY = ITEMS.register(
            "deepslate_alloy",
            () -> new Item(new Item.Properties())
    );

//    public static final DeferredItem<Item> CRUMB_RESHAPER = ITEMS.register(
//            "crumb_reshaper",
//            () -> new CrumbReshaper(new Item.Properties().durability(32))
//    );
//
//    public static final DeferredItem<Item> CRUMB_SNACK = ITEMS.register(
//            "crumb_snack",
//            () -> new Item(new Item.Properties().food(ModFoodProperties.CRUMB_SNACK)) {
//                @Override
//                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
//                    tooltipComponents.add(Component.translatable("tooltip.onilib.crumb_snack"));
//
//                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
//                }
//            }
//    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
