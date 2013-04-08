package com.notoriousdev.thehiddenmc.config;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import org.bukkit.configuration.file.FileConfiguration;

public class TheHiddenConfig
{
    private static TheHiddenMC thehiddenmc;
    private static FileConfiguration config;
    private static boolean usingtagapi = thehiddenmc.getConfig().getBoolean("settings.useTagAPI");


    public boolean useTagAPI()
    {
        return usingtagapi;
    }
}
