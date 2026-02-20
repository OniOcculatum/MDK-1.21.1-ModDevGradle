package net.onidev.onilib.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.onidev.onilib.OniLib;
//import net.onidev.onilib.block.custom.CrumbAnimatorBlock;
import net.onidev.onilib.block.custom.LampBlock;
import net.onidev.onilib.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(OniLib.MOD_ID);

    // Register Here
//    public static final DeferredBlock<Block> CRUMB_RADIO = registerBlock(
//            "crumb_radio",
//            () -> new Block(BlockBehaviour.Properties.of()
//            .strength(1).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> DEEPSLATE_CASING = registerBlock(
            "deepslate_casing",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(1)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE_BRICKS)
            ));

    public static final DeferredBlock<StairBlock> DEEPSLATE_CASING_STAIRS = registerBlock(
            "deepslate_casing_stairs",
            () -> new StairBlock(
                    ModBlocks.DEEPSLATE_CASING.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(1)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE_BRICKS)
            ));

    public static final DeferredBlock<SlabBlock> DEEPSLATE_CASING_SLAB = registerBlock(
            "deepslate_casing_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of()
                            .strength(1)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE_BRICKS)
            ));

    public static final DeferredBlock<PressurePlateBlock> DEEPSLATE_CASING_PRESSURE_PLATE = registerBlock(
            "deepslate_casing_pressure_plate",
            () -> new PressurePlateBlock(
                    BlockSetType.IRON,
                    BlockBehaviour.Properties.of()
                            .strength(1)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE_BRICKS)
                            .noCollission()
            ));

    public static final DeferredBlock<ButtonBlock> DEEPSLATE_CASING_BUTTON = registerBlock(
            "deepslate_casing_button",
            () -> new ButtonBlock(
                    BlockSetType.IRON,
                    20,
                    BlockBehaviour.Properties.of()
                            .strength(1)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE_BRICKS)
                            .noCollission()
            ));

    public static final DeferredBlock<FenceBlock> DEEPSLATE_CASING_FENCE = registerBlock(
            "deepslate_casing_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties.of()
                    .strength(1)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE_BRICKS)
            ));

    public static final DeferredBlock<FenceGateBlock> DEEPSLATE_CASING_FENCE_GATE = registerBlock(
            "deepslate_casing_fence_gate",
            () -> new FenceGateBlock(
                    WoodType.OAK,
                    BlockBehaviour.Properties.of()
                    .strength(1)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE_BRICKS)
            ));

    public static final DeferredBlock<WallBlock> DEEPSLATE_CASING_WALL = registerBlock(
            "deepslate_casing_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.of()
                            .strength(1)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE_BRICKS)
            ));

    public static final DeferredBlock<DoorBlock> DEEPSLATE_CASING_DOOR = registerBlock(
            "deepslate_casing_door",
            () -> new DoorBlock(
                    BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(1)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE_BRICKS)
                            .noOcclusion()
            ));

    public static final DeferredBlock<TrapDoorBlock> DEEPSLATE_CASING_TRAPDOOR = registerBlock(
            "deepslate_casing_trapdoor",
            () -> new TrapDoorBlock(
                    BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(1)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE_BRICKS)
                            .noOcclusion()
            ));

    public static final DeferredBlock<Block> RECONSIDER_BLOCK = registerBlock(
            "reconsider_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(0.2f)
                            .sound(SoundType.WOOL)
            ));

    public static final DeferredBlock<Block> DEEPSLATE_LAMP = registerBlock(
            "deepslate_lamp_block",
            () -> new LampBlock(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .sound(SoundType.AMETHYST)
                            .requiresCorrectToolForDrops()
                            .lightLevel(state -> state.getValue(LampBlock.IS_ON) ? 15 : 0)
            )
    );

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
