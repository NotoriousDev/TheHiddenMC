package com.notoriousdev.thehiddenmc.config;

import com.notoriousdev.thehiddenmc.TheHiddenMC;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class TheHiddenConfig
{

    private static TheHiddenMC plugin = TheHiddenMC.instance;

    private static FileConfiguration config = plugin.getConfig();
    @Getter
    private static boolean tagApiEnabled;
    @Getter
    private static boolean signProtectionEnabled;
    @Getter
    private static String hiddenSignText;
    @Getter
    private static String messagePrefix;
    @Getter
    private static String messageSignCreate;
    @Getter
    private static String messageSignDestroy;
    @Getter
    private static String messageSignJoin;
    @Getter
    private static String messageSignError;
    @Getter
    private static String messageNoPermission;


    public TheHiddenConfig()
    {
        loadConfig();
    }
    private void loadConfig()
    {
        this.tagApiEnabled = config.getBoolean("settings.useTagAPI");
        this.hiddenSignText = config.getString("signs.hidden-sign-text");
        this.signProtectionEnabled = config.getBoolean("settings.protect-signs");
        this.messagePrefix = config.getString("messages.prefix");
        this.messageSignCreate = config.getString("messages.sign-create");
        this.messageSignDestroy = config.getString("messages.sign-destroy");
        this.messageSignJoin = config.getString("messages.sign-join");
        this.messageSignError = config.getString("messages.sign-error");
        this.messageNoPermission = config.getString("messages.no-permission");
    }
}
