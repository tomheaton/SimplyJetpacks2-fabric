package stormedpanda.simplyjetpacks.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.hud.IHUDInfoProvider;
import stormedpanda.simplyjetpacks.util.Constants;
import stormedpanda.simplyjetpacks.util.KeyboardUtil;
import stormedpanda.simplyjetpacks.util.NBTUtil;
import stormedpanda.simplyjetpacks.util.SJTextUtil;

import java.util.List;

public class JetpackItem extends ArmorItem implements IHUDInfoProvider {//, IEnergyContainer {

    private final JetpackType jetpackType;
    public final int tier;

    public JetpackItem(JetpackType jetpackType) {
        super(JetpackArmorMaterial.JETPACK, EquipmentSlot.CHEST, new Settings().group(SimplyJetpacks.tabSimplyJetpacks));
        this.jetpackType = jetpackType;
        this.tier = jetpackType.getTier();
    }

    public JetpackItem(JetpackType jetpackType, JetpackArmorMaterial material) {
        super(material, EquipmentSlot.CHEST, new Settings().group(SimplyJetpacks.tabSimplyJetpacks));
        this.jetpackType = jetpackType;
        this.tier = jetpackType.getTier();
    }

    /*@Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!player.isSpectator() && stack == JetpackUtil.getFromBothSlots(player)) {
            flyUser(player, stack, this, false);
            if (this.jetpackType.getChargerMode() && this.isChargerOn(stack)) {
                chargeInventory(player, stack);
            }
        }
    }*/

    public JetpackType getJetpackType() {
        return jetpackType;
    }

    public boolean isCreative() {
        return jetpackType.getName().contains("creative");
    }

    @Override
    public int getEnchantability() {
        return super.getEnchantability() + jetpackType.getEnchantability();
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return super.hasGlint(stack)|| isCreative();
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return jetpackType.getRarity();
    }

    public String getModId() {
        String name = jetpackType.getName();
        if (name.contains("mek")) {
            return "mek";
        } else if (name.contains("ie")) {
            return "ie";
        } else {
            return "sj";
        }
    }

    public boolean isEngineOn(ItemStack stack) {
        return NBTUtil.getBoolean(stack, Constants.TAG_ENGINE);
    }

    public void toggleEngine(ItemStack stack, PlayerEntity player) {
        boolean current = NBTUtil.getBoolean(stack, Constants.TAG_ENGINE);
        NBTUtil.flipBoolean(stack, Constants.TAG_ENGINE);
        Text msg = SJTextUtil.getStateToggle("engineMode", !current);
        player.sendMessage(msg, true);
    }

    public boolean isHoverOn(ItemStack stack) {
        return NBTUtil.getBoolean(stack, Constants.TAG_HOVER);
    }

    public void toggleHover(ItemStack stack, PlayerEntity player) {
        if (jetpackType.getHoverMode()) {
            boolean current = NBTUtil.getBoolean(stack, Constants.TAG_HOVER);
            NBTUtil.flipBoolean(stack, Constants.TAG_HOVER);
            Text msg = SJTextUtil.getStateToggle("hoverMode", !current);
            player.sendMessage(msg, true);
        }
    }

    public boolean isEHoverOn(ItemStack stack) {
        return NBTUtil.getBoolean(stack, Constants.TAG_E_HOVER);
    }

    public void toggleEHover(ItemStack stack, PlayerEntity player) {
        if (jetpackType.getEmergencyHoverMode()) {
            boolean current = NBTUtil.getBoolean(stack, Constants.TAG_E_HOVER);
            NBTUtil.flipBoolean(stack, Constants.TAG_E_HOVER);
            Text msg = SJTextUtil.getStateToggle("emergencyHoverMode", !current);
            player.sendMessage(msg, true);
        }
    }

    private void doEHover(ItemStack stack, PlayerEntity player) {
        if (jetpackType.getHoverMode()) {
            NBTUtil.setBoolean(stack, Constants.TAG_ENGINE, true);
            NBTUtil.setBoolean(stack, Constants.TAG_HOVER, true);
            Text msg = SJTextUtil.getEmergencyText();
            player.sendMessage(msg, true);
        }
    }

    public boolean isChargerOn(ItemStack stack) {
        return NBTUtil.getBoolean(stack, Constants.TAG_CHARGER);
    }

    public void toggleCharger(ItemStack stack, PlayerEntity player) {
        if (jetpackType.getChargerMode()) {
            boolean current = NBTUtil.getBoolean(stack, Constants.TAG_CHARGER);
            NBTUtil.flipBoolean(stack, Constants.TAG_CHARGER);
            Text msg = SJTextUtil.getStateToggle("chargerMode", !current);
            player.sendMessage(msg, true);
        }
    }

/*    public static float getChargeRatio(ItemStack stack) {
        LazyOptional<IEnergyStorage> optional = stack.getCapability(CapabilityEnergy.ENERGY);
        if (optional.isPresent()) {
            IEnergyStorage energyStorage = optional.orElseThrow(IllegalStateException::new);
            return (float) energyStorage.getEnergyStored() / energyStorage.getMaxEnergyStored();
        }
        return 0;
    }*/

/*    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
        IEnergyContainer container = this;
        return new ICapabilityProvider() {
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                if (cap == CapabilityEnergy.ENERGY)
                    return LazyOptional.of(() -> new EnergyStorageImpl(stack, container)).cast();
                return LazyOptional.empty();
            }
        };
    }*/

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //if (CapabilityEnergy.ENERGY == null) return;
        SJTextUtil.addBaseInfo(stack, tooltip);
        if (KeyboardUtil.isHoldingShift()) {
            SJTextUtil.addShiftInfo(stack, tooltip);
        } else {
            tooltip.add(SJTextUtil.getShiftText());
        }
    }

