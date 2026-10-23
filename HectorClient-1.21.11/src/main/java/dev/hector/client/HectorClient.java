package dev.hector.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

/** Lightweight client settings menu for Minecraft Java 1.21.11. */
public final class HectorClient implements ClientModInitializer {
    private static KeyMapping openHudKey;
    public static boolean showFps = true;
    public static boolean showCoordinates = false;

    @Override
    public void onInitializeClient() {
        openHudKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.hectorclient.open_hud", GLFW.GLFW_KEY_RIGHT_SHIFT, KeyMapping.Category.MISC));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openHudKey.consumeClick()) {
                if (client.screen instanceof HectorHudScreen) client.setScreen(null);
                else if (client.screen == null) client.setScreen(new HectorHudScreen());
            }
        });
    }
}
