package me.Tazsjah.Handlers;

import me.Tazsjah.Data.GameState;
import me.Tazsjah.Data.PlayerData;
import me.Tazsjah.Data.Settings;
import me.Tazsjah.Data.Sidebar;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerHandler implements Listener {

    PlayerData data;
    Sidebar bar;

    Settings settings;

    public PlayerHandler(PlayerData data, Sidebar bar, Settings settings) {
        this.data = data;
        this.bar = bar;
        this.settings = settings;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        data.addPlayer(event.getPlayer());
        if(data.checkPlayer(event.getPlayer())) {
            bar.set(true, event.getPlayer(), event.getPlayer().getWorld(), GameState.getState(), null, 0, 0, 0);
            return;
        }

        bar.set(false, event.getPlayer(), event.getPlayer().getWorld(), GameState.getState(), null, 0, 0, data.fetchGames());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        data.queue.remove(event.getPlayer());
    }

}
