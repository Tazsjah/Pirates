package me.Tazsjah.Handlers;

import me.Tazsjah.Data.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerHandler implements Listener {

    PlayerData data;

    public PlayerHandler(PlayerData data) {
        this.data = data;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        data.addPlayer(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        data.queue.remove(event.getPlayer());
    }
}
