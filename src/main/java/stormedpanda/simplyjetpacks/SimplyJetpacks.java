package stormedpanda.simplyjetpacks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stormedpanda.simplyjetpacks.handlers.RegistryHandler;
import stormedpanda.simplyjetpacks.item.SJItemGroup;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeInfo;
import top.theillusivec4.curios.api.SlotTypePreset;

public class SimplyJetpacks implements ModInitializer {

	public static SimplyJetpacks INSTANCE;

	public static final String MODID = "simplyjetpacks";
	public static final String MODNAME = "Simply Jetpacks 2";
	public static final String VERSION = "${version}";

	public static final Logger LOGGER = LogManager.getLogger();

	public static final SJItemGroup tabSimplyJetpacks = new SJItemGroup();

	public static final Identifier JETPACK_SLOT = new Identifier(MODID, "gui/empty_jetpack_slot");

	@Override
	public void onInitialize() {
		LOGGER.info("SJ2: Initialization...");
		RegistryHandler.init();
		if (FabricLoader.getInstance().isModLoaded("curios")) {
			CuriosApi.enqueueSlotType(SlotTypeInfo.BuildScheme.REGISTER, SlotTypePreset.HEAD.getInfoBuilder().build());
			CuriosApi.enqueueSlotType(SlotTypeInfo.BuildScheme.REGISTER, new SlotTypeInfo.Builder("jetpack").size(1).icon(JETPACK_SLOT).build());
		}
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
