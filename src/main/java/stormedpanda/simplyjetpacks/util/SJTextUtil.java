package stormedpanda.simplyjetpacks.util;

import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.item.JetpackItem;

import java.util.ArrayList;
import java.util.List;

public class SJTextUtil {

    private static final Text on = translate("misc", "enabled", Formatting.GREEN);
    private static final Text off = translate("misc", "disabled", Formatting.RED);
    private static final Text notAvailable = translate("misc", "notAvailable", Formatting.DARK_GRAY);

    private static final String ENERGY_FORMAT = "%,d";

    public static Text translate(String prefix, String suffix, Formatting style, Object... params) {
        String key = String.format("%s.%s.%s", prefix, SimplyJetpacks.MODID, suffix);
        return new TranslatableText(key, params).setStyle(Style.EMPTY.withColor(style));
    }

    public static Text translate(String prefix, String suffix, Object... params) {
        String key = String.format("%s.%s.%s", prefix, SimplyJetpacks.MODID, suffix);
        return new TranslatableText(key, params);
    }

    public static Text energy(int amount) {
        String s1 = String.format(ENERGY_FORMAT, amount);
        return translate("misc", "energy", s1);
    }

    public static Text energyPerTick(int amount) {
        String s1 = String.format(ENERGY_FORMAT, amount);
        return translate("misc", "energyPerTick", Formatting.WHITE, s1);
    }

    public static Text energyWithMax(int amount, int max) {
        String s1 = String.format(ENERGY_FORMAT, amount);
        String s2 = String.format(ENERGY_FORMAT, max);
        return translate("misc", "energyWithMax", s1, s2);
    }

/*    public static Text fluidWithMax(IFluidHandler fluidHandler, int tank) {
        FluidStack stack = fluidHandler.getFluidInTank(tank);
        return fluidWithMax(stack, fluidHandler.getTankCapacity(tank));
    }

    public static Text fluidWithMax(FluidStack stack, int tankCapacity) {
        Text fluidName = stack.getDisplayName();
        String s1 = String.format(ENERGY_FORMAT, stack.getAmount());
        String s2 = String.format(ENERGY_FORMAT, tankCapacity);
        return translate("misc", "fluidWithMax", fluidName, s1, s2);
    }*/

    public static Text getShiftText() {
        return translate("tooltip", "showDetails", new LiteralText("Shift").setStyle(Style.EMPTY.withColor(Formatting.GOLD)));
    }

    public static void addBaseInfo(ItemStack stack, List<Text> list) {
        JetpackItem jetpack = (JetpackItem) stack.getItem();
        list.add(translate("tooltip", "tier", jetpack.tier));
        if (jetpack.isCreative()) {
            list.add(translate("tooltip", "infiniteEnergy", Formatting.LIGHT_PURPLE));
        } else {
            //list.add(energyWithMax(jetpack.getEnergy(stack), jetpack.getCapacity(stack)));
        }
    }

    public static void addShiftInfo(ItemStack stack, List<Text> list) {
        JetpackItem jetpack = (JetpackItem) stack.getItem();
        list.add(translate("tooltip", "itemJetpack.engine", Formatting.GOLD, jetpack.isEngineOn(stack) ? on : off));
        list.add(translate("tooltip", "itemJetpack.hover", Formatting.GOLD, jetpack.isHoverOn(stack) ? on : off));
/*        if (jetpack.getType().canEHover()) {
            list.add(translate("tooltip", "itemJetpack.emergencyHover", Formatting.GOLD, jetpack.isEHoverOn(stack) ? on : off));
        }*/
        if (jetpack.getJetpackType().getChargerMode()) {
            list.add(translate("tooltip", "itemJetpack.charger", Formatting.GOLD, jetpack.isChargerOn(stack) ? on : off));
        }
        if (!jetpack.isCreative()) {
            Text usage = translate("tooltip", "particle." + JetpackItem.getParticleId(stack), Formatting.WHITE);
            list.add(translate("tooltip", "itemJetpack.energyUsage", Formatting.GOLD, energyPerTick(jetpack.getEnergyExtract())));
        }
        Text particle = translate("tooltip", "particle." + JetpackItem.getParticleId(stack), Formatting.WHITE);
        list.add(translate("tooltip", "itemJetpack.particleType", Formatting.GOLD, particle));
    }

