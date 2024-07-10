package net.eydis.eydissadditions.datagen.loot;

import net.eydis.eydissadditions.block.ModBlocks;
import net.eydis.eydissadditions.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PURPURONYXSTONEBLOCK.get());
        this.dropSelf(ModBlocks.PURPURONYXSTONE_ORE.get());

        this.add(ModBlocks.PURPURONYXSTONE_ORE.get(),
                block -> createOreDrop(ModBlocks.PURPURONYXSTONE_ORE.get(), ModItems.RAW_PURPURONYXSTONE.get()));

        this.dropSelf(ModBlocks.PURPURONYXSTONE_STAIRS.get());
        this.add(ModBlocks.PURPURONYXSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PURPURONYXSTONE_SLAB.get()));
    }
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
