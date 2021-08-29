package stormedpanda.simplyjetpacks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;
import stormedpanda.simplyjetpacks.item.JetpackItem;
import stormedpanda.simplyjetpacks.util.JetpackUtil;

public class ClientInitialization implements ClientModInitializer {

    public static KeyBinding JETPACK_GUI_KEY;
    public static KeyBinding JETPACK_ENGINE_KEY;
    public static KeyBinding JETPACK_HOVER_KEY;
    public static KeyBinding JETPACK_EHOVER_KEY;
    public static KeyBinding JETPACK_CHARGER_KEY;

    @Override
    public void onInitializeClient() {

        JETPACK_GUI_KEY = new KeyBinding("keybind.simplyjetpacks.jetpack_gui", GLFW.GLFW_KEY_K, "keybind.simplyjetpacks.category");
        KeyBindingHelper.registerKeyBinding(JETPACK_GUI_KEY);
        JETPACK_ENGINE_KEY = new KeyBinding("keybind.simplyjetpacks.jetpack_engine", GLFW.GLFW_KEY_J, "keybind.simplyjetpacks.category");
        KeyBindingHelper.registerKeyBinding(JETPACK_ENGINE_KEY);
        JETPACK_HOVER_KEY = new KeyBinding("keybind.simplyjetpacks.jetpack_hover", GLFW.GLFW_KEY_H, "keybind.simplyjetpacks.category");
        KeyBindingHelper.registerKeyBinding(JETPACK_HOVER_KEY);
        JETPACK_EHOVER_KEY = new KeyBinding("keybind.simplyjetpacks.jetpack_ehover", GLFW.GLFW_KEY_UNKNOWN, "keybind.simplyjetpacks.category");
        KeyBindingHelper.registerKeyBinding(JETPACK_EHOVER_KEY);
        JETPACK_CHARGER_KEY = new KeyBinding("keybind.simplyjetpacks.jetpack_charger", GLFW.GLFW_KEY_UNKNOWN, "keybind.simplyjetpacks.category");
        KeyBindingHelper.registerKeyBinding(JETPACK_CHARGER_KEY);


        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            PlayerEntity player = client.player;
            if (player == null) {
                return;
            }
            ItemStack chestStack = JetpackUtil.getFromBothSlots(player);
            Item chestItem = null;
            if (!chestStack.isEmpty()) {
                chestItem = chestStack.getItem();
            }
            if (chestItem instanceof JetpackItem) {
                if (JETPACK_GUI_KEY.isPressed()) {
                    //Minecraft.getInstance().setScreen(new JetpackScreen());
                    client.player.sendMessage(new LiteralText("JETPACK_GUI_KEY"), false);
                }
                if (JETPACK_ENGINE_KEY.isPressed()) {
                    //NetworkHandler.sendToServer(new PacketToggleEngine());
                    client.player.sendMessage(new LiteralText("JETPACK_ENGINE_KEY"), false);
                }
                if (JETPACK_HOVER_KEY.isPressed()) {
                    //NetworkHandler.sendToServer(new PacketToggleHover());
                    client.player.sendMessage(new LiteralText("JETPACK_HOVER_KEY"), false);
                }
                if (JETPACK_EHOVER_KEY.isPressed()) {
                    //NetworkHandler.sendToServer(new PacketToggleEHover());
                    client.player.sendMessage(new LiteralText("JETPACK_EHOVER_KEY"), false);
                }
                if (JETPACK_CHARGER_KEY.isPressed()) {
                    //NetworkHandler.sendToServer(new PacketToggleCharger());
                    client.player.sendMessage(new LiteralText("JETPACK_CHARGER_KEY"), false);
                }
            }
        });

    }
    /*
    private static void tickEnd() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null) {
            boolean flyState = mc.player.input.jumping;
            boolean descendState = mc.player.input.shiftKeyDown;
            boolean forwardState = mc.player.input.up;
            boolean backwardState = mc.player.input.down;
            boolean leftState = mc.player.input.left;
            boolean rightState = mc.player.input.right;
            if (flyState != lastFlyState || descendState != lastDescendState || forwardState != lastForwardState || backwardState != lastBackwardState || leftState != lastLeftState || rightState != lastRightState) {
                lastFlyState = flyState;
                lastDescendState = descendState;
                lastForwardState = forwardState;
                lastBackwardState = backwardState;
                lastLeftState = leftState;
                lastRightState = rightState;
                NetworkHandler.sendToServer(new PacketUpdateInput(flyState, descendState, forwardState, backwardState, leftState, rightState));
                CommonJetpackHandler.update(mc.player, flyState, descendState, forwardState, backwardState, leftState, rightState);
            }
        }
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent evt) {
        if (evt.phase == TickEvent.Phase.END) {
            tickEnd();
        }
    }*/
}