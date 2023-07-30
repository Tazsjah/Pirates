package me.Tazsjah.Data;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Maps {

    Settings settings;
    MultiverseCore mv = (MultiverseCore) Bukkit.getPluginManager().getPlugin("Multiverse-Core");

    public Maps(Settings settings) {
        this.settings = settings;
    }

    public List<World> activeWorlds = new ArrayList<>();
    public HashMap<World, GameState> gameState = new HashMap<>();

    public String addGame() {
        if(settings.mainWorld() != null) {

            String mainWorldname = settings.mainWorld();
            String newWorld = settings.mainWorld() + "_" + System.currentTimeMillis();

            File main = new File(Bukkit.getPluginManager().getPlugin("Pirates").getDataFolder().getParent(), mainWorldname);
            if(main.exists()) {
                if(mv.cloneWorld(settings.mainWorld(), newWorld, null)) {
                    setGameState(Bukkit.getWorld(newWorld), GameState.WAITING);
                    return newWorld;
                }
            }
        }

        return null;
    }

    public void deleteWorld(String s) {
        if(Bukkit.getWorld(s) != null) {
            Bukkit.unloadWorld(Bukkit.getWorld(s), false);
            File world = new File(Bukkit.getPluginManager().getPlugin("Pirates").getDataFolder().getParent(), s);
            world.delete();
        }
    }

    public void setGameState(World w, GameState state) {
        if(gameState.get(w) == null) {
            gameState.put(w, state);
        } else {
            gameState.replace(w, state);
        }
    }

    public GameState getState(World w) {
        if(gameState.get(w) != null) {
            return gameState.get(w);
        }

        return null;
    }



}
