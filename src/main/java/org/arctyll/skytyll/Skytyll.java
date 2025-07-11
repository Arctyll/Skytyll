package org.arctyll.skytyll;

import org.bukkit.plugin.java.JavaPlugin;
import org.arctyll.skytyll.events.JoinListener;

public class Skytyll extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }
}
