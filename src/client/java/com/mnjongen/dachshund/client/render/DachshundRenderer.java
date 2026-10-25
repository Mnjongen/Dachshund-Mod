package com.mnjongen.dachshund.client.render;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.WolfRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

import com.mnjongen.dachshund.Dachshund;
import com.mnjongen.dachshund.entity.DachshundEntity;

public class DachshundRenderer extends MobRenderer<DachshundEntity, WolfRenderState, DachshundModel> {
    private static final Identifier TEXTURE = Dachshund.id("textures/entity/dachshund.png");

    public DachshundRenderer(EntityRendererProvider.Context context) {
        super(context, new DachshundModel(context.bakeLayer(DachshundModel.LAYER)), 0.4F); // 0.4 = shadow size
    }

    @Override
    public WolfRenderState createRenderState() {
        return new WolfRenderState();
    }

    @Override
    public void extractRenderState(DachshundEntity entity, WolfRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.isSitting = entity.isInSittingPose();
    }

    @Override
    public Identifier getTextureLocation(WolfRenderState state) {
        return TEXTURE;
    }
}
