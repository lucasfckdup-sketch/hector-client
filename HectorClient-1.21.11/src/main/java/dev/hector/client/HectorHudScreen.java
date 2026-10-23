package dev.hector.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** Hector Client settings menu. Open with Right Shift; Escape closes it. */
public final class HectorHudScreen extends Screen {
    public HectorHudScreen() { super(Component.literal("Hector Client")); }

    @Override
    protected void init() {
        int w = 220;
        int x = (this.width - w) / 2;
        int y = (this.height - 92) / 2;
        this.addRenderableWidget(Button.builder(toggleLabel("Show FPS", HectorClient.showFps), b -> {
            HectorClient.showFps = !HectorClient.showFps; b.setMessage(toggleLabel("Show FPS", HectorClient.showFps));
        }).bounds(x, y, w, 20).build());
        this.addRenderableWidget(Button.builder(toggleLabel("Show Coordinates", HectorClient.showCoordinates), b -> {
            HectorClient.showCoordinates = !HectorClient.showCoordinates; b.setMessage(toggleLabel("Show Coordinates", HectorClient.showCoordinates));
        }).bounds(x, y + 25, w, 20).build());
        this.addRenderableWidget(Button.builder(Component.literal("Close"), b -> this.onClose())
            .bounds(x, y + 53, w, 20).build());
    }

    private static Component toggleLabel(String name, boolean enabled) {
        return Component.literal(name + ": " + (enabled ? "ON" : "OFF"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.renderBackground(graphics, mouseX, mouseY, partialTick);
        int panelWidth = 250, panelHeight = 130;
        int left = (this.width - panelWidth) / 2, top = (this.height - panelHeight) / 2;
        graphics.fill(left, top, left + panelWidth, top + panelHeight, 0xEE15191F);
        graphics.fill(left, top, left + panelWidth, top + 2, 0xFF38BDF8);
        graphics.drawCenteredString(this.font, Component.literal("HECTOR CLIENT"), this.width / 2, top + 10, 0xFFFFFFFF);
        graphics.drawCenteredString(this.font, Component.literal("CLIENT SETTINGS"), this.width / 2, top + 27, 0xFF38BDF8);
    }

    @Override public boolean isPauseScreen() { return false; }
}
