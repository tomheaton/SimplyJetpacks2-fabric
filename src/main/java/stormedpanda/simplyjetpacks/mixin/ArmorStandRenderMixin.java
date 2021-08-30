package stormedpanda.simplyjetpacks.mixin;

import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.ArmorStandEntityModel;
import net.minecraft.entity.decoration.ArmorStandEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ArmorStandEntityRenderer.class)
public abstract class ArmorStandRenderMixin extends LivingEntityRenderer<ArmorStandEntity, ArmorStandEntityModel> {

    public ArmorStandRenderMixin(EntityRenderDispatcher entityRenderDispatcher, ArmorStandEntityModel model, float shadowSize) {
        super(entityRenderDispatcher, model, shadowSize);
    }

    /*@Inject(at = @At("RETURN"), method = "<init>")
    public void onConstruct(EntityRenderDispatcher dispatcher, CallbackInfo info) {
        this.addFeature(new JetpackRenderLayer<>(this));
    }*/
}