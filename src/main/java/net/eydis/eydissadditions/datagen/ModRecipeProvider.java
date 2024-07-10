package net.eydis.eydissadditions.datagen;

import net.eydis.eydissadditions.MCCourseMod;
import net.eydis.eydissadditions.block.ModBlocks;
import net.eydis.eydissadditions.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> PURPURONYXSTONE_SMELTABLES = List.of(ModItems.RAW_PURPURONYXSTONE.get(), ModBlocks.PURPURONYXSTONE_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPURONYXSTONEBLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.PURPURONYXSTONE.get())
                .unlockedBy("has_pupuronyxstone", inventoryTrigger(ItemPredicate.Builder.item().
                            of(ModItems.PURPURONYXSTONE.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPURONYXSTONE_STAIRS.get())
                .pattern("  A")
                .pattern(" AA")
                .pattern("AAA")
                .define('A', ModItems.PURPURONYXSTONE.get())
                .unlockedBy("has_pupuronyxstone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURPURONYXSTONE.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPURONYXSTONE_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("AAA")
                .define('A', ModItems.PURPURONYXSTONE.get())
                .unlockedBy("has_pupuronyxstone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURPURONYXSTONE.get()).build()))
                .save(pWriter);



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURPURONYXSTONE.get(),9)
                .requires(ModBlocks.PURPURONYXSTONEBLOCK.get())
                .unlockedBy("has_purpuronyxstoneblock", inventoryTrigger(ItemPredicate.Builder.item().
                    of(ModBlocks.PURPURONYXSTONEBLOCK.get()).build()))
                .save(pWriter);
        //geht auch so:
        //nineBlockStorageRecipes(pWriter,RecipeCategory.MISC,ModItems.RAW_PURPURONYXSTONE.get(),RecipeCategory.MISC,ModBlocks.RAW_PURPURONIXSTONEBLOCK.get(),
        // "eydissadditions:raw_purpuronyxstone",null,"eydissadditions:raw_purpuronyxstoneblock",null);
        oreSmelting(pWriter, PURPURONYXSTONE_SMELTABLES, RecipeCategory.MISC, ModItems.PURPURONYXSTONE.get(), 0.25f, 200, "purpuronyxstone");
        oreBlasting(pWriter, PURPURONYXSTONE_SMELTABLES, RecipeCategory.MISC, ModItems.PURPURONYXSTONE.get(), 0.20f, 100, "purpuronyxstone");



    }
    protected static void oreSmelting(Consumer<FinishedRecipe>pFinishedRecipeConsumer, List <ItemLike>pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE,pIngredients,pCategory, pResult, pExperience, pCookingTIme,pGroup, "_from_smelting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe>pFinishedRecipeConsumer, List <ItemLike>pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE,pIngredients,pCategory, pResult, pExperience, pCookingTIme,pGroup, "_from_blasting");
    }
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe>pCookingSerializer,
                                     List<ItemLike>pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName){
        for(ItemLike itemLike : pIngredients){
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike),pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemLike),has(itemLike))
                    .save(pFinishedRecipeConsumer, MCCourseMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
