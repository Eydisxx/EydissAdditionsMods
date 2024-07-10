package net.eydis.eydissadditions.datagen;

import net.eydis.eydissadditions.MCCourseMod;
import net.eydis.eydissadditions.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PURPURONYXSTONEBLOCK);
        blockWithItem(ModBlocks.PURPURONYXSTONE_ORE);
        stairsBlock((StairBlock) ModBlocks.PURPURONYXSTONE_STAIRS.get(), blockTexture(ModBlocks.PURPURONYXSTONEBLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.PURPURONYXSTONE_SLAB.get()), blockTexture(ModBlocks.PURPURONYXSTONEBLOCK.get()),blockTexture(ModBlocks.PURPURONYXSTONEBLOCK.get()));

    blockItem(ModBlocks.PURPURONYXSTONE_SLAB);
    blockItem(ModBlocks.PURPURONYXSTONE_STAIRS);
    }




    private void blockItem(RegistryObject<Block> blockRegistryObject){
    simpleBlockItem(blockRegistryObject.get(),
            new ModelFile.UncheckedModelFile("eydissadditions:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
