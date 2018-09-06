package ch.pixeltv.listeners;

import ch.pixeltv.util.Fileconfig;
import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.server.ServerState;
import de.marcely.bedwars.api.event.RoundStartEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Coded by PixelTeleV
 * 05.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class CloudState implements Listener {

    @EventHandler
    public void onRound(RoundStartEvent e) {
        CloudServer.getInstance().setServerStateAndUpdate(ServerState.INGAME);
        CloudServer.getInstance().changeToIngame();

        //Send Message in Console when CloudState changed
        Bukkit.getConsoleSender().sendMessage(Fileconfig.cmessage);

        //Send Message to all Players with specific permissions
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.hasPermission("System.CSMessage")) {
                p.sendMessage(Fileconfig.message);
            }
        }
    }

}
