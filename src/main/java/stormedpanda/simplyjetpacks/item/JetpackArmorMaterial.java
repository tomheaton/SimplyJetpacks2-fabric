package stormedpanda.simplyjetpacks.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public enum JetpackArmorMaterial implements ArmorMaterial {

    POTATO("potato", 0, new int[]{0, 0, 0, 0}, 0, Items.IRON_INGOT, "item.armor.equip_leather", 0.0f, 0.0f),
    PILOT_GOGGLES("pilot_goggles", 0, new int[]{0, 0, 0, 0}, 0, Items.IRON_INGOT, "item.armor.equip_leather", 0.0f, 0.0f),
    JETPACK("jetpack", 0, new int[]{0, 0, 2, 0}, 10, Items.IRON_INGOT, "item.armor.equip_iron", 0.0f, 0.0f),
    JETPACK_ARMORED("jetpack_armored", 0, new int[]{0, 0, 4, 0}, 10, Items.IRON_INGOT, "item.armor.equip_iron", 0.0f, 0.0f),
    JETPLATE("jetplate", 0, new int[]{0, 0, 12, 0}, 10, Items.IRON_INGOT, "item.armor.equip_iron", 3.0f, 3.0f);

    private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durability;
    private final int[] damageReductionAmounts;
    private final Item repairItem;
    private final String equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private int enchantability;

    JetpackArmorMaterial(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness, float knockbackResistance) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmounts = damageReductionAmounts;
        this.enchantability = enchantability;
        this.repairItem = repairItem;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    public static void setStats(JetpackArmorMaterial armor, boolean isArmored, int enchant, int defense) {
        defense = isArmored ? defense : (defense - 1) / 2;
        armor.enchantability = enchant;
        armor.damageReductionAmounts[EquipmentSlot.CHEST.getEntitySlotId()] = defense;
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return max_damage_array[slot.getEntitySlotId()] * this.durability;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.damageReductionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        //return new SoundEvent(new ResourceLocation(equipSound));
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofStacks(new ItemStack(this.repairItem));
    }

    @Override
    public String getName() {
        //return SimplyJetpacks.MODID + ":" + this.name;
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
