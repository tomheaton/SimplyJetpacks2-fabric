package stormedpanda.simplyjetpacks.crafting;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import stormedpanda.simplyjetpacks.datagen.SJTags;
import stormedpanda.simplyjetpacks.handlers.RegistryHandler;
import stormedpanda.simplyjetpacks.item.JetpackItem;

public class JetpackSpecialRecipe extends SpecialCraftingRecipe {

    public JetpackSpecialRecipe(Identifier id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        ItemStack jetpack = ItemStack.EMPTY;
        ItemStack particle = ItemStack.EMPTY;
        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack currentStack = inventory.getStack(i);
            if (!currentStack.isEmpty()) {
                Item item = currentStack.getItem();
                if (item instanceof JetpackItem) {
                    if (!jetpack.isEmpty()) {
                        return false;
                    }
                    jetpack = currentStack.copy();
                }
                if (item.isIn(SJTags.PARTICLES)) {
                    if (!particle.isEmpty()) {
                        return false;
                    }
                    particle = currentStack.copy();
                }
            }
        }
        return !jetpack.isEmpty() && !particle.isEmpty();
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        ItemStack jetpack = ItemStack.EMPTY;
        ItemStack particle = ItemStack.EMPTY;
        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack currentStack = inventory.getStack(i);
            if (!currentStack.isEmpty()) {
                Item item = currentStack.getItem();
                if (item instanceof JetpackItem) {
                    if (!jetpack.isEmpty()) {
                        return ItemStack.EMPTY;
                    }
                    jetpack = currentStack.copy();
                }
                if (item.isIn(SJTags.PARTICLES)) {
                    if (!particle.isEmpty()) {
                        return ItemStack.EMPTY;
                    }
                    particle = currentStack.copy();
                }
            }
        }
        return !jetpack.isEmpty() && !particle.isEmpty() ? JetpackItem.setParticleId(jetpack, particle) : ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 4;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RegistryHandler.JETPACK_SPECIAL_RECIPE;
    }

}
