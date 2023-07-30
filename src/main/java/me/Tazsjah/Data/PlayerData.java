package me.Tazsjah.Data;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class PlayerData {

    Maps maps;

    public PlayerData(Maps maps) {
        this.maps = maps;
    }

    public List<Player> queue = new ArrayList<>();

    public void addPlayer(Player player) {
        queue.add(player);
        if(queue.size() >= 1){

            Location loc = new Location(Bukkit.getWorld(maps.addGame()), 0, 65, 0);

            for(Player p : queue) {
                p.teleport(loc);
                queue.remove(p);
            }
        }
    }

}
