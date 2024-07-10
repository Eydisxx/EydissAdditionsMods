package net.eydis.eydissadditions.util;

import net.eydis.eydissadditions.MCCourseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(MCCourseMod.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String Name) {
            return ItemTags.create(new ResourceLocation("forge,name"));
        }
    }

        public static class Blocks {
            public static final TagKey<Block>NEEDS_PURPURONYXSTONE_TOOL = tag("needs_purpuronyxstone_tool");

            private static TagKey<Block> tag(String name){
                return BlockTags.create(new ResourceLocation(MCCourseMod.MOD_ID,name));
            }
         private static TagKey<Block> forgeTag(String name) {
                return BlockTags.create(new ResourceLocation("forge", name));
         }

        }
    }