    public static void addHUDInfoText(ItemStack stack, List<Text> list) {
        list.add(getEnergyText(stack));
        list.add(getHUDStates(stack));
    }

    public static Text getEnergyText(ItemStack stack) {
/*        JetpackItem jetpack = (JetpackItem) stack.getItem();
        if (jetpack.isCreative()) {
            return translate("hud", "energyDisplay", translate("hud", "infiniteEnergy", Formatting.LIGHT_PURPLE));
        }
        int percent = (int) Math.ceil((double) jetpack.getEnergy(stack) / (double) jetpack.getCapacity(stack) * 100D);
        Text percentageText = getColoredPercent(percent);
        Text exactText = energy(jetpack.getEnergy(stack));
        if (SimplyJetpacksConfig.showExactEnergy.get()) {
            return translate("hud", "energyDisplayExtra", percentageText, exactText);
        } else {
            return translate("hud", "energyDisplay", percentageText);
        }*/
        return LiteralText.EMPTY;
    }

    public static Text getColoredPercent(int percent) {
        if (percent > 70) {
            return new LiteralText(String.format("%s%%", percent)).setStyle(Style.EMPTY.withColor(Formatting.GREEN));
        } else if (percent > 40) {
            return new LiteralText(String.format("%s%%", percent)).setStyle(Style.EMPTY.withColor(Formatting.YELLOW));
        } else if (percent > 10) {
            return new LiteralText(String.format("%s%%", percent)).setStyle(Style.EMPTY.withColor(Formatting.GOLD));
        } else if (percent > 0) {
            return new LiteralText(String.format("%s%%", percent)).setStyle(Style.EMPTY.withColor(Formatting.RED));
        } else {
            return translate("hud", "energyDepleted", Formatting.RED);
        }
    }

    public static Text getHUDStates(ItemStack stack) {
        JetpackItem jetpack = (JetpackItem) stack.getItem();
        ArrayList<Text> statesTexts = new ArrayList<>();
        int stateCount = 1;
        Formatting on = Formatting.GREEN;
        Formatting off = Formatting.RED;
        Formatting notAvailable = Formatting.DARK_GRAY;
        Text engineState = translate("hud", "engine", jetpack.isEngineOn(stack) ? on : off);
        Text hoverState = translate("hud", "hover", jetpack.isHoverOn(stack) ? on : off);
        Text eHoverState = translate("hud", "eHover", jetpack.getJetpackType().getEmergencyHoverMode() ? (jetpack.isEHoverOn(stack) ? on : off) : notAvailable);
        Text chargerState = translate("hud", "charger", jetpack.getJetpackType().getChargerMode() ? (jetpack.isChargerOn(stack) ? on : off) : notAvailable);
        statesTexts.add(engineState);
        /*if (SimplyJetpacksConfig.showHoverState.get() && jetpack.getJetpackType().getHoverMode()) {
            statesTexts.add(hoverState);
            stateCount++;
        }
        if (SimplyJetpacksConfig.showEHoverState.get() && jetpack.getJetpackType().getEmergencyHoverMode()) {
            statesTexts.add(eHoverState);
            stateCount++;
        }
        if (SimplyJetpacksConfig.showChargerState.get() && jetpack.getJetpackType().getChargerMode()) {
            statesTexts.add(chargerState);
            stateCount++;
        }*/
        return translate("hud", "jetpackStates." + stateCount, statesTexts.toArray());
    }

    public static Text getStateToggle(String state, boolean value) {
        return translate("chat", "itemJetpack." + state, value ? on : off);
    }

    public static Text getEmergencyText() {
        return translate("chat", "itemJetpack.emergencyHoverModeActivated", Formatting.RED);
    }
}