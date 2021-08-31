package stormedpanda.simplyjetpacks.datagen;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import stormedpanda.simplyjetpacks.SimplyJetpacks;

public class SJTags {

    public static final Tag<Item> PARTICLES = mod("particles");
    public static final Tag<Item> JETPACK = mod("jetpack");

    public static final Tag<Item> CURIOS_HEAD = curios("head");
    public static final Tag<Item> CURIOS_BACK = curios("back");
    public static final Tag<Item> CURIOS_JETPACK = curios("jetpack");

    private static Tag<Item> mod(String path) {
        return TagRegistry.item(new Identifier(SimplyJetpacks.MODID, path));
    }

    private static Tag<Item> curios(String path) {
        return TagRegistry.item(new Identifier("curios", path));
    }
}
