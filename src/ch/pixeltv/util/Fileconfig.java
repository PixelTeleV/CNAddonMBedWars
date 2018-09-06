package ch.pixeltv.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Coded by PixelTeleV
 * 05.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Fileconfig {

    public static String cmessage;
    public static String message;
    public static String reloaded;
    public static String nopermission;

    public static File ConfigFile = new File("plugins/CloudState", "config.yml");
    public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);

    public static void save() throws IOException {
        Config.save(ConfigFile);
    }

    public static void loadMessages() {
        Config.addDefault("messages.consolemessage", "§8┃ §eCloudState§8» §7§7");
        Config.addDefault("messages.message", "§8┃ §eCloudState§8» §7Du hast §ckeinen Zugriff §7auf §ediesen Befehl§7!");
        Config.addDefault("messages.reloaded", "§8┃ §eCloudState§8» §7Das Plugin §eCloudState §7wurde §aneu geladen§7!");
        Config.addDefault("messages.nopermission", "§8┃ §eTeamChat§8» §7Du hast §ckeinen Zugriff §7auf §ediesen Befehl§7!");

        Config.options().copyDefaults(true);
        try {
            Config.save(ConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initMessages() {
        cmessage = Config.getString("messages.consolemessage");
        message = Config.getString("messages.message");
        reloaded = Config.getString("messages.reloaded");
        nopermission = Config.getString("messages.nopermission");
    }

}
