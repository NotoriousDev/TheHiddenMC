package com.notoriousdev.thehiddenmc.listeners;


import com.notoriousdev.thehiddenmc.TheHiddenMC;
import com.notoriousdev.thehiddenmc.utils.HiddenSignHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

public class TheHiddenPlayerListener implements Listener
{
    private static TheHiddenMC plugin = TheHiddenMC.instance;
    private static HiddenSignHandler signHandler = new HiddenSignHandler();


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {

    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)
                && (block.getType().equals(Material.SIGN)
                || block.getType().equals(Material.WALL_SIGN)
                || block.getType().equals(Material.SIGN_POST)))
        {
            BlockState state = block.getState();
            Sign sign = ((Sign) state);
            String[] signtext = sign.getLines();

            signHandler.runSignClickHandler(event.getPlayer(), signtext);
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {

    }

    @EventHandler
    public void onPlayerSpawn(PlayerRespawnEvent event)
    {

    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event)
    {

    }
}
