package com.mnjongen.dachshund.registry;
    
import net.minecraft.resources.ResourceKey;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import com.mnjongen.dachshund.Dachshund;
import com.mnjongen.dachshund.entity.DachshundEntity;

public class ModEntities {
    public static final ResourceKey<EntityType<?>> DACHSHUND_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Dachshund.id("dachshund"));

    public static final EntityType<DachshundEntity> DACHSHUND = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            DACHSHUND_KEY,
            EntityType.Builder.of(DachshundEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 0.5F)   // hitbox width, height: low and small
                    .build(DACHSHUND_KEY)
    );

    public static void init() {
        FabricDefaultAttributeRegistry.register(DACHSHUND, DachshundEntity.createAttributes());
    }
}
