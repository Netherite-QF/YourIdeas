package com.netheriteqf.your_ideas.common.items;

import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public class PhantomelytraItem extends ElytraItem {
    public PhantomelytraItem() {
        super(new Item.Settings().maxDamage(216).group(ItemGroup.TRANSPORTATION).rarity(Rarity.UNCOMMON));
    }
}
