package com.notoriousdev.thehiddenmc.utils;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import com.notoriousdev.thehiddenmc.config.TheHiddenConfig;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;

public class HiddenSignHandler implements Listener
{
    private TheHiddenMC plugin;
    private TheHiddenConfig config;
    private Locale locale;
    private WorldManager worldManager;

    public HiddenSignHandler(TheHiddenMC plugin)
    {
        this.plugin = plugin;
        config = plugin.getHiddenConfig();
        locale = plugin.getLocale();
        worldManager = plugin.getWorldManager();
    }

    public void runSignClickHandler(Player player, String[] signtext)
    {
        if (isHiddenSign(signtext[0]))
        {
            if (!player.hasPermission("hidden.signs.join"))
            {
                locale.sendSignError(player);
                return;
            }
            else
            {
                locale.sendSignJoin(player);
                return;
            }
        }
    }

    @EventHandler
    public void SignCreate(SignChangeEvent event)
    {
        Player player = event.getPlayer();
        String[] signtext = event.getLines();

        if (signtext[0].equalsIgnoreCase(config.hiddenSignText))
        {
            if (!player.hasPermission("hidden.signs.create"))
            {
                locale.sendNoPermission(player);
                event.setCancelled(true);
                return;
            }
            if (!worldManager.isHiddenWorld(player.getWorld()))
            {
                locale.sendNotWorld(player);
                event.setCancelled(true);
                return;
            }
            locale.sendSignCreate(player);
        }
    }

    @EventHandler
    public void onSignDestroy(BlockBreakEvent event)
    {
        Block block = event.getBlock();

        if (block.getType().equals(Material.SIGN)
                || block.getType().equals(Material.WALL_SIGN)
                || block.getType().equals(Material.SIGN_POST))
        {
            Player player = event.getPlayer();
            BlockState state = block.getState();
            org.bukkit.block.Sign sign = ((org.bukkit.block.Sign) state);
            String[] signtext = sign.getLines();

            if (config.signProtectionEnabled && (signtext[0].equalsIgnoreCase(config.hiddenSignText)))
            {
                if (player.hasPermission("hidden.signs.destroy"))
                {
                    locale.sendSignDestroy(player);
                }
                else
                {
                    locale.sendNoPermission(player);
                    event.setCancelled(true);
                    sign.update();
                }
            }
        }
    }

    private boolean isHiddenSign(String signtext)
    {
        return signtext.equalsIgnoreCase(config.hiddenSignText);
    }
}

