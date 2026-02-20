package net.onidev.onilib.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.onidev.onilib.block.ModBlocks;
import net.onidev.onilib.component.ModDataComponents;


import java.util.List;
import java.util.Map;

public class DeepslateFenceChisel extends Item {
    private static final Map<Block, Block> DEEPSLATE_FENCE_CHISEL =
            Map.of(
                    ModBlocks.DEEPSLATE_CASING_FENCE.get(), ModBlocks.DEEPSLATE_CASING_FENCE_GATE.get(),
                    ModBlocks.DEEPSLATE_CASING_FENCE_GATE.get(), ModBlocks.DEEPSLATE_CASING_FENCE.get()
            );


    public DeepslateFenceChisel(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(DEEPSLATE_FENCE_CHISEL.containsKey(clickedBlock)) {
            if(!level.isClientSide) {
                level.setBlockAndUpdate(context.getClickedPos(), DEEPSLATE_FENCE_CHISEL.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.onilib.deepslate_fence_chisel_active"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.onilib.deepslate_fence_chisel_inactive"));
        }

        if(stack.get(ModDataComponents.COORDINATES) != null) {
            tooltipComponents.add(Component.literal("Last block changed at " + stack.get(ModDataComponents.COORDINATES)));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
