package com.netheriteqf.your_ideas.init;

import com.netheriteqf.your_ideas.YourIdeas;
import com.netheriteqf.your_ideas.common.items.EnchantedGoldenCarrotItem;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author Oganesson897
 */
public class ItemInit {

    public static final EnchantedGoldenCarrotItem ENCHANTED_GOLDEN_CARROT = item("enchanted_golden_carrot",
            new EnchantedGoldenCarrotItem());

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.GOLDEN_CARROT, ENCHANTED_GOLDEN_CARROT);
        });
    }

    public static <T extends Item> T item(String name, T item) {
        return Registry.register(Registries.ITEM, new Identifier(YourIdeas.MOD_ID, name), item);
    }

    public static Item item(String name) {
        return Registry.register(Registries.ITEM, new Identifier(YourIdeas.MOD_ID, name),
                new Item(new Item.Settings()));
    }

}
