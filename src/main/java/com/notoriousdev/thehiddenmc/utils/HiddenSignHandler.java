package com.notoriousdev.thehiddenmc.utils;

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
    private static TheHiddenConfig config = new TheHiddenConfig();
    private static Locale locale = new Locale();

    public HiddenSignHandler()
    {
    }

    public void runSignClickHandler(Player player, String[] signtext)
    {
        if (isHiddenSign(signtext[0]))
        {
            if (!player.hasPermission("hidden.signs.join"))
            {
                locale.sendSignError(player);
                return;
            } else
            {
                locale.sendSignJoin(player);
                return;
            }
        }
        else
        {
            return;
        }
    }

    @EventHandler
    public void SignCreate(SignChangeEvent event)
    {
        Player player = event.getPlayer();
        String[] signtext = event.getLines();

        if (signtext[0].equalsIgnoreCase(config.getHiddenSignText()))
        {
            if (!player.hasPermission("hidden.signs.create"))
            {
                locale.sendNoPermission(player);
                event.setCancelled(true);
            } else
            {
                locale.sendSignCreate(player);
            }
        } else
        {
            return;
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

            if (config.isSignProtectionEnabled() && (signtext[0].equalsIgnoreCase(config.getHiddenSignText())))
            {
                if (player.hasPermission("hidden.signs.destroy"))
                {
                    locale.sendSignDestroy(player);
                } else
                {
                    locale.sendNoPermission(player);
                    event.setCancelled(true);
                    sign.update();
                }

            } else
            {
                return;
            }
        }
    }

    private boolean isHiddenSign(String signtext)
    {
        return signtext.equalsIgnoreCase(config.getHiddenSignText());
    }
}

