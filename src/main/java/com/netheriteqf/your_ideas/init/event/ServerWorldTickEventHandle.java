package com.netheriteqf.your_ideas.init.event;

import org.quiltmc.qsl.entity.event.api.ServerEntityTickCallback;

import com.netheriteqf.your_ideas.config.ModConfig;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

/**
 * @author Goulixiaoji, MoaMao
 */
public class ServerWorldTickEventHandle implements ServerEntityTickCallback {

    @Override
    public void onServerEntityTick(Entity entity, boolean isPassengerTick) {
        if (entity instanceof PlayerEntity player) {
            ItemStack offHandStack = player.getOffHandStack();
            if (offHandStack.isOf(Items.HEART_OF_THE_SEA) && ModConfig.get().canHeartOfTheSeaStatusEffects) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20, 1));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20, 0));
            }
        }
    }

}
