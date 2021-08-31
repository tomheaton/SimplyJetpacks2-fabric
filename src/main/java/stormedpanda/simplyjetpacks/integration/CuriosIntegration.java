package stormedpanda.simplyjetpacks.integration;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.item.JetpackItem;
import stormedpanda.simplyjetpacks.item.PilotGogglesItem;
import stormedpanda.simplyjetpacks.model.JetpackModel;
import top.theillusivec4.curios.api.type.component.ICurio;
import top.theillusivec4.curios.api.type.component.IRenderableCurio;

public class CuriosIntegration {

    public static ICurio createPilotGogglesCurio(ItemStack itemStack) {
        return new ICurio() {

            @Override
            public void playRightClickEquipSound(LivingEntity livingEntity) {
                livingEntity.world.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), ((ArmorItem)itemStack.getItem()).getMaterial().getEquipSound(), SoundCategory.PLAYERS, 1.0F, 1.0F);
            }

            @Override
            public boolean canRightClickEquip() {
                return true;
            }

        };
    }

    public static IRenderableCurio createPilotGogglesCurioRender(ItemStack itemStack) {
        return new IRenderableCurio() {

            @Override
            public void render(String identifier, int index, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                BipedEntityModel<LivingEntity> gogglesModel = new BipedEntityModel<>(1.0F);
                IRenderableCurio.RenderHelper.followHeadRotations(livingEntity, gogglesModel.head);
                VertexConsumer vertexBuilder = ItemRenderer.getArmorGlintConsumer(vertexConsumerProvider, gogglesModel.getLayer(new Identifier(SimplyJetpacks.MODID, "textures/models/armor/pilot_goggles_" + ((PilotGogglesItem) itemStack.getItem()).getType() + ".png")), false, itemStack.getItem().hasGlint(itemStack));
                gogglesModel.head.render(matrixStack, vertexBuilder, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        };
    }

    public static ICurio createJetpackCurio(ItemStack itemStack) {
        return new ICurio() {

            @Override
            public void playRightClickEquipSound(LivingEntity livingEntity) {
                livingEntity.world.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), ((ArmorItem)itemStack.getItem()).getMaterial().getEquipSound(), SoundCategory.PLAYERS, 1.0F, 1.0F);
            }

            @Override
            public boolean canRightClickEquip() {
                return true;
            }

            @Override
            public void curioTick(String identifier, int index, LivingEntity livingEntity) {
                if (livingEntity instanceof PlayerEntity) {
                    itemStack.inventoryTick(livingEntity.world, livingEntity, EquipmentSlot.CHEST.getEntitySlotId(), true);
                }
            }

            @Override
            public boolean shouldSyncWith(ServerPlayerEntity player) {
                return true;
            }

        };
    }

    public static IRenderableCurio createJetpackCurioRender(ItemStack itemStack) {
        return new IRenderableCurio() {

            @Override
            public void render(String identifier, int index, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                BipedEntityModel<LivingEntity> jetpackModel = new JetpackModel();
                IRenderableCurio.RenderHelper.followBodyRotations(livingEntity, jetpackModel);
                VertexConsumer vertexBuilder = ItemRenderer.getArmorGlintConsumer(vertexConsumerProvider, jetpackModel.getLayer(new Identifier(SimplyJetpacks.MODID, "textures/models/armor/jetpack_" + ((JetpackItem) itemStack.getItem()).getJetpackType().getName() + ".png")), false, itemStack.getItem().hasGlint(itemStack));
                jetpackModel.render(matrixStack, vertexBuilder, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        };
    }
}


