package com.alw3ys.sinusforminecraft.utils;

import com.alw3ys.sinusforminecraft.SinusForMinecraft;
import com.alw3ys.sinusforminecraft.TrackManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;

public class TrackUtils {

    private final SinusForMinecraft plugin;

    public TrackUtils(SinusForMinecraft plugin) {
        this.plugin = plugin;
    }

    public void updateLastTrack(final TrackManager.Track track) {

        TrackManager.setCurrentTrack(track);

        final ConfigurationSection broadcast = plugin.getConfig().getConfigurationSection("broadcast");
        final boolean enable = broadcast.getBoolean("enable");
        final List<Player> playerList = plugin.getPlayerList();

        if (enable && playerList.size() > 0) {
            for (Player player : playerList) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        broadcast.getString("message").replace("%title%", track.getTitle())));
            }
        }
    }

    public TrackManager.Track getTrackFromJSONString(final String message) {

        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) new JSONParser().parse(message);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String artist = (String) jsonObject.get("artist");
        String title = (String) jsonObject.get("title");
        Long duration = (Long) jsonObject.get("duration");

        return new TrackManager.Track(artist, title, duration);
    }
}