package com.netheriteqf.your_ideas;


import net.fabricmc.api.ModInitializer;
import org.abstruck.qwq.library.event.reflection.EventLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Goulixiaoji
 */
public class YourIdeas implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(YourIdeas.class);
    public static final String MOD_ID = "your_ideas";

    @Override
    public void onInitialize() {
        LOGGER.info("[YourIdeas] Welcome to use YourIdeas!");
        EventLoader.initEvent("com.netheriteqf.your_ideas.init.event");
    }
}
