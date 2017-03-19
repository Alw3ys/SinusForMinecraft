package com.alw3ys.sinusforminecraft.cmd;

import com.alw3ys.sinusforminecraft.SinusForMinecraft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.List;

public class CmdToggleBroadcast implements CommandExecutor {

    private final SinusForMinecraft plugin;

    public CmdToggleBroadcast(SinusForMinecraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) return true;

        final Player player = (Player) sender;
        final ConfigurationSection toggleBroadcast = plugin.getConfig().getConfigurationSection("toggleBroadcast");


        if (!player.hasPermission("sinusbotminecraft.broadcast.toggle")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', toggleBroadcast.getString("noPermissions")));
            return true;
        }

        List<Player> playerList = plugin.getPlayerList();

        if (!playerList.contains(player)) {
            playerList.add(player);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', toggleBroadcast.getString("enabled")));
        } else {
            playerList.remove(player);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', toggleBroadcast.getString("disabled")));
        }
        return false;
    }
}