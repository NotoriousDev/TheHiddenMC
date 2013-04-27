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
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.material.Sign;

public class HiddenSignHandler implements Listener
{
    private static TheHiddenConfig config;

    public void runSignClickHandler(Player player, String[] signtext)
    {
        if (!player.hasPermission("hidden.signs.join") || (!isHiddenSign(signtext[0])))
        {
            player.sendMessage("This is not a Hidden sign!");
            return;
        }
        else
        {
            player.sendMessage("This is a Hidden sign!");
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
                player.sendMessage(ChatColor.RED + "You do not have permission to create TheHidden signs!");
                event.setCancelled(true);
            }
            else
            {
                player.sendMessage(ChatColor.GREEN + "TheHidden sign successfully created!");
            }
        }
        else
        {
            return;
        }
    }

    @EventHandler
    public void onSignDestroy(BlockBreakEvent event)
    {

        if (event.getBlock().getType() == Material.SIGN)
        {
            if(config.isSignProtectionEnabled())
            {
                Player player = event.getPlayer();
                Block block = event.getBlock();
                BlockState state = block.getState();

                org.bukkit.block.Sign sign = ((org.bukkit.block.Sign) state);
                String[] signtext = sign.getLines();

                if (signtext[0].equalsIgnoreCase(config.getHiddenSignText()) && (!player.hasPermission("hidden.signs.destroy")))
                {
                    player.sendMessage(ChatColor.RED + "You do not have permission to break HiddenSigns!");
                    event.setCancelled(true);
                    sign.update();
                }
                else
                {
                    player.sendMessage(ChatColor.GREEN + "TheHidden sign succesfully removed!");
                }
            }
            else
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
