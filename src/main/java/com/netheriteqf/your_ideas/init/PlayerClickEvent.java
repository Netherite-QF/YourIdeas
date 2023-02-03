package com.netheriteqf.your_ideas.init;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class PlayerClickEvent {
    public static void init() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) ->
        {
            ActionResult result = ActionResult.SUCCESS;
            BlockState state = world.getBlockState(pos);
            if (state.getBlock() == Blocks.PISTON & player.getMainHandStack().getItem() == Items.SLIME_BALL) {
                world.setBlockState(pos, Blocks.STICKY_PISTON.getDefaultState());
            } else if (state.getBlock() == Blocks.STICKY_PISTON & player.getMainHandStack().getItem() == Items.SHEARS) {
                world.setBlockState(pos, Blocks.PISTON.getDefaultState());
                player.dropItem(Items.SLIME_BALL);
            }
            return result;
        });
    }
}
