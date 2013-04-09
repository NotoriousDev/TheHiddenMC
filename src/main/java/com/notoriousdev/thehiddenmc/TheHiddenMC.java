package com.notoriousdev.thehiddenmc;

import com.notoriousdev.thehiddenmc.config.TheHiddenConfig;
import com.notoriousdev.thehiddenmc.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Logger;

public class TheHiddenMC extends JavaPlugin
{
    public static TheHiddenMC instance;
    private static TheHiddenConfig config;
    private static final Logger log = Bukkit.getServer().getLogger();
    private static final PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable()
    {
        instance = this;
        saveDefaultConfig();
        config = new TheHiddenConfig();
        registerListeners();
        if (config.isTagAPIEnabled())
        {
            if (!pm.isPluginEnabled("TagAPI"))
            {
                log.info("You have chosen to use TagAPI but I couldn't find it. Are you sure it's installed?");
                log.info("I'm going to disable myself now. Please fix any errors mentioned above.");
                pm.disablePlugin(this);
            }
            else
            {
                log.info("TagAPI found and enabled in config. Using it for Hidden nametags.");
            }
        }
        else
        {
            log.info("You have chosen not to use TagAPI.");
            log.info("While TheHiddenMC will work fine without it, it is recommended to get the most out of the plugin.");
        }
        log.info("Successfully enabled!");
    }

    @Override
    public void onDisable()
    {
    }

    public void registerListeners()
    {
        pm.registerEvents(new PlayerListener(), this);
    }
}
