package com.notoriousdev.thehiddenmc;

import com.notoriousdev.thehiddenmc.config.TheHiddenConfig;
import com.notoriousdev.thehiddenmc.listeners.TheHiddenPlayerListener;
import com.notoriousdev.thehiddenmc.utils.HiddenSignHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Logger;

public class TheHiddenMC extends JavaPlugin
{
    public static TheHiddenMC instance;
    private static TheHiddenConfig config;
    private static final PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onDisable()
    {
        //TODO brian is a faget
    }

    @Override
    public void onEnable()
    {
        instance = this;
        saveDefaultConfig();
        config = new TheHiddenConfig();
        registerListeners();
        checkForDependencies();
        getLogger().info("Successfully enabled!");
    }

    private void registerListeners()
    {
        pm.registerEvents(new TheHiddenPlayerListener(), this);
        pm.registerEvents(new HiddenSignHandler(), this);
    }

    private void checkForDependencies()
    {
        if (config.isTagApiEnabled())
        {
            if (!pm.isPluginEnabled("TagAPI"))
            {
                getLogger().warning("You have chosen to use TagAPI but I couldn't find it. Are you sure it's installed?");
                getLogger().warning("I'm going to disable myself now. Please fix any errors mentioned above.");
                pm.disablePlugin(this);
            }
            else
            {
                getLogger().info("TagAPI found and enabled in config. Using it for Hidden nametags.");
            }
        }
        else
        {
            getLogger().info("You have chosen not to use TagAPI.");
            getLogger().info("While TheHiddenMC will work fine without it, it is recommended to get the most out of the plugin.");
        }
    }
}
