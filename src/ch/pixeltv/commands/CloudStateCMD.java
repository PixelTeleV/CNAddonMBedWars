package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
import ch.pixeltv.util.Fileconfig;
import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.server.ServerState;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Coded by PixelTeleV
 * 26.02.19
 * Copyright PixelTeleV 2019.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class CloudStateCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("cloudstate")) {
            if (args.length == 0) {
                p.sendMessage("§eCloudState Plugin §7coded by §aPixelTeleV§7! §9Version: " + Main.version + " §eDownload on SpigotMC.org!");
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (p.hasPermission("System.CloudState.Reload")) {
                        Fileconfig.loadMessages();
                        Fileconfig.initMessages();
                    } else {
                        p.sendMessage(Fileconfig.nopermission);
                    }
                    p.sendMessage(Fileconfig.reloaded);
                } else if(args[0].equalsIgnoreCase("change")) {
                    if(p.hasPermission("System.CloudState.ChangeState")) {
                        CloudServer.getInstance().setServerStateAndUpdate(ServerState.INGAME);
                        CloudServer.getInstance().changeToIngame();

                        //Send Message in Console when CloudState changed
                        Bukkit.getConsoleSender().sendMessage(Fileconfig.cmessage);

                        //Send Message to all Players with specific permissions
                        for(Player pl : Bukkit.getOnlinePlayers()) {
                            if(pl.hasPermission("System.CloudState.Message")) {
                                pl.sendMessage(Fileconfig.message);
                            }
                        }
                        p.sendMessage(Fileconfig.cvcmessage);
                    }
                } else {
                    p.sendMessage(Fileconfig.syntax);
                }
            }
        }

        return false;
    }

}
