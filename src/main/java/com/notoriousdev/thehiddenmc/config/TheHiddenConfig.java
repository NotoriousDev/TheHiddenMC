package com.notoriousdev.thehiddenmc.config;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

public class TheHiddenConfig
{

    private static TheHiddenMC plugin = TheHiddenMC.instance;

    private static FileConfiguration config = plugin.getConfig();
    @Getter
    private static boolean tagAPIEnabled;

    public TheHiddenConfig()
    {
        loadConfig();
    }
    private void loadConfig()
    {
        this.tagAPIEnabled = config.getBoolean("settings.useTagAPI");
    }
}
