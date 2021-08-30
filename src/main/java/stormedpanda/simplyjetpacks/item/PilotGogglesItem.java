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
}
