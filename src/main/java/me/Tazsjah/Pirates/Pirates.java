package me.Tazsjah.Pirates;

import me.Tazsjah.Data.Maps;
import me.Tazsjah.Data.PlayerData;
import me.Tazsjah.Data.Settings;
import me.Tazsjah.Handlers.PlayerHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Pirates extends JavaPlugin {

    public void onEnable() {

        File c = new File(Bukkit.getPluginManager().getPlugin("Pirates").getDataFolder(), "config.yml");
        File m = new File(Bukkit.getPluginManager().getPlugin("Pirates").getDataFolder(), "messages.yml");

        if(!c.exists()) {
            this.saveResource("config.yml", false);
        }

        if(!m.exists()) {
            this.saveResource("messages.yml", false);
        }

        Settings settings = new Settings();
        Maps maps = new Maps(settings);
        PlayerData data = new PlayerData(maps);

        Bukkit.getPluginManager().registerEvents(new PlayerHandler(data), this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Loading pirates");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Disabling pirates");
    }


}
