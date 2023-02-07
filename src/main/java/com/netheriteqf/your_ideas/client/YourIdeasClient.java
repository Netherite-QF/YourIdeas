package com.netheriteqf.your_ideas.client;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

import com.netheriteqf.your_ideas.init.EntityTypeInit;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

/**
 * @author Goulixiaoji, MaoMao
 */
@ClientOnly
public class YourIdeasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        EntityRendererRegistry.register(EntityTypeInit.BRICK_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EntityTypeInit.NETHER_BRICK_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
    }
}
