package me.nazarxexe.enterprise.impl.factory;

import lombok.Setter;
import me.nazarxexe.enterprise.impl.SetSpawn;
import me.nazarxexe.enterprise.impl.strategy.SetConfigPosition;
import me.nazarxexe.enterprise.impl.strategy.SetSpawnStrategy;
import me.nazarxexe.enterprise.interfaces.ISpawn;
import me.nazarxexe.enterprise.interfaces.factory.ISpawnFactory;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

public class SetSpawnFactory implements ISpawnFactory {


    private @Setter Location location;
    private final ConfigurationSection section;

    public SetSpawnFactory(ConfigurationSection section) {
        this.section = section;
    }

    @Override
    public ISpawn createSpawn() {
        SetConfigPosition config = new SetConfigPosition(section, location);
        SetSpawnStrategy strategy = new SetSpawnStrategy(config);

        return new SetSpawn(strategy);
    }
}
