package stormedpanda.simplyjetpacks.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import stormedpanda.simplyjetpacks.sound.SJSoundEvents;
import stormedpanda.simplyjetpacks.util.*;

import java.util.List;

public class PotatoJetpackItem extends JetpackItem {

    public PotatoJetpackItem() {
        super(JetpackType.POTATO, JetpackArmorMaterial.POTATO);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //if (CapabilityEnergy.ENERGY == null) return;
        tooltip.add(SJTextUtil.translate("tooltip", "jetpack_potato"));
        SJTextUtil.addBaseInfo(stack, tooltip);
        if (KeyboardUtil.isHoldingShift()) {
            tooltip.add(SJTextUtil.translate("tooltip", "jetpack_potato.warning", Formatting.RED));
        } else {
            tooltip.add(SJTextUtil.getShiftText());
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.isSpectator() && stack == JetpackUtil.getFromBothSlots(player)) {
                //this.flyUser(player, stack, this, true);
                if (getJetpackType().getChargerMode() && this.isChargerOn(stack)) {
                    //super.chargeInventory(player, stack);
                }
            }
        }
    }

    public boolean isFired(ItemStack itemStack) {
        return NBTUtil.getBoolean(itemStack, Constants.TAG_FIRED);
    }

    private void setFired(ItemStack itemStack) {
        NBTUtil.setBoolean(itemStack, Constants.TAG_FIRED, true);
    }

    private boolean isTimerSet(ItemStack itemStack) {
        return NBTUtil.getBoolean(itemStack, Constants.TAG_ROCKET_TIMER_SET);
    }

    private void setTimer(ItemStack itemStack, int timer) {
        NBTUtil.setInt(itemStack, Constants.TAG_ROCKET_TIMER, timer);
        NBTUtil.setBoolean(itemStack, Constants.TAG_ROCKET_TIMER_SET, true);
    }

    private void decrementTimer(ItemStack itemStack, PlayerEntity player) {
        int timer = NBTUtil.getInt(itemStack, Constants.TAG_ROCKET_TIMER);
        timer = timer > 0 ? timer - 1 : 0;
        NBTUtil.setInt(itemStack, Constants.TAG_ROCKET_TIMER, timer);
        if (timer == 0) {
            this.setFired(itemStack);
            player.world.playSound(player, player.getBlockPos(), SJSoundEvents.ROCKET, SoundCategory.PLAYERS, 1F, 1F);
        }
    }

/*    @Override
    public void flyUser(PlayerEntity player, ItemStack stack, JetpackItem item, Boolean force) {
        if (super.isEngineOn(stack)) {
            if (this.isFired(stack)) {
                super.flyUser(player, stack, item, true);
                player.yHeadRot += 37.5F;
                if (item.getEnergy(stack) <= 0) {
                    Random random = new Random();
                    player.inventory.removeItem(stack);
                    if (!player.level.isClientSide()) {
                        player.level.explode(player, player.getX(), player.getY(), player.getZ(), 4.0F, Explosion.Mode.NONE);
                    }
                    for (int i = 0; i <= random.nextInt(3) + 4; i++) {
                        SimplyJetpacks.LOGGER.info("SJ2: CREATING FIREWORKS!");
                        // TODO: create some fireworks.
                        //ItemStack firework = FireworksHelper.getRandomFireworks(0, 1, new Random().nextInt(6) + 1, 1);
                        //player.level.createFireworks(new ProjectileImpactEvent.FireworkRocket(player.level, player.getX() + new Random().nextDouble() * 6.0D - 3.0D, player.getY(), player.getZ() + new Random().nextDouble() * 6.0D - 3.0D, firework));
                    }
                    player.hurt(new EntityDamageSource(random.nextBoolean() ? "potato_jetpack" : "jetpack_explode", player), 100F);
                    player.drop(new ItemStack(Items.BAKED_POTATO), false);
                }
            } else {
                if (force || CommonJetpackHandler.isHoldingUp(player)) {
                    if (this.isTimerSet(stack)) {
                        this.decrementTimer(stack, player);
                    } else {
                        this.setTimer(stack, 50);
                    }
                }
            }
        }
    }
    }*/
}
