package com.netheriteqf.your_ideas.init;

import com.netheriteqf.your_ideas.YourIdeas;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * @author Goulixiaoji
 */
public class SoundEventInit {
    public static final Identifier BRICK_THROWN_IDENTIFIER = new Identifier(YourIdeas.MOD_ID, "entity.brick.throw");
    public static final Identifier NETHER_BRICK_THROWN_IDENTIFIER = new Identifier(YourIdeas.MOD_ID, "entity.nether_brick.throw");
    public static SoundEvent BRICK_THROWN = new SoundEvent(BRICK_THROWN_IDENTIFIER);
    public static SoundEvent NETHER_BRICK_THROWN = new SoundEvent(NETHER_BRICK_THROWN_IDENTIFIER);

    public static void init() {
        Registry.register(Registry.SOUND_EVENT, BRICK_THROWN_IDENTIFIER, BRICK_THROWN);
        Registry.register(Registry.SOUND_EVENT, NETHER_BRICK_THROWN_IDENTIFIER, NETHER_BRICK_THROWN);
    }
}
