package me.nazarxexe.enterprise.impl.strategy;

import me.nazarxexe.enterprise.interfaces.srategy.IConfigGetStrategy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

public class GetConfigPosition implements IConfigGetStrategy {

    private final ConfigurationSection section;

    public GetConfigPosition(ConfigurationSection section) {
        this.section = section;
    }

    @Override
    public Location getLocation() {
        Location location = section.getLocation("location");
        return location == null ? Bukkit.getWorld("world").getSpawnLocation() : location;
    }
}
