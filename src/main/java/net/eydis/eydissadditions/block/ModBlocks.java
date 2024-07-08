package net.eydis.eydissadditions.block;

import net.eydis.eydissadditions.MCCourseMod;
import net.eydis.eydissadditions.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);
    //Block 1
    public static final RegistryObject<Block> PURPURONYXSTONEBLOCK = registerBlock("purpuronyxstoneblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));
    //Block 2 + exp
    public static final RegistryObject<Block> PURPURONYXSTONE_ORE = registerBlock("purpuronyxstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F, 3.0F).sound(SoundType.NETHER_GOLD_ORE), UniformInt.of(0, 1)));



    private static <T extends Block> RegistryObject <T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
