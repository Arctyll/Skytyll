package com.arctyll.skytyll.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;
import com.arctyll.skytyll.Skytyll;

public class AspectListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(Skytyll.getInstance(), "skyblock_id");

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;

        Action action = event.getAction();
        if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) return;

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null || item.getType() != Material.DIAMOND_SWORD) return;

        ItemMeta meta = item.getItemMeta();
        if (meta == null || !meta.getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;

        String id = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
        if (!"skyblock:aspect_of_the_end".equals(id)) return;

        Vector direction = player.getLocation().getDirection().normalize().multiply(8);
        player.teleport(player.getLocation().add(direction));
    }
}
