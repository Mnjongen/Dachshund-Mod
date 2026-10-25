package com.mnjongen.dachshund.client.mixin;

import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.resources.SplashManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.List;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;

@Mixin(SplashManager.class)
public class SplashManagerMixin {

    // @Shadow gives you access to private fields of the class you're mixing into
    @Shadow private List<Component> splashes;
    @Shadow @Final private static RandomSource RANDOM;

    @Inject(method = "getSplash", at = @At("HEAD"), cancellable = true)
    private void dachshund$onlyOurSplashes(CallbackInfoReturnable<SplashRenderer> cir) {
        if (!this.splashes.isEmpty()) {
            Component splash = this.splashes.get(RANDOM.nextInt(this.splashes.size()));
            cir.setReturnValue(new SplashRenderer(splash));
        }
    }
}