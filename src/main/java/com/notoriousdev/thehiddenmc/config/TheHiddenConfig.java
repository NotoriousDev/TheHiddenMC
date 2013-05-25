package com.notoriousdev.thehiddenmc.config;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import org.bukkit.configuration.file.FileConfiguration;

public class TheHiddenConfig
{

    private FileConfiguration config;
    private TheHiddenMC plugin;

    public boolean tagApiEnabled;
    public boolean signProtectionEnabled;
    public String hiddenSignText;
    public String messagePrefix;
    public String messageSignCreate;
    public String messageSignDestroy;
    public String messageSignJoin;
    public String messageSignError;
    public String messageNoPermission;
    public String messageNotWorld;
    public String enabledWorld;
    public String messageCommandReload;

    public TheHiddenConfig(TheHiddenMC plugin)
    {
        this.plugin = plugin;
        config = plugin.getConfig();
        loadConfig();
    }

    public void reload()
    {
        plugin.reloadConfig();
        config = plugin.getConfig();
        loadConfig();
    }

    private void loadConfig()
    {
        tagApiEnabled = config.getBoolean("settings.useTagAPI");
        hiddenSignText = config.getString("signs.hidden-sign-text");
        signProtectionEnabled = config.getBoolean("settings.protect-signs");
        messagePrefix = config.getString("messages.prefix");
        messageSignCreate = config.getString("messages.sign-create");
        messageSignDestroy = config.getString("messages.sign-destroy");
        messageSignJoin = config.getString("messages.sign-join");
        messageSignError = config.getString("messages.sign-error");
        messageNoPermission = config.getString("messages.no-permission");
        messageNotWorld = config.getString("messages.not-hidden-world");
        enabledWorld = config.getString("settings.enabled-world");
        messageCommandReload = config.getString("messages.commands.reload");

    }
}
