package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
import ch.pixeltv.util.Fileconfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Coded by PixelTeleV
 * 05.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class CloudStateCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("cloudstate")) {
            if (args.length == 0) {
                p.sendMessage("§eCloudState Plugin §7coded by §aPixelTeleV§7! §9Version: " + Main.version);
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (p.hasPermission("System.CloudState.Reload")) {
                        Fileconfig.loadMessages();
                        Fileconfig.initMessages();
                    }
                    p.sendMessage(Fileconfig.reloaded);
                } else {
                    p.sendMessage(Fileconfig.nopermission);
                }
            }
        }

        return false;
    }

}
