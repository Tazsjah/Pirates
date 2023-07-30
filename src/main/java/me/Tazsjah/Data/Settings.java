package me.Tazsjah.Data;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Settings {

    private File f;
    private FileConfiguration config;

    // Config Options

    public void loadConfig() {
        this.f = new File(Bukkit.getPluginManager().getPlugin("Pirates").getDataFolder(), "config.yml");
        this.config = YamlConfiguration.loadConfiguration(f);
    }

    public String mainWorld() {
        loadConfig();
        return config.getString("main-world");
    }

    public void setMainLocation(Location loc, String s) {
        if(s == "pirate") {
            config.set("main.location.pirates", loc);
        }

        if(s == "guard") {
            config.set("main.location.guard", loc);
        }

        if(s == "dead") {
            config.set("main.location.pirates", loc);
        }
    }

    public Location getMainLocation(String s) {
        if(s == "pirate") {
            config.getLocation("main.location.pirates");
        }

        if(s == "guard") {
            config.getLocation("main.location.guard");
        }

        if(s == "dead") {
            config.getLocation("main.location.pirates");
        }

        return null;
    }

    // Messages Options

    private File m;
    private FileConfiguration msg;

    public void loadMsg() {
        this.m = new File(Bukkit.getPluginManager().getPlugin("Pirates").getDataFolder(), "messages.yml");
        this.msg = YamlConfiguration.loadConfiguration(m);
    }

    public Object getMsg(String s) {
        loadMsg();
        return msg.get(s);
    }

}
