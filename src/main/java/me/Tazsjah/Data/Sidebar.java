package me.Tazsjah.Data;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.List;

public class Sidebar {

    Settings settings;

    public Sidebar(Settings settings) {
        this.settings = settings;
    }

    public void set(Boolean in_game, Player player, World world, GameState state, String team, int time, int emerald, int total_games) {

        if(in_game) {
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective obj = board.registerNewObjective("PvP", "dummy",
                    ChatColor.translateAlternateColorCodes('&', (String) settings.getMsg("scoreboard.title")));
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);

            if(state == GameState.GAME) {
                List<String> lines = (List<String>) settings.getMsg("scoreboard.in-game.game");
                int size = lines.size();
                for (String linestring : lines) {
                    size--;
                    Team line = board.registerNewTeam("line" + size);
                    line.addEntry(ChatColor.translateAlternateColorCodes('&', linestring
                            .replace("$player", player.getName())
                            .replace("$team", team)
                            .replace("$emerald", emerald + "")
                            .replace("$state", state.toString())
                            .replace("$time", time + "")
                            .replace("$world", world.getName())
                    ));
                    obj.getScore(ChatColor.translateAlternateColorCodes('&', linestring)).setScore(size);
                }
            }

            if(state == GameState.WAITING) {
                List<String> lines = (List<String>) settings.getMsg("scoreboard.in-game.waiting");
                int size = lines.size();
                for (String linestring : lines) {
                    size--;
                    Team line = board.registerNewTeam("line" + size);
                    line.addEntry(ChatColor.translateAlternateColorCodes('&', linestring
                            .replace("$player", player.getName())
                            .replace("$team", team)
                            .replace("$emerald", emerald + "")
                            .replace("$state", state.toString())
                            .replace("$time", time + "")
                            .replace("$world", world.getName())
                    ));
                    obj.getScore(ChatColor.translateAlternateColorCodes('&', linestring)).setScore(size);
                }
            }

            if(state == GameState.GAME) {
                List<String> lines = (List<String>) settings.getMsg("scoreboard.in-game.end");
                int size = lines.size();
                for (String linestring : lines) {
                    size--;
                    Team line = board.registerNewTeam("line" + size);
                    line.addEntry(ChatColor.translateAlternateColorCodes('&', linestring
                            .replace("$player", player.getName())
                            .replace("$team", team)
                            .replace("$emerald", emerald + "")
                            .replace("$state", state.toString())
                            .replace("$time", time + "")
                            .replace("$world", world.getName())
                    ));
                    obj.getScore(ChatColor.translateAlternateColorCodes('&', linestring)).setScore(size);
                }

                player.setScoreboard(board);
            }


        } else {
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective obj = board.registerNewObjective("PvP", "dummy",
                    ChatColor.translateAlternateColorCodes('&', (String) settings.getMsg("scoreboard.title")));
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);

            List<String> lines = (List<String>) settings.getMsg("scoreboard.out-game");
            int size = lines.size();
            for (String linestring : lines) {
                size--;
                Team line = board.registerNewTeam("line"+size);
                line.addEntry(ChatColor.translateAlternateColorCodes('&', linestring
                                .replace("$player", player.getName())
                                .replace("$online", Bukkit.getOnlinePlayers().size() + "")
                                .replace("$total_games", total_games + "")));
                obj.getScore(ChatColor.translateAlternateColorCodes('&', linestring
                        .replace("$player", player.getName())
                        .replace("$online", Bukkit.getOnlinePlayers().size() + "")
                        .replace("$total_games", total_games + ""))).setScore(size);
            }

            player.setScoreboard(board);
        }
    }

}
