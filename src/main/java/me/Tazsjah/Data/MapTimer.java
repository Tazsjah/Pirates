package me.Tazsjah.Data;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class MapTimer {


    Sidebar bar;

    public MapTimer(Sidebar bar) {
        this.bar = bar;
    }

    public HashMap<World, Integer> countDown = new HashMap<>();
    public HashMap<World, Integer> gameTime = new HashMap<>();
    public HashMap<World, Integer> endTime = new HashMap<>();


    public void countdown(World w, GameState state) {
        new BukkitRunnable() {
            @Override
            public void run() {

                if(state == GameState.WAITING) {

                }

            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("Pirates"), 0, 20);
    }




}
