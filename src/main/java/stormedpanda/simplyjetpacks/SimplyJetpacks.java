package stormedpanda.simplyjetpacks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stormedpanda.simplyjetpacks.handlers.RegistryHandler;
import stormedpanda.simplyjetpacks.item.SJItem;
import stormedpanda.simplyjetpacks.item.SJItemGroup;

public class SimplyJetpacks implements ModInitializer {

	public static SimplyJetpacks INSTANCE;

	public static final String MODID = "simplyjetpacks";
	public static final String MODNAME = "Simply Jetpacks 2";
	public static final String VERSION = "${version}";

	public static final Logger LOGGER = LogManager.getLogger();

	public static final SJItemGroup tabSimplyJetpacks = new SJItemGroup();


	@Override
	public void onInitialize() {
		LOGGER.info("SJ2: Initialization...");
		RegistryHandler.init();
	}

	public static String createItemModelJson(String id, String type) {
		if ("generated".equals(type) || "handheld".equals(type)) {
			return "{\n" +
					"\t\"parent\": \"item/" + type + "\",\n" +
					"\t\"textures\": {\n" +
					"\t\t\"layer0\": \"simplyjetpacks:item/" + id + "\"\n" +
					"\t}\n" +
					"}";
		} else if ("block".equals(type)) {
			return "{\n" +
					"\t\"parent\": \"simplyjetpacks:block/" + id + "\"\n" +
					"}";
		}
		else {
			return "";
		}
	}
}
