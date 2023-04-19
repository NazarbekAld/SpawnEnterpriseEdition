package me.nazarxexe.enterprise.impl.factory;

import lombok.Setter;
import me.nazarxexe.enterprise.impl.Spawn;
import me.nazarxexe.enterprise.impl.strategy.GetConfigPosition;
import me.nazarxexe.enterprise.impl.strategy.TeleportToSpawn;
import me.nazarxexe.enterprise.interfaces.ISpawn;
import me.nazarxexe.enterprise.interfaces.factory.ISpawnFactory;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class SpawnFactory implements ISpawnFactory {

    private final ConfigurationSection section;
    private @Setter Player player;

    public SpawnFactory(ConfigurationSection section) {
        this.section = section;
    }

    @Override
    public ISpawn createSpawn() {

        GetConfigPosition config = new GetConfigPosition(section);
        TeleportToSpawn strat = new TeleportToSpawn(player, config.getLocation());

        return new Spawn(strat);
    }
}
