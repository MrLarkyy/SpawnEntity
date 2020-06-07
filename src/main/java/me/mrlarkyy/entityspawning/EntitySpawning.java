package me.mrlarkyy.entityspawning;

import org.bukkit.plugin.java.JavaPlugin;

public final class EntitySpawning extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin byl zapnut");
        getCommand("spawnentity").setExecutor(new Commands());

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin byl vypnut");
    }
}
