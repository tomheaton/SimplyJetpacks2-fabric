// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package com.example.mod;

	public class custom_model extends EntityModel<LivingEntity> {
private final ModelPart middle;
	private final ModelPart leftTip1;
	private final ModelPart leftTip2;
	private final ModelPart rightTip1;
	private final ModelPart rightTip2;
	private final ModelPart leftCanister;
	private final ModelPart rightCanister;
	private final ModelPart leftExhaust1;
	private final ModelPart leftExhaust2;
	private final ModelPart rightExhaust1;
	private final ModelPart rightExhaust2;
public custom_model() {
		textureWidth = 64;
		textureHeight = 64;
		middle = new ModelPart(this);
		middle.setPivot(0.0F, 24.0F, 0.0F);
		middle.setTextureOffset(0, 54).addCuboid(-2.0F, -8.0F, 3.6F, 4.0F, 5.0F, 2.0F, 0.0F, false);

		leftTip1 = new ModelPart(this);
		leftTip1.setPivot(0.0F, 24.0F, 0.0F);
		leftTip1.setTextureOffset(0, 45).addCuboid(-4.0F, -2.0F, 3.1F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		leftTip2 = new ModelPart(this);
		leftTip2.setPivot(0.0F, 24.0F, 0.0F);
		leftTip2.setTextureOffset(0, 49).addCuboid(-3.5F, -1.0F, 3.6F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		rightTip1 = new ModelPart(this);
		rightTip1.setPivot(0.0F, 24.0F, 0.0F);
		rightTip1.setTextureOffset(17, 45).addCuboid(1.0F, -2.0F, 3.1F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		rightTip2 = new ModelPart(this);
		rightTip2.setPivot(0.0F, 24.0F, 0.0F);
		rightTip2.setTextureOffset(17, 49).addCuboid(1.5F, -1.0F, 3.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		leftCanister = new ModelPart(this);
		leftCanister.setPivot(0.0F, 24.0F, 0.0F);
		leftCanister.setTextureOffset(0, 32).addCuboid(-4.5F, -9.0F, 2.6F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		rightCanister = new ModelPart(this);
		rightCanister.setPivot(0.0F, 24.0F, 0.0F);
		rightCanister.setTextureOffset(17, 32).addCuboid(0.5F, -9.0F, 2.6F, 4.0F, 7.0F, 4.0F, 0.0F, true);

		leftExhaust1 = new ModelPart(this);
		leftExhaust1.setPivot(0.0F, 24.0F, 0.0F);
		leftExhaust1.setTextureOffset(35, 32).addCuboid(-4.0F, -10.0F, 3.1F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		leftExhaust2 = new ModelPart(this);
		leftExhaust2.setPivot(0.0F, 24.0F, 0.0F);
		leftExhaust2.setTextureOffset(35, 37).addCuboid(-4.5F, -13.0F, 2.6F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		rightExhaust1 = new ModelPart(this);
		rightExhaust1.setPivot(0.0F, 24.0F, 0.0F);
		rightExhaust1.setTextureOffset(48, 32).addCuboid(1.0F, -10.0F, 3.1F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		rightExhaust2 = new ModelPart(this);
		rightExhaust2.setPivot(0.0F, 24.0F, 0.0F);
		rightExhaust2.setTextureOffset(35, 45).addCuboid(0.5F, -13.0F, 2.6F, 4.0F, 3.0F, 4.0F, 0.0F, true);
}
@Override
public void setAngles(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		middle.render(matrixStack, buffer, packedLight, packedOverlay);
		leftTip1.render(matrixStack, buffer, packedLight, packedOverlay);
		leftTip2.render(matrixStack, buffer, packedLight, packedOverlay);
		rightTip1.render(matrixStack, buffer, packedLight, packedOverlay);
		rightTip2.render(matrixStack, buffer, packedLight, packedOverlay);
		leftCanister.render(matrixStack, buffer, packedLight, packedOverlay);
		rightCanister.render(matrixStack, buffer, packedLight, packedOverlay);
		leftExhaust1.render(matrixStack, buffer, packedLight, packedOverlay);
		leftExhaust2.render(matrixStack, buffer, packedLight, packedOverlay);
		rightExhaust1.render(matrixStack, buffer, packedLight, packedOverlay);
		rightExhaust2.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}