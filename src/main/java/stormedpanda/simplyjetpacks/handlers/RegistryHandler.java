package stormedpanda.simplyjetpacks.handlers;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import stormedpanda.simplyjetpacks.item.JetpackItem;
import stormedpanda.simplyjetpacks.item.JetpackType;
import stormedpanda.simplyjetpacks.item.PilotGogglesItem;
import stormedpanda.simplyjetpacks.item.SJItem;

public class RegistryHandler {

    public static final SJItem LEATHER_STRAP = new SJItem();
    public static final SJItem PARTICLE_BLEND = new SJItem();
    public static final SJItem PARTICLE_NONE = new SJItem();
    public static final SJItem PARTICLE_FLAME = new SJItem();
    public static final SJItem PARTICLE_SMOKE = new SJItem();
    public static final SJItem PARTICLE_RAINBOW = new SJItem();
    public static final SJItem PARTICLE_SOUL = new SJItem();
    public static final SJItem PARTICLE_SNOW = new SJItem();

    public static final PilotGogglesItem PILOT_GOGGLES_GOLD = new PilotGogglesItem("gold");
    public static final PilotGogglesItem PILOT_GOGGLES_IRON = new PilotGogglesItem("iron");

    public static final JetpackItem JETPACK_POTATO = new JetpackItem(JetpackType.POTATO);
    public static final JetpackItem JETPACK_CREATIVE = new JetpackItem(JetpackType.CREATIVE);
    public static final JetpackItem JETPACK_CREATIVE_ARMORED = new JetpackItem(JetpackType.CREATIVE_ARMORED);
    public static final JetpackItem JETPACK_VANILLA1 = new JetpackItem(JetpackType.VANILLA1);
    public static final JetpackItem JETPACK_VANILLA1_ARMORED = new JetpackItem(JetpackType.VANILLA1_ARMORED);
    public static final JetpackItem JETPACK_VANILLA2 = new JetpackItem(JetpackType.VANILLA2);
    public static final JetpackItem JETPACK_VANILLA2_ARMORED = new JetpackItem(JetpackType.VANILLA2_ARMORED);
    public static final JetpackItem JETPACK_VANILLA3 = new JetpackItem(JetpackType.VANILLA3);
    public static final JetpackItem JETPACK_VANILLA3_ARMORED = new JetpackItem(JetpackType.VANILLA3_ARMORED);
    public static final JetpackItem JETPACK_VANILLA4 = new JetpackItem(JetpackType.VANILLA4);
    public static final JetpackItem JETPACK_VANILLA4_ARMORED = new JetpackItem(JetpackType.VANILLA4_ARMORED);

    public static final SJItem THRUSTER_VANILLA1 = new SJItem();
    public static final SJItem THRUSTER_VANILLA2 = new SJItem();
    public static final SJItem THRUSTER_VANILLA3 = new SJItem();
    public static final SJItem THRUSTER_VANILLA4 = new SJItem();

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "leather_strap"), LEATHER_STRAP);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "particle_blend"), PARTICLE_BLEND);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "particle_none"), PARTICLE_NONE);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "particle_flame"), PARTICLE_FLAME);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "particle_smoke"), PARTICLE_SMOKE);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "particle_rainbow"), PARTICLE_RAINBOW);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "particle_soul"), PARTICLE_SOUL);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "particle_snow"), PARTICLE_SNOW);

        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "pilot_goggles_gold"), PILOT_GOGGLES_GOLD);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "pilot_goggles_iron"), PILOT_GOGGLES_IRON);

        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_potato"), JETPACK_POTATO);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_creative"), JETPACK_CREATIVE);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_creative_armored"), JETPACK_CREATIVE_ARMORED);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_vanilla1"), JETPACK_VANILLA1);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_vanilla1_armored"), JETPACK_VANILLA1_ARMORED);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_vanilla2"), JETPACK_VANILLA2);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_vanilla2_armored"), JETPACK_VANILLA2_ARMORED);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_vanilla3"), JETPACK_VANILLA3);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_vanilla3_armored"), JETPACK_VANILLA3_ARMORED);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_vanilla4"), JETPACK_VANILLA4);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "jetpack_vanilla4_armored"), JETPACK_VANILLA4_ARMORED);

        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "thruster_vanilla1"), THRUSTER_VANILLA1);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "thruster_vanilla2"), THRUSTER_VANILLA2);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "thruster_vanilla3"), THRUSTER_VANILLA3);
        Registry.register(Registry.ITEM, new Identifier("simplyjetpacks", "thruster_vanilla4"), THRUSTER_VANILLA4);
    }
}














