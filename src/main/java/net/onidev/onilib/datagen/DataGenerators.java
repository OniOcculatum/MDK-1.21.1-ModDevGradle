package net.onidev.onilib.datagen;

import com.tterrag.registrate.providers.ProviderType;
import net.onidev.onilib.OniLib;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = OniLib.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // Registrate handles this automatically because you called
        // registerEventListeners in your main OniLib constructor.
        // You don't need ANY code here for this test.
    }
}