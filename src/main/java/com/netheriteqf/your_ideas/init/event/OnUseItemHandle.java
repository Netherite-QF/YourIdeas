package com.netheriteqf.your_ideas.init.event;

import com.netheriteqf.your_ideas.common.entities.BrickEntity;
import com.netheriteqf.your_ideas.common.entities.NetherBrickEntity;
import com.netheriteqf.your_ideas.config.ModConfig;
import com.netheriteqf.your_ideas.init.SoundEventInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.abstruck.qwq.library.event.ModEvent;
import org.abstruck.qwq.library.event.SubscribeEvent;
import org.abstruck.qwq.library.events.item.ItemEvent;

import java.util.Random;

/**
 * @author Goulixiaoji, MaoMao
 */
@ModEvent
public class OnUseItemHandle {
    @SubscribeEvent
    public static void onUseBrick(ItemEvent.OnUseEvent event) {
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        Hand hand = event.getHand();
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();

        if (Items.BRICK == item && ModConfig.get().canThrownBrick) {
            player.getItemCooldownManager().set(item, 20);
            if (!world.isClient) {
                BrickEntity brickEntity = new BrickEntity(world, player);
                brickEntity.setItem(itemStack);
                brickEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 0.8F, 0F);
                world.spawnEntity(brickEntity);
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEventInit.BRICK_THROWN, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            }

            if (!player.isCreative()){
                itemStack.decrement(1);
            }
        }
    }

    @SubscribeEvent
    public static void onUseFireCharge(ItemEvent.OnUseEvent event) {
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        Hand hand = event.getHand();
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();

        if (Items.FIRE_CHARGE == item && ModConfig.get().canThrownFireCharge) {
            player.getItemCooldownManager().set(item, 40);
            if (!world.isClient) {
                float yaw = player.getHeadYaw();
                float pitch = player.getPitch();
                float roll = 0.0F;

                float p = ModConfig.get().fireChargeFlyingSpeed;
                float f = -MathHelper.sin(yaw * ((float)Math.PI / 180)) * MathHelper.cos(pitch * ((float)Math.PI / 180));
                float g = -MathHelper.sin((pitch + roll) * ((float)Math.PI / 180));
                float h = MathHelper.cos(yaw * ((float)Math.PI / 180)) * MathHelper.cos(pitch * ((float)Math.PI / 180));

                FireballEntity fireballEntity = new FireballEntity(world, player, f * p, g * p, h * p, ModConfig.get().fireChargeExplosionPower);
                fireballEntity.setPosition(player.getX(), player.getBodyY(0.5) + 0.5, player.getZ());
                world.spawnEntity(fireballEntity);

                Random random = world.getRandom();
                world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f);
            }

            if (!player.isCreative()){
                itemStack.decrement(1);
            }
        }
    }
    @SubscribeEvent
    public static void onUseNetherBrick(ItemEvent.OnUseEvent event) {
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        Hand hand = event.getHand();
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();

        if (Items.NETHER_BRICK == item && ModConfig.get().canThrownNetherBrick) {
            player.getItemCooldownManager().set(item, 20);
            if (!world.isClient) {
                NetherBrickEntity netherBrickEntity = new NetherBrickEntity(world, player);
                netherBrickEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 0.8F, 0F);
                netherBrickEntity.setItem(itemStack);
                world.spawnEntity(netherBrickEntity);
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEventInit.NETHER_BRICK_THROWN, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            }

            if (!player.isCreative()){
                itemStack.decrement(1);
            }
        }
    }
}
