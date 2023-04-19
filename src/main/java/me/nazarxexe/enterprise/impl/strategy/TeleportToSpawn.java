package me.nazarxexe.enterprise.impl.strategy;

import me.nazarxexe.enterprise.interfaces.srategy.ITeleportToSpawnStrategy;
import org.bukkit.Location;
import org.bukkit.entity.Player;


public class TeleportToSpawn implements ITeleportToSpawnStrategy {

    private final Player player;
    private final Location position;
    public TeleportToSpawn(Player player, Location position) {
        this.player = player;
        this.position = position;
    }

    @Override
    public void doTeleport() {
        player.teleport(position);
    }
}