/*    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return !isCreative() && getEnergy(stack) > 0;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1 - getChargeRatio(stack);
    }*/


    /*@Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        //return MathHelper.hsvToRgb((1 + getChargeRatio(stack)) / 3.0F, 1.0F, 1.0F);
        return 0x03fc49;
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.allowdedIn(group)) {
            items.add(new ItemStack(this));
            if (!isCreative()) {
                ItemStack full = new ItemStack(this);
                //full.getOrCreateTag().putInt(Constants.TAG_ENERGY, jetpackType.getEnergyCapacity());
                NBTUtil.setInt(full, Constants.TAG_ENERGY, jetpackType.getEnergyCapacity());
                items.add(full);
            }
        }
    }*/

    private void setEnergyStored(ItemStack container, int value) {
        //NBTUtil.setInt(container, Constants.TAG_ENERGY, MathHelper.clamp(value, 0, getCapacity(container)));
    }

    public int getEnergyReceive() {
        return jetpackType.getEnergyPerTickIn();
    }

    public int getEnergyExtract() {
        return jetpackType.getEnergyUsage();
    }

    public static ItemStack setParticleId(ItemStack stack, ItemStack particle) {
/*        String key = particle.getDescriptionId().split("item.simplyjetpacks.particle_")[1].toUpperCase();
        int id = JetpackParticleType.valueOf(key).ordinal();
        NBTUtil.setInt(stack, Constants.TAG_PARTICLE, id);*/
        return stack;
    }

    public static void setParticleId(ItemStack stack, int id) {
        NBTUtil.setInt(stack, Constants.TAG_PARTICLE, id);
    }

    public static int getParticleId(ItemStack stack) {
        return stack.getOrCreateTag().contains(Constants.TAG_PARTICLE) ? stack.getOrCreateTag().getInt(Constants.TAG_PARTICLE) : JetpackType.getDefaultParticles(stack);
    }

    /*@Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return jetpackType.getArmorTexture();
    }

    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new JetpackModel();
    }*/

    public void useEnergy(ItemStack container, int amount) {
        if (container.getTag() != null || container.getTag().contains(Constants.TAG_ENERGY)) {
            int stored = 10;//Math.min(container.getTag().getInt(Constants.TAG_ENERGY), getCapacity(container));
            stored -= amount;
            if (stored < 0) stored = 0;
            container.getTag().putInt(Constants.TAG_ENERGY, stored);
        }
    }

    public int getEnergyUsage(ItemStack stack) {
        int baseUsage = jetpackType.getEnergyUsage();
        int level = 1;//EnchantmentHelper.getLevel(RegistryHandler.FUEL_EFFICIENCY.get(), stack);
        return level != 0 ? (int) Math.round(baseUsage * (5 - level) / 5.0D) : baseUsage;
    }

    /*public void chargeInventory(PlayerEntity player, ItemStack stack) {
        if (!player.getCommandSenderWorld().isClientSide) {
            if (getEnergy(stack) > 0 || isCreative()) {
                for (int i = 0; i < player.inventory.getContainerSize(); i++) {
                    ItemStack itemStack = player.inventory.getItem(i);
                    if (!itemStack.equals(stack) && itemStack.getCapability(CapabilityEnergy.ENERGY).isPresent()) {
                        LazyOptional<IEnergyStorage> optional = itemStack.getCapability(CapabilityEnergy.ENERGY);
                        if (optional.isPresent()) {
                            IEnergyStorage energyStorage = optional.orElseThrow(IllegalStateException::new);
                            if (isCreative()) {
                                energyStorage.receiveEnergy(1000, false);
                            } else {
                                useEnergy(stack, energyStorage.receiveEnergy(getEnergyUsage(stack),false));
                            }
                        }
                    }
                }
            }
        }
    }*/

    /*private void fly(PlayerEntity player, double y) {
        Vector3d motion = player.getMov();
        player.move(MovementType.PLAYER, new Vec3d(motion.x, y, motion.z));
    }

    public void flyUser(PlayerEntity player, ItemStack stack, JetpackItem item, Boolean force) {
        if (isEngineOn(stack)) {
            boolean hoverMode = isHoverOn(stack);
            double hoverSpeed = SimplyJetpacksConfig.invertHoverSneakingBehavior.get() == CommonJetpackHandler.isHoldingDown(player) ? jetpackType.getSpeedVerticalHoverSlow() : jetpackType.getSpeedVerticalHover();
            boolean flyKeyDown = force || CommonJetpackHandler.isHoldingUp(player);
            boolean descendKeyDown = CommonJetpackHandler.isHoldingDown(player);
            double currentAccel = jetpackType.getAccelVertical() * (player.getDeltaMovement().get(Direction.Axis.Y) < 0.3D ? 2.5D : 1.0D);
            double currentSpeedVertical = jetpackType.getSpeedVertical() * (player.isInWater() ? 0.4D : 1.0D);
            double speedVerticalHover = jetpackType.getSpeedVerticalHover();
            double speedVerticalHoverSlow = jetpackType.getSpeedVerticalHoverSlow();

            if ((flyKeyDown || hoverMode && !player.isOnGround())) {
                if (!isCreative()) {
                    int amount = (int) (player.isSprinting() ? Math.round(getEnergyUsage(stack) * jetpackType.getSprintEnergyModifier()) : getEnergyUsage(stack));
                    useEnergy(stack, amount);
                }
                if (getEnergy(stack) > 0 || isCreative()) {
                    if (flyKeyDown) {
                        if (!hoverMode) {
                            fly(player, Math.min(player.getDeltaMovement().get(Direction.Axis.Y) + currentAccel, currentSpeedVertical));
                        } else {
                            if (descendKeyDown) {
                                fly(player, Math.min(player.getDeltaMovement().get(Direction.Axis.Y) + currentAccel, -speedVerticalHoverSlow));
                            } else {
                                fly(player, Math.min(player.getDeltaMovement().get(Direction.Axis.Y) + currentAccel, speedVerticalHover));
                            }
                        }
                    } else {
                        fly(player, Math.min(player.getDeltaMovement().get(Direction.Axis.Y) + currentAccel, -hoverSpeed));
                    }

                    double baseSpeedSideways = jetpackType.getSpeedSideways();
                    double baseSpeedForward = jetpackType.getSprintSpeedModifier();
                    float speedSideways = (float) (player.isCrouching() ? baseSpeedSideways * 0.5F : baseSpeedSideways);
                    float speedForward = (float) (player.isSprinting() ? speedSideways * baseSpeedForward : speedSideways);

                    if (CommonJetpackHandler.isHoldingForwards(player)) {
                        player.moveRelative(1, new Vector3d(0, 0, speedForward));
                    }
                    if (CommonJetpackHandler.isHoldingBackwards(player)) {
                        player.moveRelative(1, new Vector3d(0, 0, -speedSideways * 0.8F));
                    }
                    if (CommonJetpackHandler.isHoldingLeft(player)) {
                        player.moveRelative(1, new Vector3d(speedSideways, 0, 0));
                    }
                    if (CommonJetpackHandler.isHoldingRight(player)) {
                        player.moveRelative(1, new Vector3d(-speedSideways, 0, 0));
                    }
                    if (!player.getCommandSenderWorld().isClientSide()) {
                        player.fallDistance = 0.0F;
                        if (player instanceof ServerPlayerEntity) {
                            ((ServerPlayerEntity) player).connection.aboveGroundTickCount = 0;
                        }
                    }
                }
            }
        }
        if (!player.level.isClientSide && this.isEHoverOn(stack)) {
            if ((item.getEnergy(stack) > 0 || this.isCreative()) && (!this.isHoverOn(stack) || !this.isEngineOn(stack))) {
                if (player.position().get(Direction.Axis.Y) < -5) {
                    this.doEHover(stack, player);
                } else {
                    if (!player.isCreative() && player.fallDistance - 1.2F >= player.getHealth()) {
                        for (int j = 0; j <= 16; j++) {
                            int x = Math.round((float) player.position().get(Direction.Axis.X) - 0.5F);
                            int y = Math.round((float) player.position().get(Direction.Axis.Y)) - j;
                            int z = Math.round((float) player.position().get(Direction.Axis.Z) - 0.5F);
                            if (!player.isOnGround() && !player.isSwimming()) {
                                this.doEHover(stack, player);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }*/

    /* IHUDInfoProvider start */

    @Override
    public void addHUDInfo(ItemStack stack, List<Text> list) {
        SJTextUtil.addHUDInfoText(stack, list);
    }

    /* IHUDInfoProvider end */

    /* IEnergyContainer start */

    /*@Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        if (getEnergyReceive() == 0) return 0;
        int energyStored = getEnergy(container);
        int energyReceived = Math.min(getCapacity(container) - energyStored, Math.min(getEnergyReceive(), maxReceive));
        if (!simulate) setEnergyStored(container, energyStored + energyReceived);
        return energyReceived;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        if (getEnergyExtract() == 0) return 0;
        int energyStored = getEnergy(container);
        int energyExtracted = Math.min(energyStored, Math.min(getEnergyExtract(), maxExtract));
        if (!simulate) setEnergyStored(container, energyStored - energyExtracted);
        return energyExtracted;
    }

    @Override
    public int getEnergy(ItemStack container) {
        return container.getOrCreateTag().getInt(Constants.TAG_ENERGY);
    }

    @Override
    public int getCapacity(ItemStack container) {
        return jetpackType.getEnergyCapacity();
    }*/

    /* IEnergyContainer end */
}
