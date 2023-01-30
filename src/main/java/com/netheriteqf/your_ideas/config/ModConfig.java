package com.netheriteqf.your_ideas.config;

import com.netheriteqf.your_ideas.YourIdeas;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

/**
 * @author Goulixiaoji, MaoMao
 */
@Config(name = YourIdeas.MOD_ID)
@Config.Gui.Background("minecraft:textures/block/bedrock.png")
public class ModConfig implements ConfigData {
    public static ModConfig get() {
        return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    public static void save() {
        AutoConfig.getConfigHolder(ModConfig.class).save();
    }

    @ConfigEntry.Gui.PrefixText
    public boolean canThrownBrick = true;
    public boolean canThrownNetherBrick = true;
    public boolean canThrownFireCharge = true;
    public float fireChargeFlyingSpeed = 1.0F;
    public int fireChargeExplosionPower = 4;
}
