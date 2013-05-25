package com.notoriousdev.thehiddenmc.utils;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import com.notoriousdev.thehiddenmc.config.TheHiddenConfig;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Locale
{
    private TheHiddenMC plugin;
    private TheHiddenConfig config;
    private String prefix;

    public Locale(TheHiddenMC plugin)
    {
        this.plugin = plugin;
        config = plugin.getHiddenConfig();
        prefix = config.messagePrefix;
    }

    public void sendSignCreate(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.messageSignCreate));
    }
    public void sendSignDestroy(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.messageSignDestroy));
    }
    public void sendSignError(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.messageSignError));
    }
    public void sendSignJoin(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.messageSignJoin));
    }
    public void sendNoPermission(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.messageNoPermission));
    }
    public void sendNotWorld(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.messageNotWorld));
    }
    public void sendCommandReload(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.messageCommandReload));
    }
}
