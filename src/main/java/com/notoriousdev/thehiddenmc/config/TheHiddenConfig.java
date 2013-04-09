package com.notoriousdev.thehiddenmc.config;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import org.bukkit.configuration.file.FileConfiguration;

public class TheHiddenConfig
{

    private static TheHiddenMC plugin;

    private static FileConfiguration config;
    @Getter
    private static boolean tagAPIEnabled;

    public TheHiddenConfig()
    {
        plugin = TheHiddenMC.instance;
        config = plugin.getConfig();

        loadConfig();
    }
    private void loadConfig()
    {
        this.tagAPIEnabled = config.getBoolean("settings.useTagAPI");
    }
}
