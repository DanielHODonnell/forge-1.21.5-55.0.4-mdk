package com.dojima.demo.block;

import com.dojima.demo.DojiDemo;
import com.dojima.demo.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DojiDemo.MOD_ID);
    // Pig Block
    public static final RegistryObject<Block> PIG_BLOCK = registerBlock("pig_block",
            () -> new Block(BlockBehaviour
                    .Properties
                    .of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DojiDemo.MOD_ID, "pig_block")))));

    // Pig Ore (Not deepslate)
    public static final RegistryObject<Block> PIG_ORE = registerBlock("pig_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour
                    .Properties
                    .of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DojiDemo.MOD_ID, "pig_ore")))));

    // Pig Ore (deepslate)
    public static final RegistryObject<Block> DEEPSLATE_PIG_ORE = registerBlock("deepslate_pig_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour
                    .Properties
                    .of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DojiDemo.MOD_ID, "deepslate_pig_ore")))));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                // This allows minecraft to register multiple block items
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DojiDemo.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
