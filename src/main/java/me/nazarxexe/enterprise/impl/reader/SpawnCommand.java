package me.nazarxexe.enterprise.impl.reader;

import me.nazarxexe.enterprise.impl.factory.TeleportToSpawnFactory;
import me.nazarxexe.enterprise.interfaces.Spawn;
import me.nazarxexe.enterprise.interfaces.ConfigReadMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final TeleportToSpawnFactory factory;
    private final ConfigReadMessage config;

    public SpawnCommand(TeleportToSpawnFactory factory, ConfigReadMessage config) {
        this.factory = factory;
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        factory.setPlayer(player);
        Spawn spawn = factory.createSpawn();
        spawn.doSpawn();
        player.sendMessage(config.getMessage("teleport"));

        return true;
    }
}
