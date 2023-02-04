package com.netheriteqf.your_ideas.init;

import com.netheriteqf.your_ideas.YourIdeas;
import com.netheriteqf.your_ideas.common.items.EnchantedGoldenCarrotItem;
import com.netheriteqf.your_ideas.common.items.PhantomelytraItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * @author Oganesson897
 */

public class ItemInit {
    public static void init() {
        item("enchanted_golden_carrot", new EnchantedGoldenCarrotItem());
        item("phantomelytra", new PhantomelytraItem());
    }

    public static Item item(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(YourIdeas.MOD_ID, name), item);
    }

    public static Item item(String name) {
        return Registry.register(Registry.ITEM, new Identifier(YourIdeas.MOD_ID, name), new Item(new Item.Settings()));
    }
}
