package me.nazarxexe.enterprise.impl.factory;

import lombok.Setter;
import me.nazarxexe.enterprise.impl.strategy.GetConfigPosition;
import me.nazarxexe.enterprise.impl.strategy.Teleport;
import me.nazarxexe.enterprise.interfaces.Spawn;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class TeleportToSpawnFactory implements me.nazarxexe.enterprise.interfaces.factory.SpawnFactory {

    private final ConfigurationSection section;
    private @Setter Player player;

    public TeleportToSpawnFactory(ConfigurationSection section) {
        this.section = section;
    }

    @Override
    public Spawn createSpawn() {

        GetConfigPosition config = new GetConfigPosition(section);
        Teleport strat = new Teleport(player, config.getLocation());

        return new me.nazarxexe.enterprise.impl.Spawn(strat);
    }
}
