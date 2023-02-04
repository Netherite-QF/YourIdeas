package com.netheriteqf.your_ideas.init.event;

import com.netheriteqf.your_ideas.config.ModConfig;
import com.netheriteqf.your_ideas.init.SoundEventInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.abstruck.qwq.library.event.ModEvent;
import org.abstruck.qwq.library.event.SubscribeEvent;
import org.abstruck.qwq.library.events.item.ItemEvent;

import java.util.Random;

/**
 * @author Goulixiaoji
 */
@ModEvent
public class ItemUseOnEntityEventHandle {
    @SubscribeEvent
    public static void fixLotsIronGolem(ItemEvent.UseOnEntityEvent event) {
        PlayerEntity player = event.getPlayer();
        LivingEntity livingEntity = event.getEntity();
        World world = player.getWorld();
        ItemStack stack = event.getStack();

        if (livingEntity instanceof IronGolemEntity && ModConfig.get().canFixLotsIronGolem) {
            if (stack.isOf(Items.IRON_BLOCK)) {
                livingEntity.heal(9 * 25.0F);
                Random random = new Random();
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, random.nextInt(14) + 1, 4));

                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_IRON_GOLEM_REPAIR, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

                if (!player.isCreative()) {
                    stack.decrement(1);
                }
            }
        }
    }
}
