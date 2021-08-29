package stormedpanda.simplyjetpacks.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.util.SJTextUtil;

import java.util.List;

public class PilotGogglesItem extends ArmorItem {

    private final String type;

    public PilotGogglesItem(String type) {
        super(JetpackArmorMaterial.PILOT_GOGGLES, EquipmentSlot.HEAD, new Settings().group(SimplyJetpacks.tabSimplyJetpacks));
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(SJTextUtil.translate("tooltip", "pilot_goggles"));
    }

    /*    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return new ResourceLocation(SimplyJetpacks.MODID, "textures/models/armor/pilot_goggles_" + this.type).toString();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(SJTextUtil.translate("tooltip", "pilot_goggles"));
    }*/
}
