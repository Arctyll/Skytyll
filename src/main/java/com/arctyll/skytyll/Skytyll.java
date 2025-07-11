package com.arctyll.skytyll;

import com.arctyll.skytyll.events.JoinListener;
import com.arctyll.skytyll.events.PlayerHungerListener;
import com.arctyll.skytyll.events.PlayerInventoryClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Skytyll extends JavaPlugin {

    private static Skytyll instance;

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInventoryClickListener(), this);
    }

    public static Skytyll getInstance() {
        return instance;
    }
}
