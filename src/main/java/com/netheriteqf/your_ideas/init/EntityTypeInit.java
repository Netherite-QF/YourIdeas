package com.netheriteqf.your_ideas.init;

import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

import com.netheriteqf.your_ideas.YourIdeas;
import com.netheriteqf.your_ideas.common.entities.BrickEntity;
import com.netheriteqf.your_ideas.common.entities.NetherBrickEntity;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author Goulixiaoji , MaoMao
 */
public class EntityTypeInit {

        public static final EntityType<BrickEntity> BRICK_ENTITY_ENTITY_TYPE = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(YourIdeas.MOD_ID, "bricks"),
                        QuiltEntityTypeBuilder.<BrickEntity>create(SpawnGroup.MISC, BrickEntity::new)
                                        .setDimensions(EntityDimensions.fixed(0.25f, 0.25f))
                                        .maxBlockTrackingRange(4).trackingTickInterval(10)
                                        .build());

        public static final EntityType<NetherBrickEntity> NETHER_BRICK_ENTITY_ENTITY_TYPE = Registry.register(
                        Registries.ENTITY_TYPE,
                        new Identifier(YourIdeas.MOD_ID, "nether_bricks"),
                        QuiltEntityTypeBuilder.<NetherBrickEntity>create(SpawnGroup.MISC, NetherBrickEntity::new)
                                        .setDimensions(EntityDimensions.fixed(0.25f, 0.25f))
                                        .maxBlockTrackingRange(4).trackingTickInterval(10)
                                        .build());
}
