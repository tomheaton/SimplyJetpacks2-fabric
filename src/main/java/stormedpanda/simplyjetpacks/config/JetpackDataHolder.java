package stormedpanda.simplyjetpacks.config;

import java.util.HashMap;
import java.util.Map;

public class JetpackDataHolder {

    public static Map<String, JetpackDataHolder> DEFAULTS = new HashMap<>();

    public String name;
    public String mod;

    // actual values
    public int energyCapacity;
    public int energyUsage;
    public int energyPerTickIn;
    public int energyPerTickOut;
    public int armorReduction;
    public int armorEnergyPerHit;
    public int enchantability;
    public double speedVertical;
    public double accelVertical;
    public double speedVerticalHover;
    public double speedVerticalHoverSlow;
    public double speedSideways;
    public double sprintSpeedModifier;
    public double sprintEnergyModifier;
    public boolean hoverMode;
    public boolean emergencyHoverMode;
    public boolean chargerMode;

    // config values
    public Integer _energyCapacity;
    public Integer _energyUsage;
    public Integer _energyPerTickIn;
    public Integer _energyPerTickOut;
    public Integer _armorReduction;
    public Integer _armorEnergyPerHit;
    public Integer _enchantability;
    public Double _speedVertical;
    public Double _accelVertical;
    public Double _speedVerticalHover;
    public Double _speedVerticalHoverSlow;
    public Double _speedSideways;
    public Double _sprintSpeedModifier;
    public Double _sprintEnergyModifier;
    public Boolean _hoverMode;
    public Boolean _emergencyHoverMode;
    public Boolean _chargerMode;

    public JetpackDataHolder(String name, String mod) {
        this.name = name;
        this.mod = mod;
        DEFAULTS.put(name, this);
    }

    static {
        JetpackDataHolder d = new JetpackDataHolder("potato", "simplyjetpacks");
        d.energyCapacity = 1200;
        d.energyUsage = 45;
        d.energyPerTickOut = 45;
        d.energyPerTickIn = 45;
        d.armorReduction = 0;
        d.armorEnergyPerHit = 0;
        d.enchantability = 0;
        d.speedVertical = 0.9D;
        d.accelVertical = 0.5D;
        d.speedVerticalHover = 0.18D;
        d.speedVerticalHoverSlow = 0.14D;
        d.speedSideways = 0.0D;
        d.sprintSpeedModifier = 1.0D;
        d.sprintEnergyModifier = 1.0D;
        d.hoverMode = false;
        d.emergencyHoverMode = false;
        d.chargerMode = false;

        d = new JetpackDataHolder("creative", "simplyjetpacks");
        d.energyCapacity = 0;
        d.energyUsage = 1000;
        d.energyPerTickOut = 1000;
        d.energyPerTickIn = 0;
        d.armorReduction = 12;
        d.enchantability = 20;
        d.speedVertical = 0.9D;
        d.accelVertical = 0.15D;
        d.speedVerticalHover = 0.45D;
        d.speedVerticalHoverSlow = 0.0D;
        d.speedSideways = 0.21D;
        d.sprintSpeedModifier = 2.5D;
        d.hoverMode = true;
        d.emergencyHoverMode = true;
        d.chargerMode = true;

        d = new JetpackDataHolder("vanilla1", "simplyjetpacks");
        d.energyCapacity = 80000;
        d.energyUsage = 32;
        d.energyPerTickIn = 400;
        d.armorReduction = 5;
        d.armorEnergyPerHit = 80;
        d.enchantability = 4;
        d.speedVertical = 0.22D;
        d.accelVertical = 0.1D;
        d.speedVerticalHover = 0.18D;
        d.speedVerticalHoverSlow = 0.14D;
        d.speedSideways = 0.0D;
        d.sprintSpeedModifier = 1.0D;
        d.sprintEnergyModifier = 1.0D;
        d.hoverMode = true;
        d.emergencyHoverMode = false;
        d.chargerMode = false;

        d = new JetpackDataHolder("vanilla2", "simplyjetpacks");
        d.energyCapacity = 400000;
        d.energyUsage = 50;
        d.energyPerTickIn = 2000;
        d.armorReduction = 6;
        d.armorEnergyPerHit = 100;
        d.enchantability = 8;
        d.speedVertical = 0.3D;
        d.accelVertical = 0.12D;
        d.speedVerticalHover = 0.18D;
        d.speedVerticalHoverSlow = 0.1D;
        d.speedSideways = 0.08D;
        d.sprintSpeedModifier = 1.0D;
        d.sprintEnergyModifier = 1.0D;
        d.hoverMode = true;
        d.emergencyHoverMode = false;
        d.chargerMode = false;

        d = new JetpackDataHolder("vanilla3", "simplyjetpacks");
        d.energyCapacity = 4000000;
        d.energyUsage = 200;
        d.energyPerTickIn = 20000;
        d.armorReduction = 7;
        d.armorEnergyPerHit = 120;
        d.enchantability = 13;
        d.speedVertical = 0.48D;
        d.accelVertical = 0.13D;
        d.speedVerticalHover = 0.34D;
        d.speedVerticalHoverSlow = 0.03D;
        d.speedSideways = 0.12D;
        d.sprintSpeedModifier = 1.3D;
        d.sprintEnergyModifier = 2.5D;
        d.hoverMode = true;
        d.emergencyHoverMode = true;
        d.chargerMode = false;

        d = new JetpackDataHolder("vanilla4", "simplyjetpacks");
        d.energyCapacity = 20000000;
        d.energyUsage = 450;
        d.energyPerTickIn = 50000;
        d.armorReduction = 8;
        d.armorEnergyPerHit = 160;
        d.enchantability = 17;
        d.speedVertical = 0.8D;
        d.accelVertical = 0.14D;
        d.speedVerticalHover = 0.4D;
        d.speedVerticalHoverSlow = 0.005D;
        d.speedSideways = 0.16D;
        d.sprintSpeedModifier = 1.9D;
        d.sprintEnergyModifier = 4.5D;
        d.hoverMode = true;
        d.emergencyHoverMode = true;
        d.chargerMode = true;

    }
}
