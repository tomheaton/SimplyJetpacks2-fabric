package stormedpanda.simplyjetpacks.util;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import stormedpanda.simplyjetpacks.item.JetpackItem;
import top.theillusivec4.curios.api.CuriosApi;

public class JetpackUtil {

    public static ItemStack getFromBothSlots(PlayerEntity player) {
        ItemStack jetpackItem = ItemStack.EMPTY;
        if (FabricLoader.getInstance().isModLoaded("curios")) {
            jetpackItem = CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof JetpackItem, player).map(ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
        }
        return jetpackItem == ItemStack.EMPTY ? getFromChest(player) : jetpackItem;
    }

    public static ItemStack getFromChest(PlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.CHEST);
    }

    public static void removeFromBothSlots(PlayerEntity player) {
        if (FabricLoader.getInstance().isModLoaded("curios")) {
            ItemStack itemStack = CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof JetpackItem, player).map(ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
            CuriosApi.getCuriosHelper().getCurio(itemStack).ifPresent(p -> p.curioBreak(itemStack, player));
        } else {
            player.inventory.removeOne(getFromChest(player));
        }
    }
}
