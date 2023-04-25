package me.nazarxexe.enterprise.impl.reader;

import me.nazarxexe.enterprise.impl.factory.SetSpawnFactory;
import me.nazarxexe.enterprise.interfaces.Spawn;
import me.nazarxexe.enterprise.interfaces.ConfigReadMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final SetSpawnFactory factory;
    private final ConfigReadMessage config;

    public SetSpawnCommand(SetSpawnFactory factory, ConfigReadMessage config) {
        this.factory = factory;
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        factory.setLocation(player.getLocation());
        Spawn spawn = factory.createSpawn();
        spawn.doSpawn();
        player.sendMessage(config.getMessage("set"));

        return true;
    }
}
