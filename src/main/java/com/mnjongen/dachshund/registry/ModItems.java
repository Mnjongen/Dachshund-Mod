package com.mnjongen.dachshund.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import com.mnjongen.dachshund.Dachshund;
import com.mnjongen.dachshund.item.DachshundWhistleItem;

public class ModItems {
    public static final ResourceKey<Item> DACHSHUND_WHISTLE_KEY =
            ResourceKey.create(Registries.ITEM, Dachshund.id("dachshund_whistle"));

    public static final Item DACHSHUND_WHISTLE = Registry.register(
            BuiltInRegistries.ITEM,
            DACHSHUND_WHISTLE_KEY,
            new DachshundWhistleItem(new Item.Properties().setId(DACHSHUND_WHISTLE_KEY).stacksTo(1))
    );

    public static void init() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS)
                .register(output -> output.accept(DACHSHUND_WHISTLE));
    }
}
