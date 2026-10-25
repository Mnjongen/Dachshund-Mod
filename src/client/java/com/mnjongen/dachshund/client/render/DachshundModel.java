package com.mnjongen.dachshund.client.render;

import com.mnjongen.dachshund.Dachshund;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.WolfRenderState;
import net.minecraft.util.Mth;

/*
 * Converted from an OptiFine JEM. The original file was a wolf replacement holding several breeds;
 * only the dachshund parts are kept here (the wolf parts had no texture and were invisible anyway).
 *
 * The whole dog hangs under "mane" -> "mane_rotation", which is rotated 90 degrees around X.
 * Inside that frame the axes are swapped: local Y points backwards, local Z points up.
 * So "turn left/right" and "wag" use zRot instead of yRot.
 */
public class DachshundModel extends EntityModel<WolfRenderState> {
	// A "layer" is the ID the game uses to find and bake this model
	public static final ModelLayerLocation LAYER =
			new ModelLayerLocation(Dachshund.id("dachshund"), "main");

	private final ModelPart dog;
	private final ModelPart dogRotation;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart rightHindLeg;
	private final ModelPart leftHindLeg;
	private final ModelPart leftFrontLeg;
	private final ModelPart rightFrontLeg;

	public DachshundModel(ModelPart root) {
		super(root);
		this.dog = root.getChild("mane");
		this.dogRotation = this.dog.getChild("mane_rotation");
		ModelPart dachshund = this.dogRotation.getChild("mane_sub_1").getChild("Dachshund3");
		this.head = dachshund.getChild("Dachshund_head");
		this.tail = dachshund.getChild("Dachshund_body").getChild("dachshund_tail");
		this.rightHindLeg = dachshund.getChild("Dachshundjackrusselleg1");
		this.leftHindLeg = dachshund.getChild("Dachshundjackrusselleg2");
		this.leftFrontLeg = dachshund.getChild("Dachshundjackrusselleg3");
		this.rightFrontLeg = dachshund.getChild("Dachshundjackrusselleg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition mane = root.addOrReplaceChild("mane", CubeListBuilder.create(), PartPose.offset(-1.0F, 14.0F, 2.0F));
		PartDefinition mane_rotation = mane.addOrReplaceChild("mane_rotation", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 2.5F, -2.5F, 1.5708F, 0.0F, 0.0F));
		PartDefinition mane_sub_1 = mane_rotation.addOrReplaceChild("mane_sub_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Dachshund3 = mane_sub_1.addOrReplaceChild("Dachshund3", CubeListBuilder.create().texOffs(1741, 0).addBox(-3.0F, -5.25F, -4.5F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		// Head
		PartDefinition Dachshund_head = Dachshund3.addOrReplaceChild("Dachshund_head", CubeListBuilder.create(), PartPose.offset(0.0F, -4.5F, 1.9F));

		PartDefinition Dachshund_rotation = Dachshund_head.addOrReplaceChild("Dachshund_rotation", CubeListBuilder.create().texOffs(882, 0).addBox(-2.5F, -2.1F, -2.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F))
		.texOffs(869, 1).addBox(-1.8F, -0.7171F, -2.67F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(869, 1).addBox(0.8F, -0.7171F, -2.67F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 2.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition mond3 = Dachshund_rotation.addOrReplaceChild("mond3", CubeListBuilder.create().texOffs(902, 0).addBox(-1.5F, -8.3993F, -13.6059F, 3.0F, 2.0F, 5.0F, new CubeDeformation(-0.3F))
		.texOffs(962, 14).addBox(-1.5F, -7.004F, -13.6059F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.305F))
		.texOffs(1124, 8).addBox(-1.5F, -9.0801F, -14.3874F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.9F))
		.texOffs(869, 1).addBox(-0.5F, -7.3932F, -13.5561F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, 7.35F, 7.9F, 0.1134F, 0.0F, 0.0F));

		mond3.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(1062, 11).addBox(-1.5F, 0.9935F, -1.6001F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.307F)), PartPose.offsetAndRotation(0.0F, -7.7035F, -11.941F, -0.0436F, 0.0F, 0.0F));

		mond3.addOrReplaceChild("bone45", CubeListBuilder.create().texOffs(909, 8).addBox(-1.0F, -10.558F, -14.2037F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -3.84F, 5.1581F, 0.3927F, 0.0F, 0.0F));

