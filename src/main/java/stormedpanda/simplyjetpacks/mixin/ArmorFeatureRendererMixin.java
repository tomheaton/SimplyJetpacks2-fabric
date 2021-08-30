package stormedpanda.simplyjetpacks.mixin;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.item.PilotGogglesItem;

@Mixin(ArmorFeatureRenderer.class)
public abstract class ArmorFeatureRendererMixin<T extends LivingEntity, M extends BipedEntityModel<T>, A extends BipedEntityModel<T>> extends FeatureRenderer<T, M> {

    @Shadow
    protected abstract void setVisible(A bipedModel, EquipmentSlot slot);
    @Shadow protected abstract boolean usesSecondLayer(EquipmentSlot slot);

    private static final Identifier PILOT_GOGGLES_GOLD_TEXTURE = new Identifier(SimplyJetpacks.MODID, "textures/models/armor/pilot_goggles_gold.png");
    private static final Identifier PILOT_GOGGLES_IRON_TEXTURE = new Identifier(SimplyJetpacks.MODID, "textures/models/armor/pilot_goggles_gold.png");

    public ArmorFeatureRendererMixin(FeatureRendererContext<T, M> featureRendererContext_1) {
        super(featureRendererContext_1);
    }

    @Inject(method = "renderArmor(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;ILnet/minecraft/client/render/entity/model/BipedEntityModel;)V", at = @At("HEAD"))
    private void renderArmor(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, T livingEntity, EquipmentSlot equipmentSlot, int i, A armorModel, CallbackInfo ci) {
        if (equipmentSlot == EquipmentSlot.HEAD) {
            ItemStack itemStack = livingEntity.getEquippedStack(equipmentSlot);
            if (itemStack.getItem() instanceof PilotGogglesItem) {
                getContextModel().setAttributes(armorModel);
                setVisible(armorModel, equipmentSlot);
                boolean renderGlint = itemStack.hasGlint();
                VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumerProvider, RenderLayer.getEntityCutoutNoCull(
                        new Identifier(SimplyJetpacks.MODID, "textures/models/armor/pilot_goggles_" + ((PilotGogglesItem) itemStack.getItem()).getType() + ".png")), false, renderGlint);
                armorModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }
}
