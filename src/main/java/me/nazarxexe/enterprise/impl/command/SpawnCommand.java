package me.nazarxexe.enterprise.impl.command;

import me.nazarxexe.enterprise.impl.factory.SpawnFactory;
import me.nazarxexe.enterprise.interfaces.ISpawn;
import me.nazarxexe.enterprise.interfaces.IConfigGetMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final SpawnFactory factory;
    private final IConfigGetMessage config;

    public SpawnCommand(SpawnFactory factory, IConfigGetMessage config) {
        this.factory = factory;
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        factory.setPlayer(player);
        ISpawn spawn = factory.createSpawn();
        spawn.doSpawn();
        player.sendMessage(config.getMessage("teleport"));

        return true;
    }
}
