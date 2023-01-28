package com.netheriteqf.your_ideas.init.event;

import com.netheriteqf.your_ideas.entities.BrickEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.abstruck.qwq.library.event.ModEvent;
import org.abstruck.qwq.library.event.SubscribeEvent;
import org.abstruck.qwq.library.events.item.ItemEvent;

/**
 * @author Goulixiaoji, MaoMao
 */
@ModEvent
public class OnUseItemHandle {
    @SubscribeEvent
    public static void onUseItem(ItemEvent.OnUseEvent event) {
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        Hand hand = event.getHand();
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();

        if (item == Items.BRICK) {
            player.getItemCooldownManager().set(item, 20);
            if (!world.isClient) {
                BrickEntity brickEntity = new BrickEntity(world, player);
                brickEntity.setItem(itemStack);
                brickEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 0.8F, 0F);
                world.spawnEntity(brickEntity);
            }

            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

            if (!player.isCreative()){
                itemStack.decrement(1);
            }
        }
    }
}
