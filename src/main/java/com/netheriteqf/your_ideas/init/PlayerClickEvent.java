package com.netheriteqf.your_ideas.init;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class PlayerClickEvent {
    public static void init() {
        UseBlockCallback.EVENT.register(((player, world, hand, hitResult) ->
        {
            ItemStack item = player.getMainHandStack();
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(hitResult.getBlockPos());
            if (state.getBlock() == Blocks.PISTON & player.getMainHandStack().getItem() == Items.SLIME_BALL) {
                world.setBlockState(pos, Blocks.STICKY_PISTON.getStateWithProperties(state));
                player.setStackInHand(hand, new ItemStack(Items.SLIME_BALL, item.getCount()-1));
            } else if (state.getBlock() == Blocks.STICKY_PISTON & player.getMainHandStack().getItem() == Items.SHEARS) {
                player.dropItem(Items.SLIME_BALL);
                world.setBlockState(pos, Blocks.PISTON.getStateWithProperties(state));
            }
            return ActionResult.PASS;
        }));
    }
}
