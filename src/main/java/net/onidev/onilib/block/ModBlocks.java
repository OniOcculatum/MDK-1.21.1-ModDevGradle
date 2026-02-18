package net.onidev.onilib.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.onidev.onilib.OniLib;
import net.onidev.onilib.block.custom.CrumbAnimatorBlock;
import net.onidev.onilib.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(OniLib.MOD_ID);

    // Register Here
    public static final DeferredBlock<Block> CRUMB_RADIO = registerBlock(
            "crumb_radio",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(1).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> BLOCK_OF_CRUMBIUM = registerBlock(
            "block_of_crumbium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> CRUMB_ORE = registerBlock(
            "crumb_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_CRUMB_ORE = registerBlock(
            "deepslate_crumb_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> EVIL_CRUMB_RADIO = registerBlock(
            "evil_crumb_radio",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> CRUMB_ANIMATOR = registerBlock(
            "crumb_animator",
            () -> new CrumbAnimatorBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
