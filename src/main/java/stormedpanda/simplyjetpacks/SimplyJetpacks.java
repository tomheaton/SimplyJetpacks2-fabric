package stormedpanda.simplyjetpacks;

import nerdhub.cardinal.components.api.event.ItemComponentCallbackV2;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stormedpanda.simplyjetpacks.handlers.RegistryHandler;
import stormedpanda.simplyjetpacks.integration.CuriosIntegration;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosComponent;
import top.theillusivec4.curios.api.SlotTypeInfo;
import top.theillusivec4.curios.api.SlotTypePreset;

public class SimplyJetpacks implements ModInitializer {

    public static final String MODID = "simplyjetpacks";
    public static final String MODNAME = "Simply Jetpacks 2";
    public static final String VERSION = "${version}";

    public static final Logger LOGGER = LogManager.getLogger();

    //public static final SJItemGroup tabSimplyJetpacks = new SJItemGroup();
    public static final ItemGroup tabSimplyJetpacks = FabricItemGroupBuilder.build(new Identifier(MODID, "main"), () -> new ItemStack(RegistryHandler.JETPACK_CREATIVE));
    public static final Identifier JETPACK_SLOT = new Identifier(MODID, "gui/empty_jetpack_slot");

    public static SimplyJetpacks INSTANCE;

    @Override
    public void onInitialize() {
        SimplyJetpacks.LOGGER.info("Initializing Mod");

        RegistryHandler.init();
        if (FabricLoader.getInstance().isModLoaded("curios")) {
            CuriosApi.enqueueSlotType(SlotTypeInfo.BuildScheme.REGISTER, SlotTypePreset.HEAD.getInfoBuilder().build());
            CuriosApi.enqueueSlotType(SlotTypeInfo.BuildScheme.REGISTER, SlotTypePreset.BACK.getInfoBuilder().build());
            //CuriosApi.enqueueSlotType(SlotTypeInfo.BuildScheme.REGISTER, new SlotTypeInfo.Builder("jetpack").size(1).icon(JETPACK_SLOT).build());

            ItemComponentCallbackV2.event(RegistryHandler.PILOT_GOGGLES_GOLD).register(
                    (item, itemStack, componentContainer) -> componentContainer.put(CuriosComponent.ITEM, CuriosIntegration.createPilotGogglesCurio(new ItemStack(RegistryHandler.PILOT_GOGGLES_GOLD)))
            );
            ItemComponentCallbackV2.event(RegistryHandler.PILOT_GOGGLES_IRON).register(
                    (item, itemStack, componentContainer) -> componentContainer.put(CuriosComponent.ITEM, CuriosIntegration.createPilotGogglesCurio(new ItemStack(RegistryHandler.PILOT_GOGGLES_IRON)))
            );
            createJetpackCurioComponent(RegistryHandler.JETPACK_CREATIVE);
            createJetpackCurioComponent(RegistryHandler.JETPACK_CREATIVE_ARMORED);
            createJetpackCurioComponent(RegistryHandler.JETPACK_VANILLA1);
            createJetpackCurioComponent(RegistryHandler.JETPACK_VANILLA1_ARMORED);
            createJetpackCurioComponent(RegistryHandler.JETPACK_VANILLA2);
            createJetpackCurioComponent(RegistryHandler.JETPACK_VANILLA2_ARMORED);
            createJetpackCurioComponent(RegistryHandler.JETPACK_VANILLA3);
            createJetpackCurioComponent(RegistryHandler.JETPACK_VANILLA3_ARMORED);
            createJetpackCurioComponent(RegistryHandler.JETPACK_VANILLA4);
            createJetpackCurioComponent(RegistryHandler.JETPACK_VANILLA4_ARMORED);
        }
    }

    private void createJetpackCurioComponent(Item ITEM) {
        ItemComponentCallbackV2.event(ITEM).register(
                (item, itemStack, componentContainer) -> componentContainer.put(CuriosComponent.ITEM, CuriosIntegration.createJetpackCurio(new ItemStack(ITEM)))
        );
    }
}
