package com.dojima.demo.item;

import com.dojima.demo.DojiDemo;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DojiDemo.MOD_ID);

    public static final RegistryObject<Item> PIGINGOT = ITEMS.register("pigingot",
            () -> new Item(new Item
                    .Properties()
                    .setId(ITEMS.key("pigingot")))); // add .setId(ITEMS.key("item_name") for newer versions

    public static final RegistryObject<Item> PIGNUGGET = ITEMS.register("pignugget",
            () -> new Item(new Item
                    .Properties()
                    .setId(ITEMS.key("pignugget"))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
