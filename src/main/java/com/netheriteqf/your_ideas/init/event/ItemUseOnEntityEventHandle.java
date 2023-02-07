package com.netheriteqf.your_ideas.init.event;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

import com.netheriteqf.your_ideas.config.ModConfig;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

/**
 * @author Goulixiaoji
 */
public class ItemUseOnEntityEventHandle implements UseEntityCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity,
            @Nullable EntityHitResult hitResult) {
        ItemStack stack = player.getStackInHand(hand);

        if (entity instanceof IronGolemEntity livingEntity && ModConfig.get().canFixLotsIronGolem) {
            if (stack.isOf(Items.IRON_BLOCK)) {
                livingEntity.heal(9 * 25.0F);
                Random random = new Random();
                livingEntity
                        .addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, random.nextInt(14) + 1, 4));

                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_IRON_GOLEM_REPAIR,
                        SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

                if (!player.isCreative()) {
                    stack.decrement(1);
                }
            }
        }

        return ActionResult.PASS;
    }

}
