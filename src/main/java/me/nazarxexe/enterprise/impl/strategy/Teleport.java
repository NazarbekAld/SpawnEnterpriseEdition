package me.nazarxexe.enterprise.impl.strategy;

import me.nazarxexe.enterprise.interfaces.strategy.TeleportStrategy;
import org.bukkit.Location;
import org.bukkit.entity.Player;


public class Teleport implements TeleportStrategy {

    private final Player player;
    private final Location position;
    public Teleport(Player player, Location position) {
        this.player = player;
        this.position = position;
    }

    @Override
    public void doTeleport() {
        player.teleport(position);
    }
}
