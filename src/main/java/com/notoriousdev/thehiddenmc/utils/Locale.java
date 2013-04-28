package com.notoriousdev.thehiddenmc.utils;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import com.notoriousdev.thehiddenmc.config.TheHiddenConfig;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Locale
{
    private static TheHiddenMC plugin = TheHiddenMC.instance;
    private static TheHiddenConfig config;

    public Locale()
    {
    }
    private final String prefix = config.getMessagePrefix();

    public void sendSignCreate(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.getMessageSignCreate()));
    }
    public void sendSignDestroy(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.getMessageSignDestroy()));
    }
    public void sendSignError(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.getMessageSignError()));
    }
    public void sendSignJoin(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.getMessageSignJoin()));
    }
    public void sendNoPermission(Player player)
    {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + config.getMessageNoPermission()));
    }
}
