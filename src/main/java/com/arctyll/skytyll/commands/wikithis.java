package com.arctyll.skytyll.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class wikithis implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) return true;

        ItemMeta meta = item.getItemMeta();
        String raw = meta.getDisplayName();
        String stripped = ChatColor.stripColor(raw);
        String name = stripped.replace(" ", "_");

        TextComponent component = new TextComponent(ChatColor.GRAY + "Click ");
        TextComponent link = new TextComponent(ChatColor.YELLOW.toString() + ChatColor.BOLD + "HERE");
        link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://hypixel-skyblock.fandom.com/wiki/" + name));
        link.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GRAY + "View " + ChatColor.YELLOW + stripped + ChatColor.GRAY + " on the " + ChatColor.GOLD + "Official SkyBlock Wiki!").create()));
        component.addExtra(link);
        component.addExtra(new TextComponent(ChatColor.GRAY + " to find it on the" + ChatColor.GOLD + " Official SkyBlock Wiki" + ChatColor.GRAY + "!"));

        player.sendMessage("");
        player.sendMessage(ChatColor.GRAY + "Found Item: " + stripped);
        player.spigot().sendMessage(component);
        player.sendMessage("");

        return true;
    }
}
