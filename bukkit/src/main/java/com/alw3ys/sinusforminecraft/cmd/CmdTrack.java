package com.alw3ys.sinusforminecraft.cmd;

import com.alw3ys.sinusforminecraft.SinusForMinecraftPlugin;
import com.alw3ys.sinusforminecraft.TrackManager;
import com.alw3ys.sinusforminecraft.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

@RequiredArgsConstructor
public class CmdTrack implements CommandExecutor {

    private final SinusForMinecraftPlugin plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        final ConfigurationSection trackInfo = plugin.getConfig().getConfigurationSection("trackInfo");

        if (!sender.hasPermission("sinusbotminecraft.track.info")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', trackInfo.getString("noPermissions")));
            return true;
        }

        final TrackManager.Track currentTrack = TrackManager.getCurrentTrack();
        final ConfigurationSection separators = trackInfo.getConfigurationSection("separators");
        final boolean enable = separators.getBoolean("enable");

        if (currentTrack == null) {
            if (enable) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', separators.getString("message")));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', trackInfo.getString("noTrack")));
            if (enable) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', separators.getString("message")));
            return true;
        }

        if (enable) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', separators.getString("message")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', trackInfo.getString("artist").replace("%artist%", currentTrack.getArtist())));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', trackInfo.getString("title").replace("%title%", currentTrack.getTitle())));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', trackInfo.getString("duration").replace("%duration%", TimeUtils.getTimeFormat(currentTrack.getDuration()))));
        if (enable) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', separators.getString("message")));

        return false;
    }
}