package com.notoriousdev.thehiddenmc.utils;


import com.notoriousdev.thehiddenmc.config.TheHiddenConfig;
import org.bukkit.World;

public class WorldManager
{
    private static TheHiddenConfig config = new TheHiddenConfig();

    public WorldManager()
    {

    }

    public boolean isHiddenWorld(World world)
    {
        return config.getEnabledWorld().equals(world);
    }
}
