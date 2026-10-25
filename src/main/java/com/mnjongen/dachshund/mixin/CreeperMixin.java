package com.mnjongen.dachshund.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import com.mnjongen.dachshund.entity.DachshundEntity;

@Mixin(Creeper.class)
public abstract class CreeperMixin extends Monster {

    // Never called; only needed so this class compiles as a subclass of Monster
    protected CreeperMixin(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Inject(method = "registerGoals", at = @At("TAIL"))
    private void dachshund$avoidDachshunds(CallbackInfo ci) {
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(
                (Creeper) (Object) this, DachshundEntity.class, 18.0F, 1.0, 1.5));
    }
}
