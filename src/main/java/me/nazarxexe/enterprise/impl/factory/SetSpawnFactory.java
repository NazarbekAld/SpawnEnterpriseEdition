package me.nazarxexe.enterprise.impl.factory;

import lombok.Setter;
import me.nazarxexe.enterprise.impl.SetSpawn;
import me.nazarxexe.enterprise.impl.strategy.SetConfigPosition;
import me.nazarxexe.enterprise.impl.strategy.SetSpawnWriteStrategy;
import me.nazarxexe.enterprise.interfaces.Spawn;
import me.nazarxexe.enterprise.interfaces.factory.SpawnFactory;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

public class SetSpawnFactory implements SpawnFactory {


    private @Setter Location location;
    private final ConfigurationSection section;

    public SetSpawnFactory(ConfigurationSection section) {
        this.section = section;
    }

    @Override
    public Spawn createSpawn() {
        SetConfigPosition config = new SetConfigPosition(section, location);
        SetSpawnWriteStrategy strategy = new SetSpawnWriteStrategy(config);

        return new SetSpawn(strategy);
    }
}
