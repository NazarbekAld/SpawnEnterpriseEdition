package me.nazarxexe.enterprise;

import me.nazarxexe.enterprise.impl.reader.SetSpawnCommand;
import me.nazarxexe.enterprise.impl.reader.SpawnCommand;
import me.nazarxexe.enterprise.impl.factory.SetSpawnFactory;
import me.nazarxexe.enterprise.impl.factory.TeleportToSpawnFactory;
import me.nazarxexe.enterprise.impl.listener.PlayerListener;
import me.nazarxexe.enterprise.impl.GetConfigGetMessage;
import me.nazarxexe.enterprise.interfaces.ConfigReadMessage;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnEnterpriseEdition extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        ConfigurationSection spawnSection = getConfig().getConfigurationSection("spawn");
        ConfigurationSection messageSection = getConfig().getConfigurationSection("message");

        ConfigReadMessage strategy = new GetConfigGetMessage(messageSection);

        getCommand("spawn").setExecutor(new SpawnCommand(new TeleportToSpawnFactory(spawnSection), strategy));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(new SetSpawnFactory(spawnSection), strategy));

        getServer().getPluginManager().registerEvents(new PlayerListener(new TeleportToSpawnFactory(spawnSection), this), this);
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
    }
}
