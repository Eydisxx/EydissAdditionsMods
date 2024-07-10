package net.eydis.eydissadditions.item;

import net.eydis.eydissadditions.MCCourseMod;
import net.eydis.eydissadditions.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier PURPURONYXSTONE = TierSortingRegistry.registerTier(
        new ForgeTier(5, 2000, 9f, 3, 26,
              ModTags.Blocks.NEEDS_PURPURONYXSTONE_TOOL, () -> Ingredient.of(ModItems.PURPURONYXSTONE.get())),
   new ResourceLocation(MCCourseMod.MOD_ID, "purpuronyxstone"), List.of(Tiers.NETHERITE), List.of());
}
