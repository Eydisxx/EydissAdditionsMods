package net.eydis.eydissadditions.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ToolSharpenerItem extends Item {

    public ToolSharpenerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        if (!world.isClientSide()) {
            Player player = context.getPlayer();
            if (player != null) {
                ItemStack offhandItem = player.getItemInHand(InteractionHand.OFF_HAND);

                if (!offhandItem.isEmpty() && (offhandItem.isDamageableItem())) {
                    offhandItem.setDamageValue(0);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }
}


