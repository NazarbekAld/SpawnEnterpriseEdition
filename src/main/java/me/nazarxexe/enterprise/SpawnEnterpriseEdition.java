package me.nazarxexe.enterprise;

import me.nazarxexe.enterprise.impl.command.SetSpawnCommand;
import me.nazarxexe.enterprise.impl.command.SpawnCommand;
import me.nazarxexe.enterprise.impl.factory.SetSpawnFactory;
import me.nazarxexe.enterprise.impl.factory.SpawnFactory;
import me.nazarxexe.enterprise.impl.listener.PlayerListener;
import me.nazarxexe.enterprise.impl.strategy.GetConfigGetMessageStrategy;
import me.nazarxexe.enterprise.interfaces.IConfigGetMessage;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class SpawnEnterpriseEdition extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        ConfigurationSection spawnSection = getConfig().getConfigurationSection("spawn");
        ConfigurationSection messageSection = getConfig().getConfigurationSection("message");

        IConfigGetMessage strategy = new GetConfigGetMessageStrategy(messageSection);

        getCommand("spawn").setExecutor(new SpawnCommand(new SpawnFactory(spawnSection), strategy));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(new SetSpawnFactory(spawnSection), strategy));

        getServer().getPluginManager().registerEvents(new PlayerListener(new SpawnFactory(spawnSection), this), this);

    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
    }
}
