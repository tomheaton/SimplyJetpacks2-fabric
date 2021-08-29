package stormedpanda.simplyjetpacks.util;

import org.lwjgl.glfw.GLFW;

public class KeyboardUtil {

    //private static final long MINECRAFT_WINDOW = Minecraft.getInstance().getWindow().getWindow();

    public static boolean isHoldingShift() {
        //return InputMappings.isKeyDown(MINECRAFT_WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT);
        return true;
    }

    public static boolean isHoldingCtrl() {
        //return InputMappings.isKeyDown(MINECRAFT_WINDOW, GLFW.GLFW_KEY_LEFT_CONTROL);
        return true;
    }
}