		// Ears
		PartDefinition oor9 = Dachshund_rotation.addOrReplaceChild("oor9", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.3038F, 1.2172F, -0.8545F, -0.1554F, -0.6055F, 0.0722F));

		oor9.addOrReplaceChild("mane_sub_118", CubeListBuilder.create().texOffs(902, 10).mirror().addBox(-0.2852F, -1.9242F, -1.1014F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(914, 1).mirror().addBox(-0.062F, 0.7548F, -0.2145F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone27 = oor9.addOrReplaceChild("bone27", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6819F, -2.097F, 0.8328F, 0.0F, 0.3927F, 0.0F));

		bone27.addOrReplaceChild("mane_sub_120", CubeListBuilder.create().texOffs(904, 18).mirror().addBox(-0.1739F, -0.9552F, -1.3763F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition oor10 = Dachshund_rotation.addOrReplaceChild("oor10", CubeListBuilder.create().texOffs(902, 10).addBox(-0.7148F, -1.9242F, -1.1014F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(914, 1).addBox(-0.893F, 0.759F, -0.3575F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3038F, 1.2172F, -0.8545F, -0.1554F, 0.6055F, -0.0722F));

		oor10.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(904, 18).addBox(-0.8261F, -0.9552F, -1.3763F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6819F, -2.097F, 0.8328F, 0.0F, -0.3927F, 0.0F));

		// Neck and body
		PartDefinition dachshund_neck = Dachshund3.addOrReplaceChild("dachshund_neck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.7293F, -0.3702F, 0.3927F, 0.0F, 0.0F));

		dachshund_neck.addOrReplaceChild("dachshund_neck_rotation", CubeListBuilder.create().texOffs(887, 22).addBox(-1.95F, -2.231F, -1.9043F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.05F, 0.0164F, 1.3462F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Dachshund_body = Dachshund3.addOrReplaceChild("Dachshund_body", CubeListBuilder.create().texOffs(909, 18).addBox(-2.5F, -0.75F, -6.7F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 2.5F, 3.1F));

		// Tail
		PartDefinition dachshund_tail = Dachshund_body.addOrReplaceChild("dachshund_tail", CubeListBuilder.create(), PartPose.offset(0.0F, 6.15F, -2.55F));

		dachshund_tail.addOrReplaceChild("dachshund_tail_rotation", CubeListBuilder.create().texOffs(860, 11).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, 1.0F, -2.75F, -1.1781F, 0.0F, 0.0F));

		// Legs: 1 = right hind, 2 = left hind, 3 = left front, 4 = right front
		PartDefinition Dachshundjackrusselleg1 = Dachshund3.addOrReplaceChild("Dachshundjackrusselleg1", CubeListBuilder.create(), PartPose.offset(-1.5F, 6.5F, -3.5F));

		Dachshundjackrusselleg1.addOrReplaceChild("Dachshundjackrusselleg1_rotation3", CubeListBuilder.create().texOffs(925, 0).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Dachshundjackrusselleg2 = Dachshund3.addOrReplaceChild("Dachshundjackrusselleg2", CubeListBuilder.create(), PartPose.offset(1.5F, 6.5F, -3.5F));

		Dachshundjackrusselleg2.addOrReplaceChild("Dachshundjackrusselleg2_rotation2", CubeListBuilder.create().texOffs(925, 0).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Dachshundjackrusselleg3 = Dachshund3.addOrReplaceChild("Dachshundjackrusselleg3", CubeListBuilder.create(), PartPose.offset(1.5F, -3.0F, -3.5F));

		Dachshundjackrusselleg3.addOrReplaceChild("Dachshundjackrusselleg3_rotation", CubeListBuilder.create().texOffs(925, 0).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Dachshundjackrusselleg4 = Dachshund3.addOrReplaceChild("Dachshundjackrusselleg4", CubeListBuilder.create(), PartPose.offset(-1.5F, -3.0F, -3.5F));

		Dachshundjackrusselleg4.addOrReplaceChild("Dachshundjackrusselleg4_rotation2", CubeListBuilder.create().texOffs(925, 0).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(mesh, 2000, 32);
	}

	@Override
	public void setupAnim(WolfRenderState state) {
		super.setupAnim(state); // resets every part to its default pose first

		// Head follows where the dog is looking (zRot = left/right in this rotated frame)
		head.xRot = state.xRot * Mth.DEG_TO_RAD;
		head.zRot = -state.yRot * Mth.DEG_TO_RAD;

		if (state.isSitting) {
			setSittingPose();
		} else {
			// Leg swing while walking (same formula vanilla uses for four-legged mobs)
			float pos = state.walkAnimationPos;
			float speed = state.walkAnimationSpeed;
			rightHindLeg.xRot = Mth.cos(pos * 0.6662F) * 1.4F * speed;
			leftHindLeg.xRot = Mth.cos(pos * 0.6662F + Mth.PI) * 1.4F * speed;
			rightFrontLeg.xRot = Mth.cos(pos * 0.6662F + Mth.PI) * 1.4F * speed;
			leftFrontLeg.xRot = Mth.cos(pos * 0.6662F) * 1.4F * speed;
		}

		// Happy tail wag
		tail.zRot = Mth.cos(state.ageInTicks * 0.6F) * 0.4F;
	}

	/*
	 * Based on the vanilla wolf's sitting pose (WolfModel / AdultWolfModel.setSittingPose).
	 * The wolf bends its body in two pieces; this dog is one rigid piece, so the whole dog
	 * gets the wolf's chest tilt and the legs get the same angles as the wolf's legs.
	 */
	private void setSittingPose() {
		// Tilt the whole dog back like the wolf's upper body (vanilla: 1.2566371 instead of 90 degrees),
		// then lower it so the bottom rests on the ground
		dogRotation.xRot = 1.2566371F;
		dog.y += 1.4F;

		// Hind legs folded flat forward (vanilla: 270 degrees, minus the body tilt they inherit)
		float tilt = Mth.HALF_PI - dogRotation.xRot;
		rightHindLeg.xRot = -(Mth.HALF_PI - tilt);
		leftHindLeg.xRot = -(Mth.HALF_PI - tilt);

		// Front legs angled slightly forward (vanilla: 333 degrees, i.e. -0.4712, minus the body tilt)
		rightFrontLeg.xRot = tilt - 0.4712389F;
		leftFrontLeg.xRot = tilt - 0.4712389F;
	}
}
