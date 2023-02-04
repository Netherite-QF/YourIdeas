package com.netheriteqf.your_ideas;


import com.netheriteqf.your_ideas.config.ModConfig;
import com.netheriteqf.your_ideas.init.ItemInit;
import com.netheriteqf.your_ideas.init.PlayerClickEvent;
import com.netheriteqf.your_ideas.init.SoundEventInit;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import org.abstruck.qwq.library.event.reflection.EventLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Goulixiaoji, Oganesson897
 */
public class YourIdeas implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(YourIdeas.class);
    public static final String MOD_ID = "your_ideas";

    @Override
    public void onInitialize() {
        LOGGER.info("[YourIdeas] Welcome to use YourIdeas!");
        EventLoader.initEvent("com.netheriteqf.your_ideas.init.event");
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        SoundEventInit.init();
        PlayerClickEvent.init();
        ItemInit.init();
    }
}
