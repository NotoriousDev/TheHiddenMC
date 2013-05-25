package com.notoriousdev.thehiddenmc;

import com.notoriousdev.thehiddenmc.commands.HiddenCommands;
import com.notoriousdev.thehiddenmc.config.TheHiddenConfig;
import com.notoriousdev.thehiddenmc.listeners.TheHiddenPlayerListener;
import com.notoriousdev.thehiddenmc.utils.HiddenSignHandler;
import com.notoriousdev.thehiddenmc.utils.Locale;
import com.notoriousdev.thehiddenmc.utils.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Logger;

public class TheHiddenMC extends JavaPlugin
{
    public TheHiddenMC instance;
    private TheHiddenConfig config;
    private Locale locale;
    private PluginManager pm = Bukkit.getPluginManager();
    private HiddenSignHandler signHandler;
    private WorldManager worldManager;

    @Override
    public void onDisable()
    {
        instance = null;
        config = null;
        locale = null;
        signHandler= null;
        worldManager = null;
    }

    @Override
    public void onEnable()
    {
        instance = this;
        saveDefaultConfig();
        config = new TheHiddenConfig(this);
        locale = new Locale(this);
        signHandler = new HiddenSignHandler(this);
        worldManager = new WorldManager(this);
        registerListeners();
        setExecutors();
        checkForDependencies();
        getLogger().info("Successfully enabled!");
    }

    private void registerListeners()
    {
        pm.registerEvents(new TheHiddenPlayerListener(this), this);
        pm.registerEvents(new HiddenSignHandler(this), this);
    }
    private void setExecutors()
    {
        getCommand("hidden").setExecutor(new HiddenCommands(this));
    }

    private void checkForDependencies()
    {
        if (config.tagApiEnabled)
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

    public TheHiddenMC getInstance()
    {
        return instance;
    }
    public TheHiddenConfig getHiddenConfig()
    {
        return config;
    }
    public Locale getLocale()
    {
        return locale;
    }
    public HiddenSignHandler getSignHandler()
    {
        return signHandler;
    }
    public WorldManager getWorldManager()
    {
        return worldManager;
    }
}
