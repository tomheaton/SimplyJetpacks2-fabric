package stormedpanda.simplyjetpacks.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class JetpackModel extends EntityModel<Entity> {

    private final ModelPart jetpack;
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

    public JetpackModel() {
        textureWidth = 64;
        textureHeight = 64;
        jetpack = new ModelPart(this);
        jetpack.setPivot(0.0F, 24.0F, 0.0F);

        middle = new ModelPart(this);
        middle.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(middle);
        middle.setTextureOffset(0, 54).addCuboid(-2.0F, -8.0F, 3.6F, 4.0F, 5.0F, 2.0F, 0.0F, false);

        leftTip1 = new ModelPart(this);
        leftTip1.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(leftTip1);
        leftTip1.setTextureOffset(0, 45).addCuboid(-4.0F, -2.0F, 3.1F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        leftTip2 = new ModelPart(this);
        leftTip2.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(leftTip2);
        leftTip2.setTextureOffset(0, 49).addCuboid(-3.5F, -1.0F, 3.6F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        rightTip1 = new ModelPart(this);
        rightTip1.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(rightTip1);
        rightTip1.setTextureOffset(17, 45).addCuboid(1.0F, -2.0F, 3.1F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        rightTip2 = new ModelPart(this);
        rightTip2.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(rightTip2);
        rightTip2.setTextureOffset(17, 49).addCuboid(1.5F, -1.0F, 3.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        leftCanister = new ModelPart(this);
        leftCanister.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(leftCanister);
        leftCanister.setTextureOffset(0, 32).addCuboid(-4.5F, -9.0F, 2.6F, 4.0F, 7.0F, 4.0F, 0.0F, false);

        rightCanister = new ModelPart(this);
        rightCanister.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(rightCanister);
        rightCanister.setTextureOffset(17, 32).addCuboid(0.5F, -9.0F, 2.6F, 4.0F, 7.0F, 4.0F, 0.0F, true);

        leftExhaust1 = new ModelPart(this);
        leftExhaust1.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(leftExhaust1);
        leftExhaust1.setTextureOffset(35, 32).addCuboid(-4.0F, -10.0F, 3.1F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        leftExhaust2 = new ModelPart(this);
        leftExhaust2.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(leftExhaust2);
        leftExhaust2.setTextureOffset(35, 37).addCuboid(-4.5F, -13.0F, 2.6F, 4.0F, 3.0F, 4.0F, 0.0F, false);

        rightExhaust1 = new ModelPart(this);
        rightExhaust1.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(rightExhaust1);
        rightExhaust1.setTextureOffset(48, 32).addCuboid(1.0F, -10.0F, 3.1F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        rightExhaust2 = new ModelPart(this);
        rightExhaust2.setPivot(0.0F, 0.0F, 0.0F);
        jetpack.addChild(rightExhaust2);
        rightExhaust2.setTextureOffset(35, 45).addCuboid(0.5F, -13.0F, 2.6F, 4.0F, 3.0F, 4.0F, 0.0F, true);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        jetpack.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}
