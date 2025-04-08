package com.dojima.demo.item;

import com.dojima.demo.DojiDemo;
import com.dojima.demo.block.ModBlocks;
import com.mojang.brigadier.LiteralMessage;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DojiDemo.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PIG_ITEMS_TAB = CREATIVE_MODE_TABS.register("pig_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.PIGINGOT.get())) // Makes pig ingot creative mode tab icon
                    .title(Component.translatable("creativetab.dojimamod.pig_items"))
                    .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                        @Override
                        public void accept(CreativeModeTab.@NotNull ItemDisplayParameters pParameters, CreativeModeTab.@NotNull Output pOutput) {
                            pOutput.accept(ModItems.PIGINGOT.get());
                            pOutput.accept(ModItems.PIGNUGGET.get());
                        }
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> PIG_BLOCKS_TAB = CREATIVE_MODE_TABS.register("pig_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(PIG_ITEMS_TAB.getId()) // Makes sure the pig items tab comes before the pig blocks tab
                    .icon(() -> new ItemStack(ModBlocks.PIG_BLOCK.get())) // Makes pig block creative mode tab icon
                    .title(Component.translatable("creativetab.dojimamod.pig_blocks"))
                    .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                        // Add this since 1.21.4+ changed everything cuz it's stupid
                        @Override
                        public void accept(CreativeModeTab.@NotNull ItemDisplayParameters pParameters, CreativeModeTab.@NotNull Output pOutput) {
                            pOutput.accept(ModBlocks.PIG_BLOCK.get());
                            pOutput.accept(ModBlocks.PIG_ORE.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
