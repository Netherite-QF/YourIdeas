package com.netheriteqf.your_ideas.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.netheriteqf.your_ideas.config.ModConfig;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HuskEntity;

@Mixin(HuskEntity.class)
public class HuskAttackMixin {

    @Inject(method = "tryAttack", at = @At("RETURN"))
    public void tryAttack(Entity target, CallbackInfoReturnable<Boolean> cir) {
        if (target instanceof LivingEntity livingEntity) {
            int random = livingEntity.getWorld().getRandom().nextInt(0, 100);
            if (random >= ModConfig.get().huskAttackBlindnessChance && ModConfig.get().canHuskAttackBlindness) {
                livingEntity.addStatusEffect(
                        new StatusEffectInstance(StatusEffects.BLINDNESS, ModConfig.get().huskAttackBlindnessEffectTime,
                                ModConfig.get().huskAttackBlindnessEffectAmplifier));
            }
        }
    }

}
