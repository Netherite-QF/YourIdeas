package com.netheriteqf.your_ideas.mixin;

import net.minecraft.entity.Entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HuskEntity;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.logging.Logger;

@Mixin(HuskEntity.class)
public class HuskAttackMixin {
    @Debug
    @Inject(method = "tryAttack", at = @At("RETURN"))
    public void tryAttack(Entity target, CallbackInfoReturnable<Boolean> cir) {
        if (target instanceof LivingEntity) {
            int random = target.getWorld().getRandom().nextInt(0, 10);
            if (random == 1) {
                ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 140, 2));
            }
        }
    }
}
