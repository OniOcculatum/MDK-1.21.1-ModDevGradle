//package net.onidev.onilib.item.custom;
//
//import net.minecraft.client.gui.screens.Screen;
//import net.minecraft.network.chat.Component;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.TooltipFlag;
//import net.minecraft.world.item.context.UseOnContext;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.onidev.onilib.block.ModBlocks;
//
//import java.util.List;
//import java.util.Map;
//
//public class CrumbReshaper extends Item {
//    private static final Map<Block, Block> CRUMB_RESHAPER_MAP =
//            Map.of(
//                    ModBlocks.CRUMB_RADIO.get(), ModBlocks.EVIL_CRUMB_RADIO.get(),
//                    ModBlocks.EVIL_CRUMB_RADIO.get(), ModBlocks.CRUMB_RADIO.get()
//            );
//
//
//    public CrumbReshaper(Properties properties) {
//        super(properties);
//    }
//
//    @Override
//    public InteractionResult useOn(UseOnContext context) {
//        Level level = context.getLevel();
//        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
//
//        if(CRUMB_RESHAPER_MAP.containsKey(clickedBlock)) {
//            if(!level.isClientSide) {
//                level.setBlockAndUpdate(context.getClickedPos(), CRUMB_RESHAPER_MAP.get(clickedBlock).defaultBlockState());
//
//                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
//                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
//
//                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
//            }
//        }
//
//        return InteractionResult.SUCCESS;
//    }
//
//    @Override
//    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
//        if(Screen.hasShiftDown()) {
//            tooltipComponents.add(Component.translatable("tooltip.onilib.crumb_reshaper_shift_down"));
//        } else {
//            tooltipComponents.add(Component.translatable("tooltip.onilib.crumb_reshaper_no_shift"));
//        }
//
//        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
//    }
//}
