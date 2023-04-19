package me.nazarxexe.enterprise.impl;

import me.nazarxexe.enterprise.interfaces.IConfigGetMessage;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

public class GetConfigGetMessage implements IConfigGetMessage {
    private final ConfigurationSection section;
    public GetConfigGetMessage(ConfigurationSection section) {
        this.section = section;
    }

    @Override
    public String getMessage(String key) {
        return section.getString(key) == null ? "" : color(section.getString(key));
    }

    private String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
