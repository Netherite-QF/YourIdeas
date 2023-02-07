package com.netheriteqf.your_ideas.common.entities;

import com.netheriteqf.your_ideas.init.EntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

/**
 * @author MaoMao , Goulixiaoji
 */
public class BrickEntity extends ThrownItemEntity {
    public BrickEntity(EntityType<? extends BrickEntity> entityType, World world) {
        super(entityType, world);
    }

    public BrickEntity(World world, LivingEntity owner) {
        super(EntityTypeInit.BRICK_ENTITY_ENTITY_TYPE, owner, world);
    }

    public BrickEntity(World world, double x, double y, double z) {
        super(EntityTypeInit.BRICK_ENTITY_ENTITY_TYPE, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.BRICK;
    }

    @Override
    public void handleStatus(byte status) {
        if (status == 3) {
            // double d = 0.08;
            for (int i = 0; i < 8; ++i) {
                this.world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack()), this.getX(),
                        this.getY(), this.getZ(), ((double) this.random.nextFloat() - 0.5) * 0.08,
                        ((double) this.random.nextFloat() - 0.5) * 0.08,
                        ((double) this.random.nextFloat() - 0.5) * 0.08);
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 4.0F);
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1));
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.world.isClient) {
            BlockState blockState = this.world.getBlockState(blockHitResult.getBlockPos());
            if (blockState.getMaterial() == Material.GLASS) {
                this.world.breakBlock(blockHitResult.getBlockPos(), true);
                this.world.addBlockBreakParticles(getBlockPos(), blockState.getBlock().getDefaultState());
            }
        }
    }
}
