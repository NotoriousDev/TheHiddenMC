package com.notoriousdev.thehiddenmc.commands;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import com.notoriousdev.thehiddenmc.config.TheHiddenConfig;
import com.notoriousdev.thehiddenmc.utils.Locale;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HiddenCommands implements CommandExecutor
{
    private TheHiddenMC plugin;
    private TheHiddenConfig config;
    private Locale locale;
    private String prefix;

    public HiddenCommands(TheHiddenMC plugin)
    {
        this.plugin = plugin;
        config = plugin.getHiddenConfig();
        locale = plugin.getLocale();
        prefix = config.messagePrefix;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (label.equalsIgnoreCase("hidden"))
        {
            if (!sender.hasPermission("hiddenmc.admin"))
            {
                locale.sendNoPermission((Player) sender);
                return true;
            }
            if (args.length == 0)
            {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&a/hidden reload"));
                return true;
            }
            if (args.length > 1)
            {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&cToo many args!"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&a/hidden reload"));
                return true;
            }
            if (args[0].equalsIgnoreCase("reload"))
            {
                config.reload();
                locale.sendCommandReload((Player) sender);
                return true;
            }
            else
            {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&cUnrecognised command!"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&a/hidden reload"));
                return true;
            }
        }
        return false;
    }
}
