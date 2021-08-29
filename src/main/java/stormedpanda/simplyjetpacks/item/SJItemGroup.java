package stormedpanda.simplyjetpacks.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import stormedpanda.simplyjetpacks.SimplyJetpacks;

public class SJItemGroup extends ItemGroup {

    public SJItemGroup() {
        super(1, SimplyJetpacks.MODID + ".main");
    }

    @Override
    public ItemStack createIcon() {
        //return new ItemStack(RegistryHandler.JETPACK_CREATIVE.get());
        return new ItemStack(Items.DIAMOND);
    }
}
