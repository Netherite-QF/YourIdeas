package com.netheriteqf.your_ideas.init;

import com.netheriteqf.your_ideas.YourIdeas;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

/**
 * @author Goulixiaoji
 */
public class SoundEventInit {
    public static final Identifier BRICK_THROWN_IDENTIFIER = new Identifier(YourIdeas.MOD_ID, "entity.brick.throw");
    public static final Identifier NETHER_BRICK_THROWN_IDENTIFIER = new Identifier(YourIdeas.MOD_ID,
            "entity.nether_brick.throw");

    public static SoundEvent BRICK_THROWN = SoundEvent.createVariableRangeEvent(BRICK_THROWN_IDENTIFIER);
    public static SoundEvent NETHER_BRICK_THROWN = SoundEvent.createVariableRangeEvent(NETHER_BRICK_THROWN_IDENTIFIER);

    public static void init() {
        Registry.register(Registries.SOUND_EVENT, BRICK_THROWN_IDENTIFIER, BRICK_THROWN);
        Registry.register(Registries.SOUND_EVENT, NETHER_BRICK_THROWN_IDENTIFIER, NETHER_BRICK_THROWN);
    }
}
