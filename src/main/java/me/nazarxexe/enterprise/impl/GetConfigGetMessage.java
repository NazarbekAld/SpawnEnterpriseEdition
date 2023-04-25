package me.nazarxexe.enterprise.impl;

import me.nazarxexe.enterprise.interfaces.ConfigReadMessage;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

public class GetConfigGetMessage implements ConfigReadMessage {
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
