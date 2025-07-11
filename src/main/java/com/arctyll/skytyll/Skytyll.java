package com.arctyll.skytyll;

import com.arctyll.skytyll.events.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Skytyll extends JavaPlugin {

    private static Skytyll instance;

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    public static Skytyll getInstance() {
        return instance;
    }
}
