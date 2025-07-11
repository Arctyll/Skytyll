package com.arctyll.skytyll.events;

import com.arctyll.skytyll.Skytyll;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage("");

        Player player = event.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {
                player.sendMessage("§eWelcome to §aSkyBlock!");

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§b20% experience multiplier is currently enabled!");
                        player.sendMessage("§d+10 Magic Find Bonus!");
                    }
                }.runTaskLater(Skytyll.getInstance(), 20L);
            }
        }.runTaskLater(Skytyll.getInstance(), 40L);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage("");
    }
}
