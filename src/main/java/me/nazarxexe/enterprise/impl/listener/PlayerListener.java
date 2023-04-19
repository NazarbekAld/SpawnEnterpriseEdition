package me.nazarxexe.enterprise.impl.listener;

import jdk.tools.jlink.plugin.Plugin;
import me.nazarxexe.enterprise.SpawnEnterpriseEdition;
import me.nazarxexe.enterprise.impl.factory.SpawnFactory;
import me.nazarxexe.enterprise.interfaces.ISpawn;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerListener implements Listener {

    private final SpawnFactory factory;
    private final SpawnEnterpriseEdition plugin;

    public PlayerListener(SpawnFactory factory, SpawnEnterpriseEdition plugin) {
        this.factory = factory;
        this.plugin = plugin;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        factory.setPlayer(e.getPlayer());
        ISpawn spawn = factory.createSpawn();

        plugin.getServer().getScheduler().runTaskLater(plugin, spawn::doSpawn, 1);
    }


}
