package me.nazarxexe.enterprise.impl.strategy;

import me.nazarxexe.enterprise.interfaces.strategy.ConfigReadStrategy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

public class GetConfigPosition implements ConfigReadStrategy {

    private final ConfigurationSection section;

    public GetConfigPosition(ConfigurationSection section) {
        this.section = section;
    }

    @Override
    @SuppressWarnings( "all" ) // IDE warns code 20line can be NullPointerExeption but it never throw.
    public Location getLocation() {
        Location location = section.getLocation("location");
        return location == null ? Bukkit.getWorld("world").getSpawnLocation() : location;
    }
}
