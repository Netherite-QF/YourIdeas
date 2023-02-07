package com.netheriteqf.your_ideas.init.event;

import com.netheriteqf.your_ideas.config.ModConfig;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;

/**
 * @author Goulixiaoji, MoaMao
 */
public class ServerWorldTickEventHandle implements ServerTickEvents.StartWorldTick {

    @Override
    public void onStartTick(ServerWorld world) {
        world.getPlayers().forEach(player -> {
            ItemStack offHandStack = player.getOffHandStack();
            if (offHandStack.isOf(Items.HEART_OF_THE_SEA) && ModConfig.get().canHeartOfTheSeaStatusEffects) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20, 1));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20, 0));
            }
        });
    }

}
