package com.notoriousdev.thehiddenmc.config;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import org.bukkit.configuration.file.FileConfiguration;

public class TheHiddenConfig
{

    private static TheHiddenMC plugin;

    private static FileConfiguration config;
    private static boolean usingtagapi;

    public TheHiddenConfig()
    {
        plugin = TheHiddenMC.instance;
        config = plugin.getConfig();

        loadConfig();
    }
    private void loadConfig()
    {
        this.usingtagapi = config.getBoolean("settings.useTagAPI");
    }

    public boolean useTagAPI()
    {
        return usingtagapi;
    }
}
