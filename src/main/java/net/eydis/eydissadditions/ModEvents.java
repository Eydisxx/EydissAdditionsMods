package net.eydis.eydissadditions;

import net.eydis.eydissadditions.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void onBlockRightClick(PlayerInteractEvent.RightClickBlock event) {
        System.out.println("Right-click event triggered!"); // Debug-Ausgabe

        Level level = event.getLevel();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();
        BlockState blockState = level.getBlockState(pos);

        // Check if the block is Crying Obsidian
        if (blockState.is(Blocks.CRYING_OBSIDIAN)) {
            System.out.println("Crying Obsidian block detected!"); // Debug: Richtiger Block

            InteractionHand hand = event.getHand();
            ItemStack heldItem = player.getItemInHand(hand);

            // Check if the held item is a bottle
            if (heldItem.is(Items.GLASS_BOTTLE)) {
                System.out.println("Player is holding a bottle!"); // Debug: Richtiger Gegenstand

                if (!level.isClientSide) {
                    // Replace block with Obsidian
                    level.setBlock(pos, Blocks.OBSIDIAN.defaultBlockState(), 3);
                    System.out.println("Crying Obsidian replaced with Obsidian!"); // Debug: Block ersetzt

                    // Give the player a Crying Bottle
                    ItemStack cryingBottle = new ItemStack(ModItems.CRYING_BOTTLE.get());
                    heldItem.shrink(1); // Remove one bottle
                    if (!player.addItem(cryingBottle)) {
                        player.drop(cryingBottle, false); // Drop if inventory is full
                        System.out.println("Crying Bottle dropped!"); // Debug: Item gedroppt
                    }
                }
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }
    }
}
