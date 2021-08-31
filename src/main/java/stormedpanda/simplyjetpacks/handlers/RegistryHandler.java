package stormedpanda.simplyjetpacks.handlers;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.item.JetpackItem;
import stormedpanda.simplyjetpacks.item.JetpackType;
import stormedpanda.simplyjetpacks.item.PilotGogglesItem;
import stormedpanda.simplyjetpacks.item.SJItem;

public class RegistryHandler {

    public static SJItem LEATHER_STRAP;
    public static SJItem PARTICLE_BLEND;
    public static SJItem PARTICLE_NONE;
    public static SJItem PARTICLE_FLAME;
    public static SJItem PARTICLE_SMOKE;
    public static SJItem PARTICLE_RAINBOW;
    public static SJItem PARTICLE_SOUL;
    public static SJItem PARTICLE_SNOW;

    public static PilotGogglesItem PILOT_GOGGLES_GOLD;
    public static PilotGogglesItem PILOT_GOGGLES_IRON;

    public static JetpackItem JETPACK_POTATO;
    public static JetpackItem JETPACK_CREATIVE;
    public static JetpackItem JETPACK_CREATIVE_ARMORED;
    public static JetpackItem JETPACK_VANILLA1;
    public static JetpackItem JETPACK_VANILLA1_ARMORED;
    public static JetpackItem JETPACK_VANILLA2;
    public static JetpackItem JETPACK_VANILLA2_ARMORED;
    public static JetpackItem JETPACK_VANILLA3;
    public static JetpackItem JETPACK_VANILLA3_ARMORED;
    public static JetpackItem JETPACK_VANILLA4;
    public static JetpackItem JETPACK_VANILLA4_ARMORED;

    public static SJItem THRUSTER_VANILLA1;
    public static SJItem THRUSTER_VANILLA2;
    public static SJItem THRUSTER_VANILLA3;
    public static SJItem THRUSTER_VANILLA4;

    public static void init() {
        SimplyJetpacks.LOGGER.info("Initializing Registry Items");

        LEATHER_STRAP = registerItem("leather_strap", new SJItem());
        PARTICLE_BLEND = registerItem("particle_blend", new SJItem());
        PARTICLE_NONE = registerItem("particle_none", new SJItem());
        PARTICLE_FLAME = registerItem("particle_flame", new SJItem());
        PARTICLE_SMOKE = registerItem("particle_smoke", new SJItem());
        PARTICLE_RAINBOW = registerItem("particle_rainbow", new SJItem());
        PARTICLE_SOUL = registerItem("particle_soul", new SJItem());
        PARTICLE_SNOW = registerItem("particle_snow", new SJItem());

        PILOT_GOGGLES_GOLD = registerItem("pilot_goggles_gold", new PilotGogglesItem("gold"));
        PILOT_GOGGLES_IRON = registerItem("pilot_goggles_iron", new PilotGogglesItem("iron"));

        JETPACK_POTATO = registerItem("jetpack_potato", new JetpackItem(JetpackType.POTATO));
        JETPACK_CREATIVE = registerItem("jetpack_creative", new JetpackItem(JetpackType.CREATIVE));
        JETPACK_CREATIVE_ARMORED = registerItem("jetpack_creative_armored", new JetpackItem(JetpackType.CREATIVE_ARMORED));
        JETPACK_VANILLA1 = registerItem("jetpack_vanilla1", new JetpackItem(JetpackType.VANILLA1));
        JETPACK_VANILLA1_ARMORED = registerItem("jetpack_vanilla1_armored", new JetpackItem(JetpackType.VANILLA1_ARMORED));
        JETPACK_VANILLA2 = registerItem("jetpack_vanilla2", new JetpackItem(JetpackType.VANILLA2));
        JETPACK_VANILLA2_ARMORED = registerItem("jetpack_vanilla2_armored", new JetpackItem(JetpackType.VANILLA2_ARMORED));
        JETPACK_VANILLA3 = registerItem("jetpack_vanilla3", new JetpackItem(JetpackType.VANILLA3));
        JETPACK_VANILLA3_ARMORED = registerItem("jetpack_vanilla3_armored", new JetpackItem(JetpackType.VANILLA3_ARMORED));
        JETPACK_VANILLA4 = registerItem("jetpack_vanilla4", new JetpackItem(JetpackType.VANILLA4));
        JETPACK_VANILLA4_ARMORED = registerItem("jetpack_vanilla4_armored", new JetpackItem(JetpackType.VANILLA4_ARMORED));

        THRUSTER_VANILLA1 = registerItem("thruster_vanilla1", new SJItem());
        THRUSTER_VANILLA2 = registerItem("thruster_vanilla2", new SJItem());
        THRUSTER_VANILLA3 = registerItem("thruster_vanilla3", new SJItem());
        THRUSTER_VANILLA4 = registerItem("thruster_vanilla4", new SJItem());
    }

    public static <T extends Item> T registerItem(String name, T item) {
        Registry.register(Registry.ITEM, new Identifier(SimplyJetpacks.MODID, name), item);
        return item;
    }
}














