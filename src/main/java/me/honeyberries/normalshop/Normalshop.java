package me.honeyberries.normalshop;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public final class Normalshop extends JavaPlugin {

    private static Normalshop instance;

    @Override
    public void onEnable() {
        
        // Register command executor
        Objects.requireNonNull(getCommand("shop")).setExecutor(new ShopCommand());
        
        // Register event listener for shop interactions
        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        
        getLogger().info("Normalshop has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Normalshop has been disabled!");
    }

    public static Normalshop getInstance() {
        return getPlugin(Normalshop.class);
    }
}
