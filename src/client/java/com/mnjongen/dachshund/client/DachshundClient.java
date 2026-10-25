package com.mnjongen.dachshund.client;

import com.mnjongen.dachshund.client.render.DachshundModel;
import com.mnjongen.dachshund.client.render.DachshundRenderer;
import com.mnjongen.dachshund.registry.ModEntities;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;

public class DachshundClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModelLayerRegistry.registerModelLayer(DachshundModel.LAYER, DachshundModel::createBodyLayer);
		EntityRenderers.register(ModEntities.DACHSHUND, DachshundRenderer::new);
	}
}
