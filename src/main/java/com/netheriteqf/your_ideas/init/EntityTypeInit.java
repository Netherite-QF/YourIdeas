package com.netheriteqf.your_ideas.init;

import com.netheriteqf.your_ideas.YourIdeas;
import com.netheriteqf.your_ideas.common.entities.BrickEntity;
import com.netheriteqf.your_ideas.common.entities.NetherBrickEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * @author Goulixiaoji , MaoMao
 */
public class EntityTypeInit {

    public static final EntityType<BrickEntity> BRICK_ENTITY_ENTITY_TYPE = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(YourIdeas.MOD_ID, "bricks"),
            FabricEntityTypeBuilder.<BrickEntity>create(SpawnGroup.MISC, BrickEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
            );
    public static final EntityType<NetherBrickEntity> NETHER_BRICK_ENTITY_ENTITY_TYPE = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(YourIdeas.MOD_ID, "nether_bricks"),
            FabricEntityTypeBuilder.<NetherBrickEntity>create(SpawnGroup.MISC, NetherBrickEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
}