package com.netheriteqf.your_ideas.client;

import com.netheriteqf.your_ideas.init.EntityTypeInit;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

/**
 * @author Goulixiaoji, MaoMao
 */
@Environment(EnvType.CLIENT)
public class YourIdeasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityTypeInit.BRICK_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EntityTypeInit.NETHER_BRICK_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
    }
}
