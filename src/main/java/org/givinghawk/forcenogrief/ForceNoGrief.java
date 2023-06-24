package org.givinghawk.forcenogrief;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.ConsoleCommandSender;

public final class ForceNoGrief extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("[FNG-LOG] ForceNoGrief enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("[FNG-LOG] ForceNoGrief has shut down, goodbye.");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // Kick the player when they break a block
        Player player = event.getPlayer();
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("[FNG-LOG] Player "+player.getName()+" has been kicked for 'onBlockBreakEvent'");
        player.kickPlayer("Griefing");
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // Kick the player when they place a block
        Player player = event.getPlayer();
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("[FNG-LOG] Player "+player.getName()+" has been kicked for 'onBlockPlaceEvent'");
        player.kickPlayer("Griefing");
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        // Kick the player when they kill a mob
        Player player = event.getEntity().getKiller();
        if (player != null) {
            ConsoleCommandSender console = getServer().getConsoleSender();
            console.sendMessage("[FNG-LOG] Player "+player.getName()+" has been kicked for 'onEntityDeathEvent'");
            player.kickPlayer("Griefing");
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        // Kick the player when they open an inventory
        Player player = (Player) event.getPlayer();
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("[FNG-LOG] Player "+player.getName()+" has been kicked for 'onInventoryOpenEvent'");
        player.kickPlayer("Griefing");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Kick the player when they interact with a block
        Player player = event.getPlayer();
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("[FNG-LOG] Player "+player.getName()+" has been kicked for 'onPlayerInteractEvent'");
        player.kickPlayer("Griefing");
    }
}
