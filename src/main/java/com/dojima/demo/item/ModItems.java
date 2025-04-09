package com.dojima.demo.item;

import com.dojima.demo.DojiDemo;
import com.dojima.demo.item.custom.RodOfLightningItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DojiDemo.MOD_ID);

    // Pig Ingot
    public static final RegistryObject<Item> PIGINGOT = ITEMS.register("pigingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.UNCOMMON)
                    .setId(ITEMS.key("pigingot")))); // add .setId(ITEMS.key("item_name") for newer versions

    // Pig Nuggets
    public static final RegistryObject<Item> PIGNUGGET = ITEMS.register("pignugget",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.UNCOMMON)
                    .setId(ITEMS.key("pignugget"))));

    // Hot potato book
    public static final RegistryObject<Item> HOTPOTATOBOOK = ITEMS.register("hotpotatobook",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC)
                    .setId(ITEMS.key("hotpotatobook"))));

    // Pig infused netherite
    public static final RegistryObject<Item> PIGINFUSEDNETHERITE = ITEMS.register("piginfusednetherite",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE)
                    .setId(ITEMS.key("piginfusednetherite"))));

    // Pig Template
    public static final RegistryObject<Item> PIGTEMPLATE = ITEMS.register("pigtemplate",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE)
                    .setId(ITEMS.key("pigtemplate"))));

    public static final RegistryObject<Item> ROD_OF_LIGHTNING = ITEMS.register("rod_of_lightning",
            () -> new RodOfLightningItem(new Item
                    .Properties()
                    .durability(500)
                    .rarity(Rarity.EPIC)
                    .setId(ITEMS.key("rod_of_lightning"))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
