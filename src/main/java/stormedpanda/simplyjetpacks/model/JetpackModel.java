package stormedpanda.simplyjetpacks.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

public class JetpackModel extends BipedEntityModel<LivingEntity> {

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
        super(1F, 0F, 64, 64);
        textureWidth = 64;
        textureHeight = 64;

        middle = new ModelPart(this);
        middle.setPivot(0.0F, 0.0F, 0.0F);
        middle.setTextureOffset(0, 54);
        middle.mirror = true;

        leftTip1 = new ModelPart(this);
        leftTip1.setPivot(0.0F, 0.0F, 0.0F);
        leftTip1.mirror = true;
        leftTip1.setTextureOffset(0, 45);

        leftTip2 = new ModelPart(this);
        leftTip2.setPivot(0.0F, 0.0F, 0.0F);
        leftTip2.mirror = true;
        leftTip2.setTextureOffset(0, 49);

        rightTip1 = new ModelPart(this);
        rightTip1.setPivot(0.0F, 0.0F, 0.0F);
        rightTip1.mirror = true;
        rightTip1.setTextureOffset(17, 45);
        rightTip2 = new ModelPart(this);
        rightTip2.setPivot(0.0F, 0.0F, 0.0F);
        rightTip2.mirror = true;
        rightTip2.setTextureOffset(17, 49);

        leftCanister = new ModelPart(this);
        leftCanister.setPivot(0.0F, 0.0F, 0.0F);
        leftCanister.mirror = true;
        leftCanister.setTextureOffset(0, 32);

        rightCanister = new ModelPart(this);
        rightCanister.setPivot(0.0F, 0.0F, 0.0F);
        rightCanister.mirror = true;
        rightCanister.setTextureOffset(17, 32);

        leftExhaust1 = new ModelPart(this);
        leftExhaust1.setPivot(0.0F, 0.0F, 0.0F);
        leftExhaust1.mirror = true;
        leftExhaust1.setTextureOffset(35, 32);

        leftExhaust2 = new ModelPart(this);
        leftExhaust2.setPivot(0.0F, 0.0F, 0.0F);
        leftExhaust2.mirror = true;
        leftExhaust2.setTextureOffset(35, 37);

        rightExhaust1 = new ModelPart(this);
        rightExhaust1.setPivot(0.0F, 0.0F, 0.0F);
        rightExhaust1.mirror = true;
        rightExhaust1.setTextureOffset(48, 32);

        rightExhaust2 = new ModelPart(this);
        rightExhaust2.setPivot(0.0F, 0.0F, 0.0F);
        rightExhaust2.mirror = true;
        rightExhaust2.setTextureOffset(35, 45);

        setupCustomModel();
    }

    private void setupCustomModel() {
        torso.addChild(middle);
        middle.addCuboid(-2F, 3F, 3.6F, 4, 5, 2);
        torso.addChild(leftCanister);
        leftCanister.addCuboid(0.5F, 2F, 2.6F, 4, 7, 4);
        torso.addChild(rightCanister);
        rightCanister.addCuboid(-4.5F, 2F, 2.6F, 4, 7, 4);
        torso.addChild(leftTip1);
        leftTip1.addCuboid(1F, 1F, 3.1F, 3, 1, 3);
        torso.addChild(leftTip2);
        leftTip2.addCuboid(1.5F, -1F, 3.6F, 2, 2, 2);
        torso.addChild(rightTip1);
        rightTip1.addCuboid(-4F, 1F, 3.1F, 3, 1, 3);
        torso.addChild(rightTip2);
        rightTip2.addCuboid(-3.5F, -1F, 3.6F, 2, 2, 2);
        torso.addChild(leftExhaust1);
        leftExhaust1.addCuboid(1F, 9F, 3.1F, 3, 1, 3);
        torso.addChild(leftExhaust2);
        leftExhaust2.addCuboid(0.5F, 10F, 2.6F, 4, 3, 4);
        torso.addChild(rightExhaust1);
        rightExhaust1.addCuboid(-4F, 9F, 3.1F, 3, 1, 3);
        torso.addChild(rightExhaust2);
        rightExhaust2.addCuboid(-4.5F, 10F, 2.6F, 4, 3, 4);
    }

    @Override
    public void setAngles(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        //super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelPart part, float x, float y, float z) {
        part.pitch = x;
        part.yaw = y;
        part.roll = z;
    }
}
