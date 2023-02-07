package com.netheriteqf.your_ideas.init.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlayerClickEventHandle implements UseBlockCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        ItemStack item = player.getMainHandStack();
        BlockPos pos = hitResult.getBlockPos();
        BlockState state = world.getBlockState(hitResult.getBlockPos());
        if (state.isOf(Blocks.PISTON) & player.getMainHandStack().isOf(Items.SLIME_BALL)) {
            world.setBlockState(pos, Blocks.STICKY_PISTON.getStateWithProperties(state));
            player.setStackInHand(hand, new ItemStack(Items.SLIME_BALL, item.getCount() - 1));
        } else if (state.getBlock() == Blocks.STICKY_PISTON & player.getMainHandStack().isOf(Items.SHEARS)) {
            player.dropItem(Items.SLIME_BALL);
            world.setBlockState(pos, Blocks.PISTON.getStateWithProperties(state));
        }
        return ActionResult.PASS;
    }

}
