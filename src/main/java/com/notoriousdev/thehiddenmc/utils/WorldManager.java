package com.notoriousdev.thehiddenmc.utils;


import com.notoriousdev.thehiddenmc.TheHiddenMC;
import com.notoriousdev.thehiddenmc.config.TheHiddenConfig;
import org.bukkit.World;

public class WorldManager
{
    private TheHiddenMC plugin;
    private TheHiddenConfig config;

    public WorldManager(TheHiddenMC plugin)
    {
        this.plugin = plugin;
        config = plugin.getHiddenConfig();
    }

    public boolean isHiddenWorld(World world)
    {
        return config.enabledWorld.equalsIgnoreCase(world.getName());
    }
}
