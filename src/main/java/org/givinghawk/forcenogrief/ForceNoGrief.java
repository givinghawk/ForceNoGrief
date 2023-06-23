package org.givinghawk.forcenogrief;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForceNoGrief extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // Kick the player when they break a block
        event.getPlayer().kickPlayer("Griefing");
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // Kick the player when they place a block
        event.getPlayer().kickPlayer("Griefing");
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        // Kick the player when they kill a mob
        if (event.getEntity().getKiller() != null) {
            event.getEntity().getKiller().kickPlayer("Griefing");
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        // Kick the player when they open an inventory
        event.getPlayer().kickPlayer("Griefing");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Kick the player when they interact with a block
        event.getPlayer().kickPlayer("Griefing");
    }

}
