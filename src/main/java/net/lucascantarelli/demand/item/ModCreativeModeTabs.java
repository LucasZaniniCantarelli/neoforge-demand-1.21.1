package net.lucascantarelli.demand.item;

import net.lucascantarelli.demand.Demand;
import net.lucascantarelli.demand.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Demand.MOD_ID);

    public static final Supplier<CreativeModeTab> DEMAND_ITEM_TAB = CREATIVE_MODE_TAB.register("demand_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.DEMAND_BLOCK.get()))
                    .title(Component.translatable("Demand"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COIN);
                        output.accept(ModBlocks.DEMAND_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
