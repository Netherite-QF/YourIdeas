package com.netheriteqf.your_ideas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netheriteqf.your_ideas.config.ModConfig;
import com.netheriteqf.your_ideas.init.ItemInit;
import com.netheriteqf.your_ideas.init.SoundEventInit;
import com.netheriteqf.your_ideas.init.event.ItemUseOnEntityEventHandle;
import com.netheriteqf.your_ideas.init.event.PlayerClickEventHandle;
import com.netheriteqf.your_ideas.init.event.ServerWorldTickEventHandle;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;

/**
 * @author Goulixiaoji, Oganesson897
 */
public class YourIdeas implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(YourIdeas.class);
    public static final String MOD_ID = "your_ideas";

    @Override
    public void onInitialize() {
        LOGGER.info("[YourIdeas] Welcome to use YourIdeas!");
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        SoundEventInit.init();
        ItemInit.init();

        UseBlockCallback.EVENT.register(new PlayerClickEventHandle());
        UseEntityCallback.EVENT.register(new ItemUseOnEntityEventHandle());
        ServerTickEvents.START_WORLD_TICK.register(new ServerWorldTickEventHandle());
    }
}
