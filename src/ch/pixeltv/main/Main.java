package ch.pixeltv.main;

import ch.pixeltv.commands.CloudStateCMD;
import ch.pixeltv.listeners.CloudState;
import ch.pixeltv.util.Fileconfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Coded by PixelTeleV
 * 05.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Main extends JavaPlugin {

    //Version String
    public static String version = "Release 1.2";

    public void onEnable() {

        //Load & Initialize Config Strings
        Fileconfig.initMessages();
        Fileconfig.loadMessages();

        //Enable Message
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin: §aCloudState");
        Bukkit.getConsoleSender().sendMessage("§7Author: §aPixelTeleV");
        Bukkit.getConsoleSender().sendMessage("§7Version: §a" + version);
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§a§lPlugin activated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");

        //Register Listeners
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new CloudState(), this);

        //Register Commands
        getCommand("cloudstate").setExecutor(new CloudStateCMD());

    }

    public void onDisable() {
        //Disable Message
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin: §aCloudState");
        Bukkit.getConsoleSender().sendMessage("§7Author: §aPixelTeleV");
        Bukkit.getConsoleSender().sendMessage("§7Version: §a" + version);
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§c§lPlugin deactivated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
    }

}
