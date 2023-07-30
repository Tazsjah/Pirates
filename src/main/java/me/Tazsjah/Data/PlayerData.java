package me.Tazsjah.Data;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

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
        if(queue.size() >= 8){

            Location loc = new Location(Bukkit.getWorld(maps.addGame()), 0, 65, 0);

            for(Player p : queue) {
                p.teleport(loc);
                queue.remove(p);
            }
        }
    }

    public Boolean checkPlayer(Player player) {
        if(player.getLocation().getWorld().getName().contains(maps.settings.mainWorld() + "_")) {
            return true;
        }

        return false;
    }

    public int fetchGames(){
        int amount = 0;

        for(World w : Bukkit.getWorlds()) {
            if(w.getName().contains(maps.settings.mainWorld() + "_")){
                amount++;
            }
        }

        return amount;
    }

}
