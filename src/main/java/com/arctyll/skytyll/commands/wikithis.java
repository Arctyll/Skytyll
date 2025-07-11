package com.arctyll.skytyll.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class wikithis implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null) return true;

        String raw = item.getItemMeta().getDisplayName();
        String stripped = ChatColor.stripColor(raw);
        String name = stripped.replace(" ", "_");

        player.sendMessage("https://hypixel-skyblock.fandom.com/wiki/" + name);
        return true;
    }
}
