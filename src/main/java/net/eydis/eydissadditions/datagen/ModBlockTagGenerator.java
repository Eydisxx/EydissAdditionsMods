package net.eydis.eydissadditions.datagen;

import net.eydis.eydissadditions.MCCourseMod;
import net.eydis.eydissadditions.block.ModBlocks;
import net.eydis.eydissadditions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
       // this.tag(ModTag.Blocks.METAL_DETECTOR_VALUABLES)
         //       .add(ModBlocks.PURPURONYXSTONE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PURPURONYXSTONE_ORE.get(),
                        ModBlocks.PURPURONYXSTONEBLOCK.get(),
                        ModBlocks.PURPURONYXSTONE_STAIRS.get(),
                        ModBlocks.PURPURONYXSTONE_SLAB.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PURPURONYXSTONE_ORE.get(),
                        ModBlocks.PURPURONYXSTONEBLOCK.get(),
                        ModBlocks.PURPURONYXSTONE_STAIRS.get(),
                        ModBlocks.PURPURONYXSTONE_SLAB.get());
        //this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
          //      .add(ModBlocks.NETHERITE_PURPURONYXSTONE_ORE.get(),
            //            ModBlocks.ENDSTONE_PURPURONYXSTONE_ORE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
