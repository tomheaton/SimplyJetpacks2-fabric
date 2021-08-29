package stormedpanda.simplyjetpacks.hud;

import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.List;

public interface IHUDInfoProvider {
    void addHUDInfo(ItemStack stack, List<Text> list);
}