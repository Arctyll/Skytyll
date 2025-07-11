package com.arctyll.skytyll;

import com.arctyll.skytyll.events.JoinListener;
import com.arctyll.skytyll.events.PlayerHungerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Skytyll extends JavaPlugin {

    private static Skytyll instance;

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerListener(), this);
    }

    public static Skytyll getInstance() {
        return instance;
    }
}
