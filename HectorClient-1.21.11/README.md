# Hector Client — Minecraft Java 1.21.11

A Fabric client-side settings menu. Press **Right Shift** to open it and **Escape** to close it. The menu includes working local preference toggles for FPS and coordinates (the overlay rendering is not implemented in this starter yet).

## Build
Requires Java 21, Gradle, and internet access to download Fabric/Minecraft dependencies. Run `gradle build` in this folder; the output JAR will appear in `build/libs/`.

Not yet compiled: no JAR exists until you run the build (locally, or via the included GitHub Actions workflow). Do not treat this ZIP as a ready-to-install mod.

This project intentionally excludes anti-cheat bypasses, hidden storage/player ESP, and automated PvP/anchor/crystal combat macros.
