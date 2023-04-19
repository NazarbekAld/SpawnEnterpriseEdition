package me.nazarxexe.enterprise.impl.command;

import me.nazarxexe.enterprise.impl.factory.SetSpawnFactory;
import me.nazarxexe.enterprise.interfaces.ISpawn;
import me.nazarxexe.enterprise.interfaces.IConfigGetMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final SetSpawnFactory factory;
    private final IConfigGetMessage config;

    public SetSpawnCommand(SetSpawnFactory factory, IConfigGetMessage config) {
        this.factory = factory;
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        factory.setLocation(player.getLocation());
        ISpawn iSpawn = factory.createSpawn();
        iSpawn.doSpawn();
        player.sendMessage(config.getMessage("set"));

        return true;
    }
}
