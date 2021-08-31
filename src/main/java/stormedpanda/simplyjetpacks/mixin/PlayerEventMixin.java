package stormedpanda.simplyjetpacks.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

//@Mixin(PlayerEvent.class)
public class PlayerEventMixin {

    // TODO: improve this
    public Item getPlating(int id) {
        switch (id) {
            case 0:
                return Items.IRON_CHESTPLATE;
            case 1:
                return Items.GOLDEN_CHESTPLATE;
            case 2:
                return Items.DIAMOND_CHESTPLATE;
            case 3:
                return Items.NETHERITE_CHESTPLATE;
            default:
                return null;
        }
    }
}
