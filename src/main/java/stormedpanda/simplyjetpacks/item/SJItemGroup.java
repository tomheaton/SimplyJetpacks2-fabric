package stormedpanda.simplyjetpacks.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.handlers.RegistryHandler;

public class SJItemGroup extends ItemGroup {

    public SJItemGroup() {
        super(999, SimplyJetpacks.MODID + ".main");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(RegistryHandler.JETPACK_CREATIVE.asItem());
    }
}
