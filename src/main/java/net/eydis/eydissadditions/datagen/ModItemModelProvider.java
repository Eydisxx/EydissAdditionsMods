package net.eydis.eydissadditions.datagen;

import net.eydis.eydissadditions.MCCourseMod;
import net.eydis.eydissadditions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.PURPURONYXSTONE);
        simpleItem(ModItems.RAW_PURPURONYXSTONE);
        simpleItem(ModItems.DRAGONFRUIT);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item>item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MCCourseMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
