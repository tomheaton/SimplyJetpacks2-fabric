package stormedpanda.simplyjetpacks.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import stormedpanda.simplyjetpacks.SimplyJetpacks;

public class SJSoundEvents {

    public static SoundEvent JETPACK;
    public static SoundEvent JETPACK_OTHER;
    public static SoundEvent ROCKET;

    private static SoundEvent register(String id) {
        Identifier identifier = new Identifier(SimplyJetpacks.MODID, id);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }

    public static void init() {
        SimplyJetpacks.LOGGER.info("Initializing Sound Events");
        JETPACK = register("jetpack");
        JETPACK_OTHER = register("jetpack_other");
        ROCKET = register("rocket");
    }
}
