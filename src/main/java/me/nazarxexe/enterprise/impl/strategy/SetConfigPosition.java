package me.nazarxexe.enterprise.impl.strategy;

import me.nazarxexe.enterprise.interfaces.strategy.ConfigWriteStrategy;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

public class SetConfigPosition implements ConfigWriteStrategy {

    private final ConfigurationSection section;
    private final Location position;


    public SetConfigPosition(ConfigurationSection section, Location position) {
        this.section = section;
        this.position = position;
    }

    @Override
    public void setLocation() {
        section.set("location", position);
    }
}
