package net.onidev.onilib.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.onidev.onilib.OniLib;

public class ModBlocks {

    public static final BlockEntry<Block> DEEPSLATE_CASING = OniLib.REGISTRATE.get()
            .block("deepslate_casing",Block::new)
            .lang("Heavy Deepslate Casing")
            .simpleItem()
            .register();

    public static void load() {}
}