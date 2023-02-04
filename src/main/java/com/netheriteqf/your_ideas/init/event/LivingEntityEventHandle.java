package com.netheriteqf.your_ideas.init.event;

import com.netheriteqf.your_ideas.config.ModConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.abstruck.qwq.library.event.ModEvent;
import org.abstruck.qwq.library.event.SubscribeEvent;
import org.abstruck.qwq.library.events.entity.LivingEntityEvent;

/**
 * @author Goulixiaoji, MoaMao
 */
@ModEvent
public class LivingEntityEventHandle {
    @SubscribeEvent
    public static void withHeartOfTheSea(LivingEntityEvent.TickEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof PlayerEntity player) {
            ItemStack offHandStack = player.getOffHandStack();
            if (offHandStack.isOf(Items.HEART_OF_THE_SEA) && ModConfig.get().canHeartOfTheSeaStatusEffects) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20, 1));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20, 0));
            }
        }
    }
}

