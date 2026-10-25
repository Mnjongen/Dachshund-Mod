package com.mnjongen.dachshund.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import com.mnjongen.dachshund.entity.DachshundEntity;
import com.mnjongen.dachshund.registry.ModEntities;

public class DachshundWhistleItem extends Item {
    public DachshundWhistleItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!(context.getLevel() instanceof ServerLevel serverLevel)) {
            return InteractionResult.SUCCESS; // client: just play the arm swing
        }

        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        DachshundEntity dog = ModEntities.DACHSHUND.spawn(serverLevel, pos, EntitySpawnReason.SPAWN_ITEM_USE);

        Player player = context.getPlayer();
        if (dog != null && player != null) {
            dog.tame(player);
            // Use up the whistle (does nothing in creative mode, just like spawn eggs)
            context.getItemInHand().consume(1, player);
        }
        return InteractionResult.SUCCESS;
    }
}

