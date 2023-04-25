package me.nazarxexe.enterprise.impl.listener;

import me.nazarxexe.enterprise.SpawnEnterpriseEdition;
import me.nazarxexe.enterprise.impl.factory.TeleportToSpawnFactory;
import me.nazarxexe.enterprise.interfaces.Spawn;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerListener implements Listener {

    private final TeleportToSpawnFactory factory;
    private final SpawnEnterpriseEdition plugin;

    public PlayerListener(TeleportToSpawnFactory factory, SpawnEnterpriseEdition plugin) {
        this.factory = factory;
        this.plugin = plugin;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        factory.setPlayer(e.getPlayer());
        Spawn spawn = factory.createSpawn();

        plugin.getServer().getScheduler().runTaskLater(plugin, spawn::doSpawn, 1);
    }


}
