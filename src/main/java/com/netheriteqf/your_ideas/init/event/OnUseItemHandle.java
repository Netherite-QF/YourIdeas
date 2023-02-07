package com.netheriteqf.your_ideas.init.event;

import com.netheriteqf.your_ideas.common.entities.BrickEntity;
import com.netheriteqf.your_ideas.common.entities.NetherBrickEntity;
import com.netheriteqf.your_ideas.config.ModConfig;
import com.netheriteqf.your_ideas.init.SoundEventInit;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;

/**
 * @author Goulixiaoji, MaoMao
 */
public class OnUseItemHandle implements UseItemCallback {

    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.isOf(Items.BRICK) && ModConfig.get().canThrownBrick) {
            player.getItemCooldownManager().set(stack.getItem(), 20);
            if (!world.isClient) {
                BrickEntity brickEntity = new BrickEntity(world, player);
                brickEntity.setItem(stack);
                brickEntity.setProperties(player, player.getPitch(), player.getYaw(), 0.0F, 0.8F, 0F);
                world.spawnEntity(brickEntity);
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEventInit.BRICK_THROWN,
                        SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            }

            if (!player.isCreative()) {
                stack.decrement(1);
                return TypedActionResult.success(stack);
            }
        }

        if (stack.isOf(Items.FIRE_CHARGE) && ModConfig.get().canThrownFireCharge) {
            player.getItemCooldownManager().set(stack.getItem(), 40);
            if (!world.isClient()) {
                float yaw = player.getHeadYaw();
                float pitch = player.getPitch();
                float roll = 0.0F;

                float p = ModConfig.get().fireChargeFlyingSpeed;
                float f = -MathHelper.sin(yaw * ((float) Math.PI / 180))
                        * MathHelper.cos(pitch * ((float) Math.PI / 180));
                float g = -MathHelper.sin((pitch + roll) * ((float) Math.PI / 180));
                float h = MathHelper.cos(yaw * ((float) Math.PI / 180))
                        * MathHelper.cos(pitch * ((float) Math.PI / 180));

                FireballEntity fireballEntity = new FireballEntity(world, player, f * p, g * p, h * p,
                        ModConfig.get().fireChargeExplosionPower);
                fireballEntity.setPosition(player.getX(), player.getBodyY(0.5) + 0.5, player.getZ());
                world.spawnEntity(fireballEntity);

                RandomGenerator random = world.getRandom();
                world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0f,
                        (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f);
            }

            if (!player.isCreative()) {
                stack.decrement(1);
                return TypedActionResult.success(stack);
            }
        }

        if (stack.isOf(Items.NETHER_BRICK) && ModConfig.get().canThrownNetherBrick) {
            player.getItemCooldownManager().set(stack.getItem(), 20);
            if (!world.isClient) {
                NetherBrickEntity netherBrickEntity = new NetherBrickEntity(world, player);
                netherBrickEntity.setProperties(player, player.getPitch(), player.getYaw(), 0.0F, 0.8F, 0F);
                netherBrickEntity.setItem(stack);
                world.spawnEntity(netherBrickEntity);
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEventInit.NETHER_BRICK_THROWN,
                        SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            }

            if (!player.isCreative()) {
                stack.decrement(1);
                return TypedActionResult.success(stack);
            }
        }

        return TypedActionResult.pass(stack);
    }

}
