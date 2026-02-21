package net.onidev.onilib.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.onidev.onilib.OniLib;
import net.onidev.onilib.item.custom.HammerItem;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = OniLib.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvent {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        // We get the player that triggered the event, and then the ItemStack of their main hand (the ItemStack they used).
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        // First, check if that item was indeed a HammerItem, and that they're server-connected.
        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            // We can get the position where this event started via event.getPos()
            BlockPos initialBlockPos = event.getPos();
            // Anti-recursive check
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            // If the hammer is the wrong tool, simply proceed and ignore.
            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos.equals(initialBlockPos) || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // If the hammer is the right tool, first add the broken positions to HARVESTED_BLOCKS, then break the block.
                // This prevents infinite recursion.
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }
}
