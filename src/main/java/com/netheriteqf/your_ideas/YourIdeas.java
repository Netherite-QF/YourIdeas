package com.netheriteqf.your_ideas;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netheriteqf.your_ideas.config.ModConfig;
import com.netheriteqf.your_ideas.init.ItemInit;
import com.netheriteqf.your_ideas.init.SoundEventInit;
import com.netheriteqf.your_ideas.init.event.ItemUseOnEntityEventHandle;
import com.netheriteqf.your_ideas.init.event.OnUseItemHandle;
import com.netheriteqf.your_ideas.init.event.PlayerClickEventHandle;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;

/**
 * @author Goulixiaoji, Oganesson897
 */
public class YourIdeas implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(YourIdeas.class);
    public static final String MOD_ID = "your_ideas";

    @Override
    public void onInitialize(ModContainer mod) {
        LOGGER.info("[YourIdeas] Welcome to use YourIdeas!");
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        SoundEventInit.init();
        ItemInit.init();

        UseBlockCallback.EVENT.register(new PlayerClickEventHandle());
        UseEntityCallback.EVENT.register(new ItemUseOnEntityEventHandle());
        UseItemCallback.EVENT.register(new OnUseItemHandle());
    }
}
