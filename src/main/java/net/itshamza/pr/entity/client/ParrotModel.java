package net.itshamza.pr.entity.client;// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.itshamza.pr.entity.animations.ModAnimationDefinitions;
import net.itshamza.pr.entity.custom.ParrotEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ParrotModel<T extends ParrotEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("pr", "parrotmodel"), "main");
	private final ModelPart parrot;

	public ParrotModel(ModelPart root) {
		this.parrot = root.getChild("parrot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition parrot = partdefinition.addOrReplaceChild("parrot", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = parrot.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 0).addBox(-2.5F, -6.0F, -0.5858F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.25F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(15, 15).addBox(-3.5F, 0.0F, -0.5F, 6.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, 2.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.0F, -1.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.01F))
				.texOffs(15, 25).addBox(-2.5F, -4.0F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.01F))
				.texOffs(27, 23).addBox(-1.5F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.01F))
				.texOffs(11, 0).addBox(-1.5F, 0.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.25F, -0.3491F, 0.0F, 0.0F));

		PartDefinition frill = head.addOrReplaceChild("frill", CubeListBuilder.create().texOffs(0, 0).addBox(0.5F, -5.0F, -3.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offset(-1.0F, -4.0F, 0.0F));

		PartDefinition leg1 = parrot.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 28).addBox(0.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 10).addBox(0.0F, 2.0F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.25F));

		PartDefinition wing1 = parrot.addOrReplaceChild("wing1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -8.25F, -2.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition wing_r1 = wing1.addOrReplaceChild("wing_r1", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -2.0F, -2.0F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(7, 21).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition wing2 = parrot.addOrReplaceChild("wing2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -8.25F, -2.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition wing_r2 = wing2.addOrReplaceChild("wing_r2", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(7, 21).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition leg2 = parrot.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(25, 27).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(16, 9).addBox(-3.0F, 2.0F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -3.0F, -1.25F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		parrot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(ParrotEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(ModAnimationDefinitions.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
	}

	@Override
	public ModelPart root() {
		return parrot;
	}

}